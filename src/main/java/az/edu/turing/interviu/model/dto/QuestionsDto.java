package az.edu.turing.interviu.model.dto;

import az.edu.turing.interviu.model.enums.CategoryEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionsDto {
    private String questions;
    private CategoryEnums category;
}
