package com.izibiz.service.adapter.impl;

import com.izibiz.repository.repository.UserRepository;
import com.izibiz.service.adapter.UserAdapter;
import com.izibiz.service.domain.User;
import com.izibiz.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserAdapterImpl  implements UserAdapter {

@Autowired
private UserRepository userRepository;
@Autowired
private UserMapper userMapper;
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
    public Optional<User> findByMail(String mail) {
        return  userRepository.findUserByMail(mail).map(userMapper::fromEntityToDomain);

    }
}
