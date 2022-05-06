package com.universidad.java.exceptions;

@SuppressWarnings("serial")
public class AccesoDatosException extends Exception {

    public AccesoDatosException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccesoDatosException(String message) {
        super(message);
    }
}
