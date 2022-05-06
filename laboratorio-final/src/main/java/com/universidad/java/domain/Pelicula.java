package com.universidad.java.domain;

public class Pelicula {

    private String nombre;

    public Pelicula(String nombre) {
        super();
        this.nombre = nombre;
    }
    
    public Pelicula() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pelicula: ");
        builder.append(nombre);
        return builder.toString();
    }
}
