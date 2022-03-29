package uol.compass.shopStyle.customer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uol.compass.shopStyle.customer.dto.UserDTO;
import uol.compass.shopStyle.customer.dto.UserFormDTO;
import uol.compass.shopStyle.customer.entity.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserService {

    UserDTO save(UserFormDTO form);

    Optional<User> findById(Long id);

    UserDTO update(User user, UserFormDTO form);
}
