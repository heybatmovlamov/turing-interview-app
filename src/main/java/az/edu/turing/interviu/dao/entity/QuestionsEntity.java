package az.edu.turing.interviu.dao.entity;

import az.edu.turing.interviu.model.enums.CategoryEnums;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "questions")
public class QuestionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    @Enumerated(EnumType.STRING)
    private CategoryEnums category;
}
