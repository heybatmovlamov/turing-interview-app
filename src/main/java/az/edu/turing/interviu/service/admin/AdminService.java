package az.edu.turing.interviu.service.admin;

import az.edu.turing.interviu.dao.entity.UserEntity;
import az.edu.turing.interviu.dao.repository.UserRepository;
import az.edu.turing.interviu.mapper.UserMapper;
import az.edu.turing.interviu.model.dto.user.UserDto;
import az.edu.turing.interviu.model.enums.CategoryEnums;
import az.edu.turing.interviu.model.enums.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public void userToAdmin(String userEmail){
            UserEntity byEmail = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
            byEmail.setRole(Role.ROLE_ADMIN);
            byEmail.setCategory(CategoryEnums.ADMIN);
            userRepository.save(byEmail);
            log.info(byEmail.toString());

            log.info("Can't change user role ");
    }
    public UserDto createUser(UserDto user) {
        UserEntity save = userRepository.save(userMapper.dtoToEntity(user));
        return userMapper.entityToDto(save);
    }

    public List<UserDto> getAll() {
        List<UserEntity> all = userRepository.findAll();

        return   userMapper.entityListToDtoList(all);
    }

    public String getUserByEmail(String email){
        return "user point ";
    }

    public String updateQuestion(Integer number , CategoryEnums categoryEnums){
        //todo modify questions
        return "test";
    }

    public String modifyPoint(){
        return "modify";//todo modify user point on database
    }
}
