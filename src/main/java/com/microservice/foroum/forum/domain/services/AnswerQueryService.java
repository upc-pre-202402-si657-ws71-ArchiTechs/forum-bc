package com.microservice.foroum.forum.domain.services;

import com.microservice.foroum.forum.domain.model.aggregates.Answer;
import com.microservice.foroum.forum.domain.model.queries.GetAllAnswersByQuestionIdQuery;
import com.microservice.foroum.forum.domain.model.queries.GetAllAnswersQuery;
import com.microservice.foroum.forum.domain.model.queries.GetAnswerByIdQuery;

import java.util.List;
import java.util.Optional;

public interface AnswerQueryService {
    List<Answer> handle(GetAllAnswersByQuestionIdQuery query);
    List<Answer> handle(GetAllAnswersQuery query);
    Optional<Answer> handle(GetAnswerByIdQuery query);
}
