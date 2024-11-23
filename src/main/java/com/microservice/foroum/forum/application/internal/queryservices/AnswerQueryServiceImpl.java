package com.microservice.foroum.forum.application.internal.queryservices;


import com.microservice.foroum.forum.domain.model.aggregates.Answer;
import com.microservice.foroum.forum.domain.model.queries.GetAllAnswersByQuestionIdQuery;
import com.microservice.foroum.forum.domain.model.queries.GetAllAnswersQuery;
import com.microservice.foroum.forum.domain.model.queries.GetAnswerByIdQuery;
import com.microservice.foroum.forum.domain.services.AnswerQueryService;
import com.microservice.foroum.forum.infrastructure.persistence.jpa.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerQueryServiceImpl implements AnswerQueryService {

    private final AnswerRepository answerRepository;

    public AnswerQueryServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> handle(GetAllAnswersByQuestionIdQuery query) {
       return answerRepository.findByQuestionId(query.questionId());
    }

    @Override
    public List<Answer> handle(GetAllAnswersQuery query) {
       return answerRepository.findAll();
    }

    @Override
    public Optional<Answer> handle(GetAnswerByIdQuery query) {
        return answerRepository.findById(query.answerId());
    }
}
