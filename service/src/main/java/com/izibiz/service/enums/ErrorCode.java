package com.izibiz.service.enums;

public enum ErrorCode {

    RECORD_NOT_FOUND(ErrorGroup.BAD_REQUEST),
    MISSING_PARAMETER(ErrorGroup.BAD_REQUEST),
    REPEATING_IDENTIFIER(ErrorGroup.BAD_REQUEST),
    UNEXPECTED_SITUATION(ErrorGroup.BAD_REQUEST);

    private ErrorGroup errorGroup;

    private ErrorCode(ErrorGroup errorGroup) {
        this.errorGroup = errorGroup;
    }

    public ErrorGroup getErrorGroup() {
        return errorGroup;
    }
}
