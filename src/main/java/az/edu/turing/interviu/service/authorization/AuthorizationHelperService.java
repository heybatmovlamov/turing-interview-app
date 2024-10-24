package az.edu.turing.interviu.service.authorization;

import az.edu.turing.interviu.jwt.JwtService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationHelperService {
    private final JwtService jwtService;

    public String getEmail(String authorization) {
       String token = authorization.substring(7);
       return jwtService.extractUsername(token);
    }
    public String getRole(String authorization) {
        String token = authorization.substring(7); // "Bearer " kısmını atla
        return jwtService.extractClaim(token, Claims::getSubject); // Rol bilgisini döndür
    }

}
