package az.edu.turing.interviu.dao.repository;

import az.edu.turing.interviu.dao.entity.QuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<QuestionsEntity, Long> {
    List<QuestionsEntity> findByCategory(String category);
//    void saveQuestions(QuestionsEntity questionsEntity);
}
