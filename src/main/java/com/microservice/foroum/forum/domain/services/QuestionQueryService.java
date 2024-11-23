package com.microservice.foroum.forum.domain.services;

import com.microservice.foroum.forum.domain.model.aggregates.Question;
import com.microservice.foroum.forum.domain.model.queries.GetAllQuestionsByUserIdQuery;
import com.microservice.foroum.forum.domain.model.queries.GetAllQuestionsQuery;
import com.microservice.foroum.forum.domain.model.queries.GetQuestionByIdQuery;

import java.util.List;
import java.util.Optional;

public interface QuestionQueryService {
    List<Question> handle(GetAllQuestionsQuery query);
    List<Question> handle(GetAllQuestionsByUserIdQuery query);
    Optional<Question> handle(GetQuestionByIdQuery query);
}
