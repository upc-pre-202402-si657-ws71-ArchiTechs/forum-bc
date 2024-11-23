package com.microservice.foroum.forum.interfaces.rest.transform;

import com.microservice.foroum.forum.domain.model.aggregates.Answer;
import com.microservice.foroum.forum.interfaces.rest.resources.AnswerResource;

public class AnswerResourceFromEntityAssembler {
    public static AnswerResource toResourceFromEntity(Answer entity) {
        return new AnswerResource(
                entity.getId(),
                entity.getUserId().userId(),
                entity.getQuestion().getId(),
                entity.getAnswerText()
        );

    }
}
