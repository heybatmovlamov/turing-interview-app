package az.edu.turing.interviu.dao.entity;

import az.edu.turing.interviu.model.enums.CategoryEnums;
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

    private Timestamp loginTime;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PointEntity point;


}
