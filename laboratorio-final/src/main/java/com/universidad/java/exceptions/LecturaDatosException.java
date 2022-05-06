package com.universidad.java.exceptions;

@SuppressWarnings("serial")
public class LecturaDatosException extends AccesoDatosException{

    public LecturaDatosException(String message, Throwable cause) {
        super(message, cause);
    }

    public LecturaDatosException(String message) {
        super(message);
    }
}
