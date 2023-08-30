package forhack.hack.repository;

import forhack.hack.entity.PersonalAccount;
import forhack.hack.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByPersonalAccount(PersonalAccount personalAccount);

    List<User> findAll();
}