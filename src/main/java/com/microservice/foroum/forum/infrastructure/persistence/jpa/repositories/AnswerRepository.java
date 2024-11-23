package com.microservice.foroum.forum.infrastructure.persistence.jpa.repositories;

import com.microservice.foroum.forum.domain.model.aggregates.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long questionId);
    boolean existsByAnswerTextAndQuestionId(String answerText, Long questionId);
}
