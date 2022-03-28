package uol.compass.shopStyle.customer.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uol.compass.shopStyle.customer.dto.UserDTO;
import uol.compass.shopStyle.customer.dto.UserFormDTO;
import uol.compass.shopStyle.customer.entity.User;
import uol.compass.shopStyle.customer.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public UserDTO save(UserFormDTO form) {
        User userEntity = this.userRepository.save(mapper.map(form, User.class));
        return mapper.map(userEntity, UserDTO.class);
    }

    @Override
    public Page<UserDTO> findAll(Pageable page) {
        Page<User> users = this.userRepository.findAll(page);
        return users.map(UserDTO::new);
    }
}
