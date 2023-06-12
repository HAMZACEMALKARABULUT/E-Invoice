package com.izibiz.common.context;

import lombok.Data;

import java.util.List;

public @Data class RequestContext {
    private Long userId;
    private String ipAdress;
    private String username;

    private List<String> roles;

}
