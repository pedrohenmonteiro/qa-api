package com.pedromonteiro.qaapi.infrastructure.api.controllers;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RestController;

import com.pedromonteiro.qaapi.application.question.create.CreateQuestionCommand;
import com.pedromonteiro.qaapi.application.question.create.CreateQuestionUseCase;
import com.pedromonteiro.qaapi.application.question.delete.DeleteQuestionUseCase;
import com.pedromonteiro.qaapi.application.question.retrieve.get.GetQuestionByIdUseCase;
import com.pedromonteiro.qaapi.application.question.retrieve.list.ListQuestionUseCase;
import com.pedromonteiro.qaapi.application.question.retrieve.list.QuestionListOutput;
import com.pedromonteiro.qaapi.application.question.update.UpdateQuestionCommand;
import com.pedromonteiro.qaapi.application.question.update.UpdateQuestionOutput;
import com.pedromonteiro.qaapi.application.question.update.UpdateQuestionUseCase;
import com.pedromonteiro.qaapi.infrastructure.api.QuestionApi;
import com.pedromonteiro.qaapi.infrastructure.api.presenters.QuestionApiPresenter;
import com.pedromonteiro.qaapi.infrastructure.question.models.QuestionResponse;
import com.pedromonteiro.qaapi.infrastructure.question.models.UserResponse;

@RestController
public class QuestionController implements QuestionApi {
    
    private final CreateQuestionUseCase createQuestionUseCase;
    private final GetQuestionByIdUseCase getQuestionByIdUseCase;
    private final DeleteQuestionUseCase deleteQuestionUseCase;
    private final UpdateQuestionUseCase updateQuestionUseCase;
    private final ListQuestionUseCase listQuestionUseCase;

    public QuestionController(
        final CreateQuestionUseCase createQuestionUseCase,
        final DeleteQuestionUseCase deleteQuestionUseCase,
        final UpdateQuestionUseCase updateQuestionUseCase,
        final GetQuestionByIdUseCase getQuestionByIdUseCase,
        final ListQuestionUseCase listQuestionUseCase
    ) {
        this.createQuestionUseCase = Objects.requireNonNull(createQuestionUseCase);
        this.deleteQuestionUseCase = Objects.requireNonNull(deleteQuestionUseCase);
        this.updateQuestionUseCase = Objects.requireNonNull(updateQuestionUseCase);
        this.getQuestionByIdUseCase = Objects.requireNonNull(getQuestionByIdUseCase);
        this.listQuestionUseCase = Objects.requireNonNull(listQuestionUseCase);
    }

    @Override
    public ResponseEntity<?> create(CreateQuestionCommand input) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var jwt = (Jwt) auth.getPrincipal();
        var userId = jwt.getSubject();
        
        var aCommand = CreateQuestionCommand.with(input.title(), input.description(), userId);
        var output = createQuestionUseCase.execute(aCommand);

        return ResponseEntity.created(URI.create("/questions/" + output.id())).body(output);
    }

    @Override
    public ResponseEntity<Void> deleteById(String id) {
        this.deleteQuestionUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UpdateQuestionOutput> updateById(String id, UpdateQuestionCommand input) {
        var aCommand = UpdateQuestionCommand.with(id, input.title(), input.description());
        var output = this.updateQuestionUseCase.execute(aCommand);

        return ResponseEntity.ok(output);
    }

    @Override
    public ResponseEntity<QuestionResponse> getById(String id) {
        var postedBy = UserResponse.getCurrentUser();
        var output = QuestionApiPresenter.present(this.getQuestionByIdUseCase.execute(id), postedBy);
        
        return ResponseEntity.ok(output);
    }

    @Override
    public ResponseEntity<List<QuestionListOutput>> findAll() {
        var output = listQuestionUseCase.execute();
    
        return ResponseEntity.ok(output);
    }
}
