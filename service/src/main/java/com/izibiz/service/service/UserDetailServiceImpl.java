package com.izibiz.service.service;

import com.izibiz.service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.findUserBymail(username);
        if(user.isPresent()){
            return org.springframework.security.core.userdetails.User.builder()
                    .password(user.get().getPassword())
                    .accountExpired(false)
                    .accountLocked(false)
                    .disabled(false)
                    .credentialsExpired(false).build();
        }
        return null;
    }
}
