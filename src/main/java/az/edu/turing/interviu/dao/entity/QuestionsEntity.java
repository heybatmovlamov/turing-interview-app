package az.edu.turing.interviu.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "questions")
public class QuestionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  question;
    private String category;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserEntity user;
}
