package az.edu.turing.interviu.controller;

import az.edu.turing.interviu.model.dto.QuestionsDto;
import az.edu.turing.interviu.model.dto.UserDto;
import az.edu.turing.interviu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        UserDto register = userService.register(userDto);
        return ResponseEntity.ok(register);
    }

    @GetMapping("/questions")
    public ResponseEntity<QuestionsDto> getQuestions() {

    }
}
