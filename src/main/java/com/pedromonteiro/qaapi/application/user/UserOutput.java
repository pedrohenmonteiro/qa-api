package com.pedromonteiro.qaapi.application.user;

public record UserOutput(
    String id,
    String username,
    String email
) {}