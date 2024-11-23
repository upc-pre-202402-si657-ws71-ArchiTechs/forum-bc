package com.microservice.foroum.forum.interfaces.rest.transform;

import com.microservice.foroum.forum.domain.model.commands.UpdateQuestionCommand;
import com.microservice.foroum.forum.interfaces.rest.resources.UpdateQuestionResource;

public class UpdateQuestionCommandFromResourceAssembler {
    public static UpdateQuestionCommand toCommandFromResource(Long questionId, UpdateQuestionResource resource){
        return new UpdateQuestionCommand(
                questionId,
                resource.categoryId(),
                resource.questionText()
        );
    }
}
