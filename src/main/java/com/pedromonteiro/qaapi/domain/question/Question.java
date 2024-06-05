package com.pedromonteiro.qaapi.domain.question;

import java.time.Instant;

import com.pedromonteiro.qaapi.domain.AggregateRoot;

public class Question extends AggregateRoot<QuestionID> {
    private String title;
    private String description;
    private int like;
    private String postedById; // Alterado para String
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    protected Question(
        final QuestionID anId,
        final String aTitle,
        final String aDescription,
        final int aLike,
        final String aPostedById, // Alterado para String
        final Instant aCreatedAt,
        final Instant aUpdatedAt
    ) {
        super(anId);
        this.title = aTitle;
        this.description = aDescription;
        this.like = aLike;
        this.postedById = aPostedById;
        this.createdAt = aCreatedAt;
        this.updatedAt = aUpdatedAt;
    }

    public static Question newQuestion(final String aTitle, final String aDescription, final String aPostedById) { // Alterado para String
        final var anId = QuestionID.unique();
        final var aLike = 0;
        final var now = Instant.now();

        return new Question(anId, aTitle, aDescription, aLike, aPostedById, now, now);
    }

    public static Question with(
        final QuestionID anId,
        final String aTitle,
        final String aDescription,
        final int aLike,
        final String aPostedById, // Alterado para String
        final Instant aCreationDate,
        final Instant aUpdateDate
    ) {
        return new Question(anId, aTitle, aDescription, aLike, aPostedById, aCreationDate, aUpdateDate);
    }

    public Question update(final String aTitle, final String aDescription) {
        this.title = aTitle;
        this.description = aDescription;
        this.updatedAt = Instant.now();

        return this;
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getLike() {
        return like;
    }

    public String getPostedById() {
        return postedById;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
