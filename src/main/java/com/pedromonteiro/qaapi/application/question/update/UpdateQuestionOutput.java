package com.pedromonteiro.qaapi.application.question.update;

import com.pedromonteiro.qaapi.application.question.update.UpdateQuestionOutput;
import com.pedromonteiro.qaapi.domain.question.Question;
import com.pedromonteiro.qaapi.domain.question.QuestionID;

public record UpdateQuestionOutput(
    String id
) {
        public static UpdateQuestionOutput from(QuestionID anId) {
        return new UpdateQuestionOutput(anId.getValue());
    }

    public static UpdateQuestionOutput from(final Question anQuestion) {
        return from(anQuestion.getId());
    }
}
