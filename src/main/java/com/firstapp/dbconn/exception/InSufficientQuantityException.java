package com.firstapp.dbconn.exception;

public class InSufficientQuantityException extends RuntimeException{
    public InSufficientQuantityException(String msg) {
        super(msg);
    }
}
