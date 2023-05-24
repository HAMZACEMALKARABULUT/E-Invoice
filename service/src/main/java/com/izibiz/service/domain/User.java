package com.izibiz.service.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

public @Data class User implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String mail;
    private String password;
    private List<Role> role;

}
