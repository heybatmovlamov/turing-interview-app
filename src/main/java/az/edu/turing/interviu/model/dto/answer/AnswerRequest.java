package az.edu.turing.interviu.model.dto.answer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnswerRequest {
    private Long questionId;
    private String selectedAnswer;
}
