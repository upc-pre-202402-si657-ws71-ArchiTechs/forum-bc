package com.microservice.foroum.forum.domain.services;

import com.microservice.foroum.forum.domain.model.commands.CreateCategoryCommand;
import com.microservice.foroum.forum.domain.model.commands.DeleteCategoryCommand;
import com.microservice.foroum.forum.domain.model.commands.UpdateCategoryCommand;
import com.microservice.foroum.forum.domain.model.entities.Category;

import java.util.Optional;

public interface CategoryCommandService {
    Long handle(CreateCategoryCommand command);
    Optional<Category> handle(UpdateCategoryCommand command);
    void handle(DeleteCategoryCommand command);
}
