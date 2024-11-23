package com.microservice.foroum.forum.infrastructure.persistence.jpa.repositories;

import com.microservice.foroum.forum.domain.model.aggregates.Question;
import com.microservice.foroum.forum.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByUserId(UserId userId);
    boolean existsByQuestionText(String questionText);
}
