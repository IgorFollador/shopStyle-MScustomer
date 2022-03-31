package uol.compass.shopStyle.customer.service;

import org.springframework.security.core.Authentication;

public interface LoginService {

    String createToken(Authentication authentication);

    boolean isTokenValid(String token);

    Long getIdUser(String token);
}
