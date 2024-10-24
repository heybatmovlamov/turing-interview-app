package az.edu.turing.interviu.model.dto.user;

import az.edu.turing.interviu.model.enums.CategoryEnums;
import az.edu.turing.interviu.model.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
@ToString
public class UserDto {

    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Size(max = 50, message = "Surname must be less than 50 characters")
    private String surname;

    @NotBlank(message = "Password cannot be blank")
    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be at least 8 characters long")//todo @password
    private String password;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    private String phone;

    private Role role = Role.ROLE_USER;

    @NotNull(message = "Specialty cannot be null")
    @Enumerated(EnumType.STRING)
    private CategoryEnums category;
}

