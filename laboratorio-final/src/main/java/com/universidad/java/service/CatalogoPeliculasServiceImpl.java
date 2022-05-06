package com.universidad.java.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.universidad.java.dao.ICatalogoPeliculasDao;
import com.universidad.java.daoImpl.CatalogoPeliculasDaoImpl;
import com.universidad.java.domain.Pelicula;
import com.universidad.java.exceptions.AccesoDatosException;
import com.universidad.java.exceptions.EscrituraDatosException;
import com.universidad.java.exceptions.LecturaDatosException;
import com.universidad.java.service.ICatalogoPeliculasService;

public class CatalogoPeliculasServiceImpl implements ICatalogoPeliculasService{
    
    private ICatalogoPeliculasDao peliculasDao;
    
    public CatalogoPeliculasServiceImpl() {
        this.peliculasDao = new CatalogoPeliculasDaoImpl();
    }

    @Override
    public List<Pelicula> listarPeliculas(String pathName){
        List<Pelicula> list = new ArrayList<>();
        try {
            list = peliculasDao.listar(pathName);
        } catch (LecturaDatosException e) {
            System.err.println(e);
        }
        return list;
    }

    @Override
    public void agregarPelicula(String nombre, String pathName){
        Pelicula pelicula2 = new Pelicula(nombre);
        try {
            peliculasDao.escribir(pelicula2, pathName);
        } catch (EscrituraDatosException e) {
            System.err.println(e);
        }
    }

    @Override
    public String busarPelicula(String pathName, String buscar){
        String pelicula = null;
        try {
            pelicula = peliculasDao.busar(pathName, buscar);
        } catch (LecturaDatosException e) {
            System.err.println(e);
        }
        return pelicula;
    }

    @Override
    public void iniciarArchivo(String pathName){
        try {
            peliculasDao.crear(pathName);
        } catch (AccesoDatosException e) {
            System.err.println(e);
        }
    }
}
