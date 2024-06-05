package com.pedromonteiro.qaapi.domain.question;


import java.util.List;
import java.util.Optional;

public interface QuestionGateway {
    
    Question create(Question aQuestion);

    void deleteById(QuestionID anId);

    Question update(Question anQuestion);

    Optional<Question> findById(QuestionID anId);

    List<Question> findAll();
}
