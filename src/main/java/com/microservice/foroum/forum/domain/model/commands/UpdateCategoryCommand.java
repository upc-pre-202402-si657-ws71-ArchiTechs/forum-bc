package com.microservice.foroum.forum.domain.model.commands;

public record UpdateCategoryCommand(Long categoryId, String name) {
}
