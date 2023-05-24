package com.izibiz.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data class Response<T>  {
    private T data;
    private Error error;
}
