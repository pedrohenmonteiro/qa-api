package com.pedromonteiro.qaapi.application.question.retrieve.get;

import java.util.Objects;

import com.pedromonteiro.qaapi.domain.question.QuestionGateway;
import com.pedromonteiro.qaapi.domain.question.QuestionID;

public class DefaultGetQuestionByIdUseCase extends GetQuestionByIdUseCase {

    private final QuestionGateway questionGateway;

    public DefaultGetQuestionByIdUseCase(final QuestionGateway questionGateway) {
        this.questionGateway = Objects.requireNonNull(questionGateway);
    }

    @Override
    public QuestionOutput execute(String anIn) {
        var anId = QuestionID.from(anIn);

        var output = this.questionGateway.findById(anId).orElseThrow();

        return QuestionOutput.from(output);
    }
    
}
