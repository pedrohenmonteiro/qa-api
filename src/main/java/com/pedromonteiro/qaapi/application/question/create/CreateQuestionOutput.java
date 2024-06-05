package com.pedromonteiro.qaapi.application.question.create;

import com.pedromonteiro.qaapi.domain.question.Question;
import com.pedromonteiro.qaapi.domain.question.QuestionID;

public record CreateQuestionOutput(
    String id
    ) {
     public static CreateQuestionOutput from(final QuestionID anId) {
        return new CreateQuestionOutput(anId.getValue());
    }

    public static CreateQuestionOutput from(final Question anQuestion) {
        return from(anQuestion.getId());
    }
}
