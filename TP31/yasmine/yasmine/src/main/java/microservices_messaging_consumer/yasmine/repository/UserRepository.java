package microservices_messaging_consumer.yasmine.repository;

import microservices_messaging_consumer.yasmine.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}