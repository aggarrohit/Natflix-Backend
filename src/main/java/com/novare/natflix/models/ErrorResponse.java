package com.novare.natflix.models;

public record ErrorResponse(String errorCode, String message) {

    @Override
    public String toString() {
        return "{" +
                "\"errorCode\":\"" + errorCode + '\"' +
                ", \"message\":\"" + message + '\"' +
                '}';
    }
}

