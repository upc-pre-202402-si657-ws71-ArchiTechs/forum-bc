package com.microservice.foroum.forum.interfaces.rest.resources;

public record AnswerResource(Long id, Long userId, Long questionId, String answerText) {
}
