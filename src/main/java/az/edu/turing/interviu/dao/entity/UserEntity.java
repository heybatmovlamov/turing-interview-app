package az.edu.turing.interviu.dao.entity;

import az.edu.turing.interviu.model.enums.CategoryEnums;
import az.edu.turing.interviu.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String password;

    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    private CategoryEnums category;

    private Role role = Role.USER_ROLE;

    private Timestamp loginTime;

}
