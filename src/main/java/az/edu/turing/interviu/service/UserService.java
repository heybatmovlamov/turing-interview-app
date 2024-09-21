package az.edu.turing.interviu.service;

import az.edu.turing.interviu.dao.entity.UserEntity;
import az.edu.turing.interviu.dao.repository.UserRepository;
import az.edu.turing.interviu.mapper.UserMapper;
import az.edu.turing.interviu.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final NotificationService notificationService;

    public UserDto register(UserDto userDto) {

        UserEntity userEntity = userMapper.dtoToEntity(userDto);
        userEntity.setLoginTime(Timestamp.valueOf(LocalDateTime.now()));
        userEntity = userRepository.save(userEntity);

        return userMapper.entityToDto(userEntity);
    }

    public

}
