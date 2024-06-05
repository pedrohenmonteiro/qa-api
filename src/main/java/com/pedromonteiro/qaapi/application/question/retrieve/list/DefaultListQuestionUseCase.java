package com.pedromonteiro.qaapi.application.question.retrieve.list;

import java.util.List;
import java.util.Objects;

import com.pedromonteiro.qaapi.domain.question.QuestionGateway;

public class DefaultListQuestionUseCase extends ListQuestionUseCase{

    private final QuestionGateway questionGateway;

    public DefaultListQuestionUseCase(final QuestionGateway questionGateway) {
        this.questionGateway = Objects.requireNonNull(questionGateway);
    }

    @Override
    public List<QuestionListOutput> execute() {
        return this.questionGateway.findAll()
            .stream().map(QuestionListOutput::from).toList();
    }
    
}
