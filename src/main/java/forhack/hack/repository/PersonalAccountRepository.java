package forhack.hack.repository;


import forhack.hack.entity.PersonalAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalAccountRepository extends CrudRepository<PersonalAccount, Long> {

    Optional<PersonalAccount> findByAccount(String account);

}
