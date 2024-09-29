package az.edu.turing.interviu.service.auth;

import az.edu.turing.interviu.dao.entity.UserEntity;
import az.edu.turing.interviu.dao.repository.UserRepository;
import az.edu.turing.interviu.jwt.JwtService;
import az.edu.turing.interviu.mapper.UserMapper;
import az.edu.turing.interviu.model.dto.TokenDto;
import az.edu.turing.interviu.model.dto.user.UserDto;
import az.edu.turing.interviu.model.dto.user.UserLoginRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;


    public TokenDto authenticateLogin(UserLoginRequest userLoginRequest) {
        TokenDto tokenDto = new TokenDto();
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
                userLoginRequest.getEmail(), userLoginRequest.getPassword()
        );
        authenticationManager.authenticate(authenticationToken);
        tokenDto.setToken(jwtService.generateToken(userLoginRequest.getEmail()));
        return tokenDto;
    }

    public TokenDto authenticateRegister(UserDto userDto) {
        TokenDto tokenDto = new TokenDto();
        UserEntity userEntity = userMapper.dtoToEntity(userDto);
        userEntity.setLoginTime(Timestamp.valueOf(LocalDateTime.now()));
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(userEntity);

        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
                userDto.getEmail(), userDto.getPassword()
        );
        authenticationManager.authenticate(authenticationToken);
        tokenDto.setToken(jwtService.generateToken(userDto.getEmail()));
        return tokenDto;
    }
}
