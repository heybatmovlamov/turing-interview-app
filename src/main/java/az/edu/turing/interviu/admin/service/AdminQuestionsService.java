package az.edu.turing.interviu.admin.service;

import az.edu.turing.interviu.dao.entity.QuestionsEntity;
import az.edu.turing.interviu.dao.repository.QuestionsRepository;
import az.edu.turing.interviu.mapper.QuestionsMapper;
import az.edu.turing.interviu.model.dto.QuestionsDto;
import az.edu.turing.interviu.model.enums.CategoryEnums;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminQuestionsService {

    private final QuestionsRepository questionsRepository;
    private final QuestionsMapper questionsMapper;

    public QuestionsDto createQuestions(QuestionsDto questionsDto) {
        QuestionsEntity save = questionsRepository.save(questionsMapper.dtoToEntity(questionsDto));
        return questionsMapper.entityToDto(save);
    }
    public List<QuestionsDto> getQuestions(CategoryEnums categoryEnums){
        List<QuestionsEntity> byCategory = questionsRepository.findByCategory(categoryEnums.name());
        List<QuestionsDto> questionsDtos = questionsMapper.entityListToDtoList(byCategory);
        return questionsDtos;
    }
}
