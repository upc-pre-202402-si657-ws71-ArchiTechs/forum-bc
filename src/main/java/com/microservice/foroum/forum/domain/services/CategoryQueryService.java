package com.microservice.foroum.forum.domain.services;

import com.microservice.foroum.forum.domain.model.entities.Category;
import com.microservice.foroum.forum.domain.model.queries.GetAllCategoriesQuery;
import com.microservice.foroum.forum.domain.model.queries.GetCategoryByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CategoryQueryService {
    List<Category> handle(GetAllCategoriesQuery query);
    Optional<Category> handle(GetCategoryByIdQuery query);
}
