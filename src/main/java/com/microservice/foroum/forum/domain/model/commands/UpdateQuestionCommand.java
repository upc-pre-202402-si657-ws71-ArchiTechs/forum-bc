package com.microservice.foroum.forum.domain.model.commands;

public record UpdateQuestionCommand(Long questionId ,Long categoryId, String questionText) {
}
