package com.izibiz.service.adapter;

import com.izibiz.service.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserAdapter {
    List<User> findAll();

    Optional<User> findById(Long userId);

    User delete(User user);

    Optional<User> findByMail(String mail);
}
