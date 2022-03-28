package uol.compass.shopStyle.customer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uol.compass.shopStyle.customer.dto.UserDTO;
import uol.compass.shopStyle.customer.dto.UserFormDTO;

public interface UserService {

    UserDTO save(UserFormDTO form);

    Page<UserDTO> findAll(Pageable page);

}
