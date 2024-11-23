package com.microservice.foroum.forum.domain.services;

import com.microservice.foroum.forum.domain.model.aggregates.Question;
import com.microservice.foroum.forum.domain.model.commands.CreateQuestionCommand;
import com.microservice.foroum.forum.domain.model.commands.DeleteQuestionCommand;
import com.microservice.foroum.forum.domain.model.commands.UpdateQuestionCommand;

import java.util.Optional;

public interface QuestionCommandService {
    Long handle(CreateQuestionCommand command);
    Optional<Question> handle(UpdateQuestionCommand command);
    void handle(DeleteQuestionCommand command);


}
