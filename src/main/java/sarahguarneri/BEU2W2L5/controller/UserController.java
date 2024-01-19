package sarahguarneri.BEU2W2L5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sarahguarneri.BEU2W2L5.entites.User;
import sarahguarneri.BEU2W2L5.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //GET http://localhost:3001/user
    //POST http://localhost:3001/user + body
    //PUT http://localhost:3001/user/:id + body
    //DELETE http://localhost:3001/user/:id
    //GET http://localhost:3001/user/:id

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    };

    @PostMapping
    public User postUser(@PathVariable User newUser){
        return userService.save(newUser);
    };

    @PutMapping("/{userId}")
    public User putUser (@PathVariable UUID id, @RequestBody User body){
        return userService.findByIdAndUpdate(id, body);
    };

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable UUID id){
        userService.findByIdAndDelete(id);
    };

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable UUID id){
        return userService.findById(id);
    };
}
