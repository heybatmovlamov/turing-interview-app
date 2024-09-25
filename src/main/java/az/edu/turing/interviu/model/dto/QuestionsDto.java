package az.edu.turing.interviu.model.dto;

import az.edu.turing.interviu.model.enums.CategoryEnums;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsDto {

    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String category;
}
