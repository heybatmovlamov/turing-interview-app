package az.edu.turing.interviu.mapper;

import az.edu.turing.interviu.dao.entity.UserEntity;
import az.edu.turing.interviu.model.dto.user.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity dtoToEntity(UserDto dto);
    UserDto entityToDto(UserEntity entity);
    List<UserDto> entityListToDtoList(List<UserEntity> entity);
}
