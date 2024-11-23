package com.microservice.foroum.forum.interfaces.rest.transform;

import com.microservice.foroum.forum.domain.model.commands.CreateAnswerCommand;
import com.microservice.foroum.forum.interfaces.rest.resources.CreateAnswerResource;

public class CreateAnswerCommandFromResourceAssembler {
    public static CreateAnswerCommand toCommandFromResource(CreateAnswerResource resource){
        return new CreateAnswerCommand(
                resource.userId(),
                resource.questionId(),
                resource.answerText()
        );

    }
}
