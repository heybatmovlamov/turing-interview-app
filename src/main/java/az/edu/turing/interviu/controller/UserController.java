package az.edu.turing.interviu.controller;

import az.edu.turing.interviu.model.dto.QuestionsDto;
import az.edu.turing.interviu.service.QuestionsService;
import az.edu.turing.interviu.service.UserService;
import az.edu.turing.interviu.service.authorization.AuthorizationHelperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final QuestionsService questionsService;
    private final AuthorizationHelperService authorizationHelperService;

    @GetMapping("/questions")
    public List<QuestionsDto> getQuestions(@RequestHeader ("Authorization") String token ) {
        String email = authorizationHelperService.getEmail(token);
       return questionsService.getQuestions(email);
    }
//    @PostMapping("/select")
}
