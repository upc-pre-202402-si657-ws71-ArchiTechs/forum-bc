package com.microservice.foroum.forum.interfaces.rest.transform;

import com.microservice.foroum.forum.domain.model.commands.CreateCategoryCommand;
import com.microservice.foroum.forum.interfaces.rest.resources.CreateCategoryResource;

public class CreateCategoryCommandFromResourceAssembler {
    public static CreateCategoryCommand toCommandFromResource(CreateCategoryResource command){
        return new CreateCategoryCommand(
                command.name()
        );
    }
}
