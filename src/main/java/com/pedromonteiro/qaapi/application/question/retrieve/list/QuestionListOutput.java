package com.pedromonteiro.qaapi.application.question.retrieve.list;

import java.time.Instant;

import com.pedromonteiro.qaapi.domain.question.Question;

public record QuestionListOutput(
    String id,
    String title,
    Instant createdAt,
    String postedBy
) {
    public static QuestionListOutput from(Question aQuestion) {
        return new QuestionListOutput(
            aQuestion.getId().getValue(),
            aQuestion.getTitle(),
            aQuestion.getCreatedAt(),
            aQuestion.getPostedById()
        );
    }
    
}
