package com.microservice.foroum.forum.interfaces.rest.resources;



public record CreateQuestionResource(Long userId,Long categoryId, String questionText) {
}
