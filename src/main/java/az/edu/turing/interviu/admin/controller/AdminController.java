package az.edu.turing.interviu.admin.controller;

import az.edu.turing.interviu.admin.service.AdminQuestionsService;
import az.edu.turing.interviu.admin.service.AdminUserService;
import az.edu.turing.interviu.mapper.UserMapper;
import az.edu.turing.interviu.model.dto.questions.QuestionsDto;
import az.edu.turing.interviu.model.dto.user.UserDto;
import az.edu.turing.interviu.model.enums.CategoryEnums;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(adminUserService.getAll());
    }
    @PostMapping("/question/create")
    public ResponseEntity<QuestionsDto> createUser(@RequestBody QuestionsDto questionsDto){
        return ResponseEntity.ok(adminQuestionsService.createQuestions(questionsDto));
    }
    @GetMapping("/questions/{category}")
    public ResponseEntity<List<QuestionsDto>> getQuestions(@PathVariable CategoryEnums category){
        return ResponseEntity.ok(adminQuestionsService.getQuestions(category));
    }
}
