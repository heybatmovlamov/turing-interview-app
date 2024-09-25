package az.edu.turing.interviu.model.dto.user;

import az.edu.turing.interviu.model.enums.CategoryEnums;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Size(max = 50, message = "Surname must be less than 50 characters")
    private String surname;

    @NotBlank(message = "Password cannot be blank")
    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    private String phone;

    @NotNull(message = "Specialty cannot be null")
    private CategoryEnums category;
}

