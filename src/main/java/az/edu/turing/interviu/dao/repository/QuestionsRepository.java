package az.edu.turing.interviu.dao.repository;

import az.edu.turing.interviu.dao.entity.QuestionsEntity;
import az.edu.turing.interviu.model.enums.CategoryEnums;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionsRepository extends JpaRepository<QuestionsEntity, Long> {
    Page<QuestionsEntity> findByCategory(CategoryEnums category, Pageable pageable);
    Optional<QuestionsEntity> findByIdAndCategory(Long id, CategoryEnums category);
}
