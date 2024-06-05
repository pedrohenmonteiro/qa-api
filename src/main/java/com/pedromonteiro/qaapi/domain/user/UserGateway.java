package com.pedromonteiro.qaapi.domain.user;

import java.util.List;
import java.util.Optional;

public interface UserGateway {
    
    User create(User aUser);

    void deleteById(UserID anId);

    User update(User anUser);

    Optional<User> findById(UserID anId);

    List<User> findAll();
}
