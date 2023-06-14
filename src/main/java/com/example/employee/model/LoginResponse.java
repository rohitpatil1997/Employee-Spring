package com.example.employee.model;

public class LoginResponse {
    private UserAccount result;
    private String httpStatus;
    private String message;
    private boolean status;

    public LoginResponse(UserAccount result, String httpStatus, String message, boolean status) {
        this.result = result;
        this.httpStatus = httpStatus;
        this.message = message;
        this.status = status;
    }

    public UserAccount getResult() {
        return result;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }
}
