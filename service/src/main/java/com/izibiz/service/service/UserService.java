package com.izibiz.service.service;

import com.izibiz.service.adapter.UserAdapter;
import com.izibiz.service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserAdapter userAdapter;
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;


    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

    }
    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }


    public void deleteUser(User user) {
userAdapter.delete(user);
    }

    public Optional<User> findUserBymail(String mail) {

        return   userAdapter.findByMail(mail);

    }

    public boolean userAuthentication(User user, String password) {
        boolean auth = passwordEncoder.matches(password, user.getPassword());
        return auth;
    }

    public List<User> listUsers() {
        return userAdapter.findAll();

    }



    public User getUserById(Long userId) {
        return userAdapter.findById(userId).orElse(null);
    }


  /* public void addUserRole(User user, Role role){
        user.setRole();
        userDao.save(user);
    }     */

}
