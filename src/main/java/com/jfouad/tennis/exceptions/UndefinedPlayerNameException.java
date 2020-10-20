package com.jfouad.tennis.exceptions;

public class UndefinedPlayerNameException extends RuntimeException {

    public UndefinedPlayerNameException(String message) {
        super(message);
    }
}
