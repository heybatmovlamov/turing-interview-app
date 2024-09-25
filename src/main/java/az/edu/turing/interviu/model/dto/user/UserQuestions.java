package az.edu.turing.interviu.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQuestions {
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
