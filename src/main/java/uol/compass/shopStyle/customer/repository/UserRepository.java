package uol.compass.shopStyle.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uol.compass.shopStyle.customer.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
