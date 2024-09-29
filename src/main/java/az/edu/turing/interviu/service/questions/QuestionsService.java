package az.edu.turing.interviu.service.questions;

import az.edu.turing.interviu.dao.entity.AnswerEntity;
import az.edu.turing.interviu.dao.entity.QuestionsEntity;
import az.edu.turing.interviu.dao.entity.UserEntity;
import az.edu.turing.interviu.dao.repository.AnswerRepository;
import az.edu.turing.interviu.dao.repository.QuestionsRepository;
import az.edu.turing.interviu.dao.repository.UserRepository;
import az.edu.turing.interviu.mapper.QuestionsMapper;
import az.edu.turing.interviu.model.dto.answer.AnswerRequest;
import az.edu.turing.interviu.model.dto.questions.QuestionsDto;
import az.edu.turing.interviu.model.enums.CategoryEnums;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class QuestionsService {

    private final UserRepository userRepository;
    private final QuestionsRepository questionsRepository;
    private final QuestionsMapper questionsMapper;
    private final AnswerRepository answerRepository;


    public List<QuestionsDto> getQuestions(String email,Integer page) {

        UserEntity byEmail = userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("user not found"));

        CategoryEnums category = byEmail.getCategory();
        PageRequest pageRequest = PageRequest.of(page, 4);

        Page<QuestionsEntity> questionPage = questionsRepository.findByCategory(category, pageRequest);
        return questionsMapper.entityListToDtoList(questionPage.getContent());
    }


    public void selectAnswers(String email, List<AnswerRequest> answerRequests) {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        List<AnswerEntity> answerEntities = new ArrayList<>();

        for (AnswerRequest request : answerRequests) {
            QuestionsEntity question = questionsRepository.findByIdAndCategory(request.getQuestionId(),user.getCategory())
                    .orElseThrow(() -> new IllegalArgumentException("Question not found"));

            boolean isCorrect = question.getRightAnswer().equalsIgnoreCase(request.getSelectedAnswer());

            AnswerEntity answer = new AnswerEntity();
            answer.setUser(user);
            answer.setQuestion(question);
            answer.setSelectedAnswer(request.getSelectedAnswer());
            answer.setCorrect(isCorrect);

            answerEntities.add(answer);
        }
        answerRepository.saveAll(answerEntities);
    }
}
