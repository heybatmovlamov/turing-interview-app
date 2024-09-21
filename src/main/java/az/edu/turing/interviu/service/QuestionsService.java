package az.edu.turing.interviu.service;

import az.edu.turing.interviu.dao.entity.QuestionsEntity;
import az.edu.turing.interviu.dao.repository.QuestionsRepository;
import az.edu.turing.interviu.dao.repository.UserRepository;
import az.edu.turing.interviu.model.enums.CategoryEnums;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionsService {
    private final UserRepository userRepository;
    private final QuestionsRepository questionsRepository;

    public List<QuestionsEntity> getQuestions(String email){
        CategoryEnums category = userRepository.findByEmail(email).get().getCategory();
        return questionsRepository.findByCategory(category.name());
    }
}
