package com.microservice.foroum.forum.interfaces.rest.transform;

import com.microservice.foroum.forum.domain.model.commands.CreateQuestionCommand;
import com.microservice.foroum.forum.interfaces.rest.resources.CreateQuestionResource;

public class CreateQuestionCommandFromResourceAssembler {
    public static CreateQuestionCommand toCommandFromResource(CreateQuestionResource resource){
        return new CreateQuestionCommand(
                resource.categoryId(),
                resource.userId(),
                resource.questionText()
        );
    }
}
