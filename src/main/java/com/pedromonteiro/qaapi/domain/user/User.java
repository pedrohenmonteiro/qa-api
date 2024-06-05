package com.pedromonteiro.qaapi.domain.user;

import java.time.Instant;

import com.pedromonteiro.qaapi.domain.AggregateRoot;

public class User {

    private String id;
    private String name;
    private String email;

    public User(
        final String aName,
        final String anEmail
            ) {
        this.name = aName;
        this.email = anEmail;
    }

    public static User newUser(final String aName, final String anEmail) {
        final UserID anId = UserID.unique();
        final var now = Instant.now();

        return new User(aName, anEmail);
    }

    public static User with(
        final String aName,
        final String anEmail
    ) {
        return new User(aName, anEmail);
    }

    public static User with(
        User anUser
    ) {
        return new User(
            anUser.name,
            anUser.email
        );
    }

    public User update(final String aName, final String anEmail) {
        this.name = aName;
        this.email = anEmail;

        return this;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    
}
