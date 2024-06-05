package com.pedromonteiro.qaapi.infrastructure.question.models;

import java.time.Instant;


public record QuestionResponse(
    String id,
    String title,
    String description,
    Instant createdAt,
    Instant updatedAt,
    UserResponse postedBy
) {

}
