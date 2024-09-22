package az.edu.turing.interviu.admin.service;

import az.edu.turing.interviu.dao.entity.UserEntity;
import az.edu.turing.interviu.dao.repository.UserRepository;
import az.edu.turing.interviu.mapper.UserMapper;
import az.edu.turing.interviu.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto createUser(UserDto user) {
        UserEntity save = userRepository.save(userMapper.dtoToEntity(user));
        return  userMapper.entityToDto(save);
    }
}
