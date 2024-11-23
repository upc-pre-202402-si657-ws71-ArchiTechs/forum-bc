package com.microservice.foroum.forum.domain.model.commands;

public record UpdateAnswerCommand(Long answerId, String answerText) {
}
