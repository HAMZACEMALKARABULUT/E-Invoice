package com.izibiz.api.dto;

import com.izibiz.repository.entity.RoleEntity;
import lombok.Data;

import java.util.List;

public @Data class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String mail;
    private String password;
    private List<RoleEntity> role;
}
