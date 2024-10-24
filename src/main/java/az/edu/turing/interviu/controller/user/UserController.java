package az.edu.turing.interviu.controller.user;

import az.edu.turing.interviu.model.dto.answer.AnswerRequest;
import az.edu.turing.interviu.model.dto.questions.QuestionsDto;
import az.edu.turing.interviu.service.questions.QuestionsService;
import az.edu.turing.interviu.service.authorization.AuthorizationHelperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final QuestionsService questionsService;
    private final AuthorizationHelperService authorizationHelperService;

    @GetMapping("/questions/{page}")
    public List<QuestionsDto> getQuestions(@RequestHeader("Authorization") String token, @PathVariable Integer page) {
        String email = authorizationHelperService.getEmail(token);
        return questionsService.getQuestions(email, page);
    }

    @PostMapping("/select")
    public String select(@RequestHeader ("Authorization") String token,@RequestBody List<AnswerRequest> answers) {
        String email = authorizationHelperService.getEmail(token);
        questionsService.selectAnswers(email,answers);
        return "success";
    }

}
