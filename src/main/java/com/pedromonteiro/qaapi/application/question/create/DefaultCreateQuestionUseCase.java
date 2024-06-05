package com.pedromonteiro.qaapi.application.question.create;

import java.util.Objects;

import com.pedromonteiro.qaapi.domain.question.Question;
import com.pedromonteiro.qaapi.domain.question.QuestionGateway;

public class DefaultCreateQuestionUseCase extends CreateQuestionUseCase {

    private final QuestionGateway questionGateway;

    public DefaultCreateQuestionUseCase(final QuestionGateway QuestionGateway) {
        this.questionGateway = Objects.requireNonNull(QuestionGateway);
    }

    @Override
    public CreateQuestionOutput execute(CreateQuestionCommand aCommand) {
        var aTitle = aCommand.title();
        var aDescription = aCommand.description();
        var aPostedBy = aCommand.postedBy();

        var aQuestion = Question.newQuestion(aTitle, aDescription, aPostedBy);

        return CreateQuestionOutput.from(this.questionGateway.create(aQuestion));
    }
}
