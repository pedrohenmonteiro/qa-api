package com.pedromonteiro.qaapi.infrastructure.question.persistence;

import java.time.Instant;

import com.pedromonteiro.qaapi.domain.question.Question;
import com.pedromonteiro.qaapi.domain.question.QuestionID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Question")
@Table(name = "tb_question")
public class QuestionJpaEntity {
    
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "like_count", nullable = false)
    private int likeCount;

    @Column(name = "posted_by_id", nullable = false)
    private String postedById;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public QuestionJpaEntity() {
    }

    public QuestionJpaEntity(String id, String title, String description, int likeCount, String postedById, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.likeCount = likeCount;
        this.postedById = postedById;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static QuestionJpaEntity from(final Question aQuestion) {
        return new QuestionJpaEntity(
            aQuestion.getId().getValue(),
            aQuestion.getTitle(),
            aQuestion.getDescription(),
            aQuestion.getLike(),
            aQuestion.getPostedById(),
            aQuestion.getCreatedAt(),
            aQuestion.getUpdatedAt()
        );
    }

    public Question toAggregate() {
        return Question.with(
            QuestionID.from(getId()),
            getTitle(),
            getDescription(),
            getLike(),
            getPostedById(),
            getCreatedAt(),
            getUpdatedAt()
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLike() {
        return likeCount;
    }

    public void setLike(int like) {
        this.likeCount = like;
    }

    public String getPostedById() {
        return postedById;
    }
    
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
