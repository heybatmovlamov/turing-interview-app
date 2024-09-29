package az.edu.turing.interviu.mapper;

import az.edu.turing.interviu.dao.entity.QuestionsEntity;
import az.edu.turing.interviu.model.dto.questions.QuestionsDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface QuestionsMapper {
    QuestionsEntity dtoToEntity(QuestionsDto dto);
    QuestionsDto entityToDto(QuestionsEntity entity);
    List<QuestionsDto> entityListToDtoList(List<QuestionsEntity> entity);

}
