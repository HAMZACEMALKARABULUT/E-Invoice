package com.staj.proje.service;

import com.staj.proje.dao.UserDao;
import com.staj.proje.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);

    }


    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public Optional<User> findUserBymail(String mail) {
        Optional<User> user = Optional.ofNullable(userDao.findUserByMail(mail));

        return user;


    }

    public boolean userAuthentication(User user, String password) {
        boolean auth = passwordEncoder.matches(password, user.getPassword());
        return auth;
    }

    public List<User> listUsers() {
        return userDao.findAll();

    }


  /* public void addUserRole(User user, Role role){
        user.setRole();
        userDao.save(user);
    }     */

}
