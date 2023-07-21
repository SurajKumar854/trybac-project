package com.trybac.learn.models;

public class APIResponse {
    private boolean status;
    private int error;
    private String message;

    public APIResponse(boolean status, int error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }
}

