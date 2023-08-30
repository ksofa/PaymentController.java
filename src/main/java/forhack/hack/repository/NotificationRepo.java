package forhack.hack.repository;

import forhack.hack.entity.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends CrudRepository<Notification, Long> {
}
