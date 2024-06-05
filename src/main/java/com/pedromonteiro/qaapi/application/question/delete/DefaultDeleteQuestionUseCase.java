package com.pedromonteiro.qaapi.application.question.delete;

import java.util.Objects;

import com.pedromonteiro.qaapi.domain.question.QuestionGateway;
import com.pedromonteiro.qaapi.domain.question.QuestionID;

public class DefaultDeleteQuestionUseCase extends DeleteQuestionUseCase{
    
     private final QuestionGateway questionGateway;

    public DefaultDeleteQuestionUseCase(final QuestionGateway questionGateway) {
        this.questionGateway = Objects.requireNonNull(questionGateway);
    }

    @Override
    public void execute(String anIn) {
        var anId = QuestionID.from(anIn);

        this.questionGateway.deleteById(anId);
    }
}
