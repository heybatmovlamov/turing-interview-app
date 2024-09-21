package az.edu.turing.interviu.mapper;

import az.edu.turing.interviu.dao.entity.UserEntity;
import az.edu.turing.interviu.model.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity dtoToEntity(UserDto dto);
    UserDto entityToDto(UserEntity entity);
}
