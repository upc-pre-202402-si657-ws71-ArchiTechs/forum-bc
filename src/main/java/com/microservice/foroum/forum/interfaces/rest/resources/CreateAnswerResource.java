package com.microservice.foroum.forum.interfaces.rest.resources;

public record CreateAnswerResource(Long userId, Long questionId,String answerText) {
}
