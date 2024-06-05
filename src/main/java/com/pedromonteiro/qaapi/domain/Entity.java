package com.pedromonteiro.qaapi.domain;

import java.util.Objects;

public abstract class Entity<ID extends Identifier> {

    protected final ID id;

    protected Entity(final ID id) {
        Objects.requireNonNull(id, "'id' must not be null");
        this.id = id;
    }

    public ID getId() {
        return id;
    }
    
}
