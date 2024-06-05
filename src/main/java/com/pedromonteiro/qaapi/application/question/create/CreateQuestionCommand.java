package com.pedromonteiro.qaapi.application.question.create;

public record CreateQuestionCommand(
    String title,
    String description,
    String postedBy 
) {
    public static CreateQuestionCommand with(String aTitle, String aDescription, String aPostedBy) {
        return new CreateQuestionCommand(aTitle, aDescription, aPostedBy);
    }
}
