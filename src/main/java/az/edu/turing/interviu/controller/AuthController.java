package az.edu.turing.interviu.controller;

import az.edu.turing.interviu.model.dto.TokenDto;
import az.edu.turing.interviu.model.dto.UserDto;
import az.edu.turing.interviu.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<TokenDto> register(@RequestBody UserDto userDto) {
        TokenDto registeredToken = authService.authenticateRegister(userDto);
        return ResponseEntity.ok(registeredToken);
    }
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody UserDto userDto) {
        TokenDto tokenDto = authService.authenticateLogin(userDto);
        return ResponseEntity.ok(tokenDto);
    }
}