package sarahguarneri.BEU2W2L5.services;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarahguarneri.BEU2W2L5.DAO.UserDAO;
import sarahguarneri.BEU2W2L5.entites.User;
import sarahguarneri.BEU2W2L5.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> getUsers(){
        return userDAO.findAll();
    };

    public User findById(UUID id){
        return userDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id){
        User found = this.findById(id);
        userDAO.delete(found);
    }

    public User save(User body){
        userDAO.findById(body.getId()).ifPresent(user -> {
            try {
                throw new BadRequestException("utente già esistente");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        });
        User newUser = new User();
        newUser.setUsername(body.getUsername());
        newUser.setName(body.getName());
        newUser.setSurname(body.getSurname());
        newUser.setEmail(body.getEmail());
        newUser.setDevices(body.getDevices());
        return userDAO.save(newUser);
    }

    public User findByIdAndUpdate(UUID id, User body){
       User found = this.findById(id);
       found.setSurname(body.getSurname());
       found.setUsername(body.getUsername());
       found.setName(body.getName());
       found.setEmail(body.getEmail());
       found.setDevices(body.getDevices());
       return userDAO.save(found);
    }
}
