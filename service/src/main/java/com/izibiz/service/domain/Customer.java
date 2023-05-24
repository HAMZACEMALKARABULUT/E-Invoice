package com.izibiz.service.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString(includeFieldNames = true)
public @Data class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String surname;
    private String identifier;
    private String telNo;
    private String mail;
    private String taxAdministration;
    private String title;
    private Long userId;
    private String state;
}

