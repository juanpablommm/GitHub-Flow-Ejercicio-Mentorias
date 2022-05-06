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
    public List<Pelicula> listarPeliculas(String patname){
        List<Pelicula> list = new ArrayList<>();
        try {
            list = peliculasDao.listar(patname);
        } catch (LecturaDatosException e) {
            System.err.println(e);
        }
        return list;
    }

    @Override
    public void agregarPelicula(String nombre, String patName){
        Pelicula pelicula2 = new Pelicula(nombre);
        try {
            peliculasDao.escribir(pelicula2, patName);
        } catch (EscrituraDatosException e) {
            System.err.println(e);
        }
    }

    @Override
    public String busarPelicula(String patName, String buscar){
        String pelicula = null;
        try {
            pelicula = peliculasDao.busar(patName, buscar);
        } catch (LecturaDatosException e) {
            System.err.println(e);
        }
        return pelicula;
    }

    @Override
    public void iniciarArchivo(String patName){
        try {
            peliculasDao.crear(patName);
        } catch (AccesoDatosException e) {
            System.err.println(e);
        }
    }
}
