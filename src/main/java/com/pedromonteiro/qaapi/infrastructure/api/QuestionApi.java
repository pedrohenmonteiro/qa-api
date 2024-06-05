package com.pedromonteiro.qaapi.infrastructure.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pedromonteiro.qaapi.application.question.create.CreateQuestionCommand;
import com.pedromonteiro.qaapi.application.question.retrieve.get.QuestionOutput;
import com.pedromonteiro.qaapi.application.question.retrieve.list.QuestionListOutput;
import com.pedromonteiro.qaapi.application.question.update.UpdateQuestionCommand;
import com.pedromonteiro.qaapi.application.question.update.UpdateQuestionOutput;
import com.pedromonteiro.qaapi.infrastructure.question.models.QuestionResponse;

@RequestMapping(path = "questions")
public interface QuestionApi {

    @GetMapping(value = "{id}")
    ResponseEntity<QuestionResponse> getById(@PathVariable String id);

    @GetMapping
    ResponseEntity<List<QuestionListOutput>> findAll();
    
    @PostMapping
    ResponseEntity<?> create(@RequestBody CreateQuestionCommand input);

    @DeleteMapping(value = "{id}")
    ResponseEntity<Void> deleteById(@PathVariable String id);

    @PutMapping(value = "{id}")
    ResponseEntity<UpdateQuestionOutput> updateById(@PathVariable String id, @RequestBody UpdateQuestionCommand aCommand);

}
