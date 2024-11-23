package com.microservice.foroum.forum.domain.model.commands;



public record CreateQuestionCommand(Long categoryId, Long userId, String questionText) {
}
