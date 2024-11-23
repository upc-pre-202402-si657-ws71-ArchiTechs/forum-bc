package com.microservice.foroum.forum.domain.model.queries;


import com.microservice.foroum.forum.domain.model.valueobjects.UserId;

public record GetAllQuestionsByUserIdQuery(UserId userId) {
}
