package com.microservice.foroum.forum.domain.services;

import com.microservice.foroum.forum.domain.model.aggregates.Answer;
import com.microservice.foroum.forum.domain.model.commands.CreateAnswerCommand;
import com.microservice.foroum.forum.domain.model.commands.DeleteAnswerCommand;
import com.microservice.foroum.forum.domain.model.commands.UpdateAnswerCommand;

import java.util.Optional;

public interface AnswerCommandService {
    Long handle(CreateAnswerCommand command);
    Optional<Answer> handle(UpdateAnswerCommand command);
    void handle(DeleteAnswerCommand command);
}
