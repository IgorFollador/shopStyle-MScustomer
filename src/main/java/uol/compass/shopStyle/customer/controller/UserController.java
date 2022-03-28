package uol.compass.shopStyle.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uol.compass.shopStyle.customer.dto.UserDTO;
import uol.compass.shopStyle.customer.dto.UserFormDTO;
import uol.compass.shopStyle.customer.entity.User;
import uol.compass.shopStyle.customer.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody @Valid UserFormDTO form) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(form));
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(@PageableDefault Pageable page) {
        return ResponseEntity.ok(userService.findAll(page));
    }

}
