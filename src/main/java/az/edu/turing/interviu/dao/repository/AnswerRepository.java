package az.edu.turing.interviu.dao.repository;

import az.edu.turing.interviu.dao.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity ,Long> {

}
