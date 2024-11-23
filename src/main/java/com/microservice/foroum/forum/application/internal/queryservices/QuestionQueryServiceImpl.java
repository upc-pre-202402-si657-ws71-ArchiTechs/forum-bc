package com.microservice.foroum.forum.application.internal.queryservices;

import com.microservice.foroum.forum.domain.model.aggregates.Question;
import com.microservice.foroum.forum.domain.model.queries.GetAllQuestionsByUserIdQuery;
import com.microservice.foroum.forum.domain.model.queries.GetAllQuestionsQuery;
import com.microservice.foroum.forum.domain.model.queries.GetQuestionByIdQuery;
import com.microservice.foroum.forum.domain.services.QuestionQueryService;
import com.microservice.foroum.forum.infrastructure.persistence.jpa.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionQueryServiceImpl implements QuestionQueryService {

    private final QuestionRepository questionRepository;

    public QuestionQueryServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public List<Question> handle(GetAllQuestionsQuery query) {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> handle(GetAllQuestionsByUserIdQuery query) {
        return questionRepository.findByUserId(query.userId());    
    }

    @Override
    public Optional<Question> handle(GetQuestionByIdQuery query) {
        return questionRepository.findById(query.questionId());
    }
}
