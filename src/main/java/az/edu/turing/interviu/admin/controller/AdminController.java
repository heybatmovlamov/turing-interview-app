package az.edu.turing.interviu.admin.controller;

import az.edu.turing.interviu.admin.service.AdminQuestionsService;
import az.edu.turing.interviu.admin.service.AdminUserService;
import az.edu.turing.interviu.mapper.UserMapper;
import az.edu.turing.interviu.model.dto.QuestionsDto;
import az.edu.turing.interviu.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminUserService adminUserService;
    private final AdminQuestionsService adminQuestionsService;
    private final UserMapper userMapper;

    @PostMapping("/user/create")
    public ResponseEntity<UserDto> createUser(UserDto userDto){
        return ResponseEntity.ok(adminUserService.createUser(userDto));
    }

    @PostMapping("/question/create")
    public ResponseEntity<QuestionsDto> createUser(QuestionsDto questionsDto){
        return ResponseEntity.ok(adminQuestionsService.createQuestions(questionsDto));
    }
}
