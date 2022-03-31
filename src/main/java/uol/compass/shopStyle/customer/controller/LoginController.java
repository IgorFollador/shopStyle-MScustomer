package uol.compass.shopStyle.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uol.compass.shopStyle.customer.dto.LoginDTO;
import uol.compass.shopStyle.customer.dto.LoginFormDTO;
import uol.compass.shopStyle.customer.service.LoginService;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/v1/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginDTO> login(@RequestBody @Valid LoginFormDTO body) {
        UsernamePasswordAuthenticationToken dataLogin = body.convert();

        try {
            Authentication authentication = authManager.authenticate(dataLogin);
            String token = loginService.createToken(authentication);
            return ResponseEntity.ok(new LoginDTO(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
