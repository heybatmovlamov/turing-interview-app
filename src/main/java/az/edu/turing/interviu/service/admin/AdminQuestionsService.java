package az.edu.turing.interviu.service.admin;

import az.edu.turing.interviu.dao.entity.QuestionsEntity;
import az.edu.turing.interviu.dao.repository.QuestionsRepository;
import az.edu.turing.interviu.mapper.QuestionsMapper;
import az.edu.turing.interviu.model.dto.questions.QuestionsDto;
import az.edu.turing.interviu.model.enums.CategoryEnums;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<QuestionsEntity> byCategory = questionsRepository.findByCategory(categoryEnums, pageRequest);
        return  questionsMapper.entityListToDtoList(byCategory.getContent());
    }
}
