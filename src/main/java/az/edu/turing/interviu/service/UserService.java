package az.edu.turing.interviu.service;

import az.edu.turing.interviu.dao.repository.UserRepository;
import az.edu.turing.interviu.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final NotificationService notificationService;
    private final PasswordEncoder passwordEncoder;
    public String getPoint(){
        return  "100";
    }



}
