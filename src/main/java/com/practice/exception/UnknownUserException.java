package com.practice.exception;

/**
 * Created by ravikiran_gorthi on 5/8/17.
 */
public class UnknownUserException extends Exception {

    public UnknownUserException()
    {
    }

    public UnknownUserException(String message)
    {
        super(message);
    }

    public UnknownUserException(Throwable cause)
    {
        super(cause);
    }

    public UnknownUserException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UnknownUserException(String message, Throwable cause,
                           boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
