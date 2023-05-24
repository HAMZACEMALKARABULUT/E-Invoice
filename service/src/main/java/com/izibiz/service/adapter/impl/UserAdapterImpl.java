package com.izibiz.service.adapter.impl;

import com.izibiz.service.adapter.UserAdapter;
import com.izibiz.service.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserAdapterImpl  implements UserAdapter {


    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long userId) {
        return Optional.empty();
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public User findByMail(String mail) {
        return null;
    }
}
