package com.pedromonteiro.qaapi.infrastructure.api.presenters;

import com.pedromonteiro.qaapi.application.question.retrieve.get.QuestionOutput;
import com.pedromonteiro.qaapi.infrastructure.question.models.QuestionResponse;
import com.pedromonteiro.qaapi.infrastructure.question.models.UserResponse;

public interface QuestionApiPresenter {

    static QuestionResponse present(final QuestionOutput output, UserResponse postedBy) {
        return new QuestionResponse(
                output.id(),
                output.title(),
                output.description(),
                output.createdAt(),
                output.updatedAt(),
                postedBy
        );

}
}
