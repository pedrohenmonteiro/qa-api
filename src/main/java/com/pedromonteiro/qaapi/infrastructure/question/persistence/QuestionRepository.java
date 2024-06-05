package com.pedromonteiro.qaapi.infrastructure.question.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionJpaEntity, String>{

}
