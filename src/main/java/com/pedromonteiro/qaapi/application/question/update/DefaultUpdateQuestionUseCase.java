package com.pedromonteiro.qaapi.application.question.update;

import java.util.Objects;

import com.pedromonteiro.qaapi.domain.question.QuestionGateway;
import com.pedromonteiro.qaapi.domain.question.QuestionID;

public class DefaultUpdateQuestionUseCase extends UpdateQuestionUseCase {

    private final QuestionGateway questionGateway;

    public DefaultUpdateQuestionUseCase(final QuestionGateway questionGateway) {
        this.questionGateway = Objects.requireNonNull(questionGateway);
    }

    @Override
    public UpdateQuestionOutput execute(UpdateQuestionCommand aCommand) {
        final var anId = QuestionID.from(aCommand.id());
        final var aTitle = aCommand.title();
        final var aDescription = aCommand.description();

        var aQuestion = this.questionGateway.findById(anId).orElseThrow();
        aQuestion.update(aTitle, aDescription);

        return UpdateQuestionOutput.from(this.questionGateway.update(aQuestion));
    }
    
}
