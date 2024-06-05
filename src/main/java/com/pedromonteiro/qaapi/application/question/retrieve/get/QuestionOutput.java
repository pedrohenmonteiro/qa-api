package com.pedromonteiro.qaapi.application.question.retrieve.get;

import java.time.Instant;

import com.pedromonteiro.qaapi.domain.question.Question;

public record QuestionOutput(
    String id,
    String title,
    String description,
    Instant createdAt,
    Instant updatedAt
) {
    
    public static QuestionOutput from(final Question aQuestion) {
        return new QuestionOutput(
            aQuestion.getId().getValue(),
            aQuestion.getTitle(),
            aQuestion.getDescription(),
            aQuestion.getCreatedAt(),
            aQuestion.getUpdatedAt()
        );
    }
}
