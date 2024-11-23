package com.microservice.foroum.forum.application.internal.commandservices;

import com.microservice.foroum.forum.domain.model.commands.CreateCategoryCommand;
import com.microservice.foroum.forum.domain.model.commands.DeleteCategoryCommand;
import com.microservice.foroum.forum.domain.model.commands.UpdateCategoryCommand;
import com.microservice.foroum.forum.domain.model.entities.Category;
import com.microservice.foroum.forum.domain.services.CategoryCommandService;
import com.microservice.foroum.forum.infrastructure.persistence.jpa.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {

    private final CategoryRepository categoryRepository;

    public CategoryCommandServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Long handle(CreateCategoryCommand command) {
        if(categoryRepository.existsByName(command.name()))
            throw new IllegalArgumentException("Category already exists");
        var category = new Category(command);
        try {
            categoryRepository.save(category);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving course: " + e.getMessage());
        }
        return category.getId();
    }

    @Override
    public Optional<Category> handle(UpdateCategoryCommand command) {
        if(!categoryRepository.existsById(command.categoryId()))
            throw new IllegalArgumentException("Category does not exist");
        var categoryToUpdate = categoryRepository.findById(command.categoryId()).get();
        try {
            var updateCategory = categoryRepository.save(categoryToUpdate.updateInformation(command.name()));
            return Optional.of(updateCategory);
        }catch (Exception e) {
            throw new IllegalArgumentException("Error while updating category: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteCategoryCommand command) {
        if(!categoryRepository.existsById(command.categoryId()))
            throw new IllegalArgumentException("Category does not exist");
        try {
            categoryRepository.deleteById(command.categoryId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting category: " + e.getMessage());
        }
    }
}
