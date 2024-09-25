package az.edu.turing.interviu.service.authorization;

import az.edu.turing.interviu.jwt.JwtService;
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
}
