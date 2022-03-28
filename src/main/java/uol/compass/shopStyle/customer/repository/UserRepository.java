package uol.compass.shopStyle.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uol.compass.shopStyle.customer.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {



}
