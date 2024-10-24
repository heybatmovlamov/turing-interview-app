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

    @Column(unique = true)
    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    private CategoryEnums category;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Timestamp loginTime;

}
