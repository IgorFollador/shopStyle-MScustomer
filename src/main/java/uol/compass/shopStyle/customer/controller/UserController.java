package uol.compass.shopStyle.customer.controller;

import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uol.compass.shopStyle.customer.dto.LoginDTO;
import uol.compass.shopStyle.customer.dto.UserDTO;
import uol.compass.shopStyle.customer.dto.UserFormDTO;
import uol.compass.shopStyle.customer.entity.User;
import uol.compass.shopStyle.customer.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody @Valid UserFormDTO form) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(form));
    }

    @GetMapping("/:{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        Optional<User> userEntity = userService.findById(id);
        if(userEntity.isPresent()) return ResponseEntity.ok().body(mapper.map(userEntity.get(), UserDTO.class));
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/:{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserFormDTO form) {
        Optional<User> userEntity = userService.findById(id);
        if(userEntity.isPresent()) return ResponseEntity.ok().body(userService.update(userEntity.get(), form));
        return ResponseEntity.notFound().build();
    }

}
