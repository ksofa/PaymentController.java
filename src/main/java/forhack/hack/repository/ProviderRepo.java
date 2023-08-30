package forhack.hack.repository;

import forhack.hack.entity.Provider;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProviderRepo extends CrudRepository<Provider, Long> {

    Optional<Provider> findByName(String name);

    List<Provider> findAll();

}
