package com.microservice.foroum.forum.domain.model.commands;



public record CreateAnswerCommand(Long userId, Long questionId, String answerText) {
}
