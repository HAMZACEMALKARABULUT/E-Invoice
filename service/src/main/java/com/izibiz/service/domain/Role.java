package com.izibiz.service.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString(includeFieldNames = true)
public @Data class Role implements Serializable {
    private Long id;

    private String roleName;




}
