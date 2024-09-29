package az.edu.turing.interviu.service.user;

import az.edu.turing.interviu.dao.entity.UserEntity;
import az.edu.turing.interviu.dao.repository.UserRepository;
import az.edu.turing.interviu.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserEntity getUserData(){
        //return user point
        return null;
    }


}
