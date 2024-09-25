package az.edu.turing.interviu.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "answers")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;  // İstifadəçi cavabı verən istifadəçini bildirir

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionsEntity question;  // Hansı sual üçün cavab verilib

    private String selectedAnswer;  // İstifadəçinin seçdiyi cavab
    private boolean isCorrect;  // Cavabın doğru olub-olmadığı

}

