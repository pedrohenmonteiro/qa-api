package com.pedromonteiro.qaapi.application.question.update;

public record UpdateQuestionCommand(
    String id,
    String title,
    String description
) {
    public static UpdateQuestionCommand with(String anId, String aTitle, String aDescription) {
        return new UpdateQuestionCommand(anId, aTitle, aDescription);
    }
}
