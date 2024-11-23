package com.microservice.foroum.forum.interfaces.rest.transform;

import com.microservice.foroum.forum.domain.model.commands.UpdateCategoryCommand;
import com.microservice.foroum.forum.interfaces.rest.resources.UpdateCategoryResource;

public class UpdateCategoryCommandFromResourceAssembler {
    public static UpdateCategoryCommand toCommandFromResource(Long categoryId, UpdateCategoryResource resource){
        return new UpdateCategoryCommand(
                categoryId,
                resource.name()
        );
    }
}
