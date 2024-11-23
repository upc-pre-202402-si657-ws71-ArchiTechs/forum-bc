package com.microservice.foroum.forum.interfaces.rest.transform;

import com.microservice.foroum.forum.domain.model.entities.Category;
import com.microservice.foroum.forum.interfaces.rest.resources.CategoryResource;

public class CategoryResourceFromEntityAssembler {
    public static CategoryResource toResourceFromEntity(Category entity){
        return new CategoryResource(
                entity.getId(),
                entity.getName()
        );
    }
}
