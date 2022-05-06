package com.universidad.java.exceptions;

@SuppressWarnings("serial")
public class EscrituraDatosException extends AccesoDatosException {

    public EscrituraDatosException(String message, Throwable cause) {
        super(message, cause);
    }

    public EscrituraDatosException(String message) {
        super(message);
    }

}
