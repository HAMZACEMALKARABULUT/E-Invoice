package com.izibiz.api.dto;

import lombok.Data;

import java.io.Serializable;

public @Data class CustomerDto implements Serializable {

    private Long id;

    private String name;

    private String surname;

    private String identifier;

    private String telNo;

    private String mail;

    private String taxAdministration;

    private String title;

    private String userId;
}
