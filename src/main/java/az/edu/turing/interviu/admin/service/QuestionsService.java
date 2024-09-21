package az.edu.turing.interviu.admin.service;

import az.edu.turing.interviu.dao.entity.QuestionsEntity;
import az.edu.turing.interviu.dao.repository.QuestionsRepository;
import az.edu.turing.interviu.mapper.QuestionsMapper;
import az.edu.turing.interviu.model.dto.QuestionsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuestionsService {

    private final QuestionsRepository questionsRepository;
    private final QuestionsMapper questionsMapper;

    public QuestionsDto createQuestions(QuestionsDto questionsDto) {
        QuestionsEntity save = questionsRepository.save(questionsMapper.dtoToEntity(questionsDto));
        return questionsMapper.entityToDto(save);
    }
}
