package com.microservice.foroum.forum.interfaces.rest.transform;

import com.microservice.foroum.forum.domain.model.commands.UpdateAnswerCommand;
import com.microservice.foroum.forum.interfaces.rest.resources.UpdateAnswerResource;

public class UpdateAnswerCommandFromResourceAssembler {
    public static UpdateAnswerCommand toCommandFromResource(Long answerId, UpdateAnswerResource resource){
        return new UpdateAnswerCommand(
                answerId,
                resource.answerText()
        );
    }
}
