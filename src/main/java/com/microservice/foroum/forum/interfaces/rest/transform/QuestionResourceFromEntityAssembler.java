package com.microservice.foroum.forum.interfaces.rest.transform;

import com.microservice.foroum.forum.domain.model.aggregates.Question;
import com.microservice.foroum.forum.interfaces.rest.resources.QuestionResource;

public class QuestionResourceFromEntityAssembler {
    public static QuestionResource toResourceFromEntity(Question entity) {
        return new QuestionResource(
                entity.getId(),
                entity.getCategory().getId(),
                entity.getUserId().userId(),
                entity.getQuestionText(),
                entity.getCreatedAt()
        );
    }

}
