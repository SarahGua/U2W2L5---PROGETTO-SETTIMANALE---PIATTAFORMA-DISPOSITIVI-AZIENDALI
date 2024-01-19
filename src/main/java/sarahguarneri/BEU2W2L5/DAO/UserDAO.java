package sarahguarneri.BEU2W2L5.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sarahguarneri.BEU2W2L5.entites.User;

import java.util.UUID;

@Repository
public interface UserDAO extends JpaRepository<User, UUID> {
}
