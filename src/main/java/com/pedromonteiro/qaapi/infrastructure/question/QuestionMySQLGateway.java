package com.pedromonteiro.qaapi.infrastructure.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pedromonteiro.qaapi.domain.question.Question;
import com.pedromonteiro.qaapi.domain.question.QuestionGateway;
import com.pedromonteiro.qaapi.domain.question.QuestionID;
import com.pedromonteiro.qaapi.infrastructure.question.persistence.QuestionJpaEntity;
import com.pedromonteiro.qaapi.infrastructure.question.persistence.QuestionRepository;

@Service
public class QuestionMySQLGateway implements QuestionGateway {

    private QuestionRepository questionRepository;

    public QuestionMySQLGateway(final QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question create(Question aQuestion) {
        return save(aQuestion);
    }

    @Override
    public void deleteById(QuestionID anId) {
        var question = this.questionRepository.findById(anId.getValue());

        if(question.isPresent()) {
            this.questionRepository.delete(question.get());
        }
        
    }

    @Override
    public List<Question> findAll() {
        return this.questionRepository.findAll()
            .stream().map(QuestionJpaEntity::toAggregate).toList();
    }

    @Override
    public Optional<Question> findById(QuestionID anId) {
        return this.questionRepository.findById(anId.getValue())
            .map(QuestionJpaEntity::toAggregate);
    }

    @Override
    public Question update(Question anQuestion) {
        return save(anQuestion);
    }
    

    private Question save(final Question aQuestion) {
        return this.questionRepository.save(QuestionJpaEntity.from(aQuestion)).toAggregate();
    }

    
}
