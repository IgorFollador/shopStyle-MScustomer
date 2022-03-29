package uol.compass.shopStyle.customer.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uol.compass.shopStyle.customer.dto.UserDTO;
import uol.compass.shopStyle.customer.dto.UserFormDTO;
import uol.compass.shopStyle.customer.entity.User;
import uol.compass.shopStyle.customer.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

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
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    @Transactional
    public UserDTO update(User user , UserFormDTO form) {
        if(form.getFirstName() != null)user.setFirstName(form.getFirstName());
        if(form.getLastName() != null)user.setLastName(form.getLastName());
        if(form.getSex() != null)user.setSex(form.getSex());
        if(form.getCpf() != null)user.setCpf(form.getCpf());
        if(form.getBirthdate() != null)user.setBirthdate(form.getBirthdate());
        if(form.getEmail() != null)user.setEmail(form.getEmail());
        if(form.getPassword() != null)user.setPassword(form.getPassword());
        if(form.getActive() != null)user.setActive(form.getActive());

        this.userRepository.save(user);
        return mapper.map(user, UserDTO.class);

    }
}
