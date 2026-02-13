package com.krvish.xpns.common;

public class HealthResponse {

    private String message;
    private String status;

    public HealthResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

}
