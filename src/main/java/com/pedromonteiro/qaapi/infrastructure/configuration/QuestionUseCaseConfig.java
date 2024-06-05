package com.pedromonteiro.qaapi.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pedromonteiro.qaapi.application.question.create.CreateQuestionUseCase;
import com.pedromonteiro.qaapi.application.question.create.DefaultCreateQuestionUseCase;
import com.pedromonteiro.qaapi.application.question.delete.DefaultDeleteQuestionUseCase;
import com.pedromonteiro.qaapi.application.question.delete.DeleteQuestionUseCase;
import com.pedromonteiro.qaapi.application.question.retrieve.get.DefaultGetQuestionByIdUseCase;
import com.pedromonteiro.qaapi.application.question.retrieve.get.GetQuestionByIdUseCase;
import com.pedromonteiro.qaapi.application.question.retrieve.list.DefaultListQuestionUseCase;
import com.pedromonteiro.qaapi.application.question.retrieve.list.ListQuestionUseCase;
import com.pedromonteiro.qaapi.application.question.update.DefaultUpdateQuestionUseCase;
import com.pedromonteiro.qaapi.application.question.update.UpdateQuestionUseCase;
import com.pedromonteiro.qaapi.domain.question.QuestionGateway;

@Configuration
public class QuestionUseCaseConfig {
    
    private final QuestionGateway questionGateway;

    public QuestionUseCaseConfig(QuestionGateway questionGateway) {
        this.questionGateway = questionGateway;
    }

    @Bean
    public CreateQuestionUseCase createQuestionUseCase() {
        return new DefaultCreateQuestionUseCase(questionGateway);
    }

    @Bean
    public UpdateQuestionUseCase updateQuestionUseCase() {
        return new DefaultUpdateQuestionUseCase(questionGateway);
    }

    @Bean
    public DeleteQuestionUseCase deleteQuestionUseCase() {
        return new DefaultDeleteQuestionUseCase(questionGateway);
    }

    @Bean
    public GetQuestionByIdUseCase getQuestionByIdUseCase() {
        return new DefaultGetQuestionByIdUseCase(questionGateway);
    }

    @Bean
    public ListQuestionUseCase listQuestionUseCase() {
        return new DefaultListQuestionUseCase(questionGateway);
    }
}
