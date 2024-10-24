package az.edu.turing.interviu.controller.admin;

import az.edu.turing.interviu.model.dto.user.AdminDto;
import az.edu.turing.interviu.service.admin.AdminQuestionsService;
import az.edu.turing.interviu.service.admin.AdminService;
import az.edu.turing.interviu.mapper.UserMapper;
import az.edu.turing.interviu.model.dto.questions.QuestionsDto;
import az.edu.turing.interviu.model.dto.user.UserDto;
import az.edu.turing.interviu.model.enums.CategoryEnums;
import az.edu.turing.interviu.service.authorization.AuthorizationHelperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin")
@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final AdminQuestionsService adminQuestionsService;
    private final UserMapper userMapper;
    private final AuthorizationHelperService helper;

    @PostMapping("/user/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(adminService.createUser(userDto));
    }
    @PatchMapping("/upgrade")
    public ResponseEntity<String> upgrade(@RequestBody AdminDto adminDto){
        adminService.userToAdmin(adminDto.getEmail());
        return ResponseEntity.ok("Changed user role");
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(adminService.getAll());
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
