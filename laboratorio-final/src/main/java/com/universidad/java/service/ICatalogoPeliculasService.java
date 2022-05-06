package com.universidad.java.service;

import java.util.List;

import com.universidad.java.domain.Pelicula;

public interface ICatalogoPeliculasService {
    
    public List<Pelicula> listarPeliculas(String patname);

    public void agregarPelicula(String nombre, String patName);

    public String busarPelicula(String patName, String buscar);

    public void iniciarArchivo(String patName);

}
