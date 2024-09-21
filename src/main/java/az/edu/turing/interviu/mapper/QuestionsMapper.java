package az.edu.turing.interviu.mapper;

import az.edu.turing.interviu.dao.entity.QuestionsEntity;
import az.edu.turing.interviu.dao.entity.UserEntity;
import az.edu.turing.interviu.model.dto.QuestionsDto;
import az.edu.turing.interviu.model.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface QuestionsMapper {
    QuestionsEntity dtoToEntity(QuestionsDto dto);
    QuestionsDto entityToDto(QuestionsEntity entity);

}
