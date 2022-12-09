package com.mynt.mynttest.exception;

public class ApiRejectException extends RuntimeException{

    public ApiRejectException(String message){
        super(message);
    }

    public ApiRejectException(String message, Throwable cause){
        super(message, cause);
    }

}
