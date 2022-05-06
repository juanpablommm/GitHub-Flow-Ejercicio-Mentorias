package com.universidad.java.service;

import java.util.List;

import com.universidad.java.domain.Pelicula;

public interface ICatalogoPeliculasService {
    
    public List<Pelicula> listarPeliculas(String pathName);

    public void agregarPelicula(String nombre, String pathName);

    public String busarPelicula(String pathName, String buscar);

    public void iniciarArchivo(String pathName);

}
