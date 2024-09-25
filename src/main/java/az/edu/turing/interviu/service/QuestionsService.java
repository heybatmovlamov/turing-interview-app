package az.edu.turing.interviu.service;

import az.edu.turing.interviu.dao.entity.QuestionsEntity;
import az.edu.turing.interviu.dao.entity.UserEntity;
import az.edu.turing.interviu.dao.repository.QuestionsRepository;
import az.edu.turing.interviu.dao.repository.UserRepository;
import az.edu.turing.interviu.mapper.QuestionsMapper;
import az.edu.turing.interviu.model.dto.QuestionsDto;
import az.edu.turing.interviu.model.enums.CategoryEnums;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionsService {
    private final UserRepository userRepository;
    private final QuestionsRepository questionsRepository;
    private final QuestionsMapper questionsMapper;

    public List<QuestionsDto> getQuestions(String email){
        Optional<UserEntity> byEmail = userRepository.findByEmail(email);
        CategoryEnums category = byEmail.get().getCategory();
        List<QuestionsEntity> byCategory = questionsRepository.findByCategory(category);
        return   questionsMapper.entityListToDtoList(byCategory);
    }
}
