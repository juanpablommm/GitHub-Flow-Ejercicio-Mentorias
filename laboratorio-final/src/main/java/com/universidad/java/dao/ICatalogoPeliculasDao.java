package com.universidad.java.dao;

import java.util.List;

import com.universidad.java.domain.Pelicula;
import com.universidad.java.exceptions.AccesoDatosException;
import com.universidad.java.exceptions.EscrituraDatosException;
import com.universidad.java.exceptions.LecturaDatosException;

public interface ICatalogoPeliculasDao {

//    public boolean existe(String pahName); 
    /*no tien logica
     implentar un metodo para sbaer si exite el documento, cuando ya 
     tenemos el metodo exists() de la clase File*/
    
    public List<Pelicula> listar(String patname) throws LecturaDatosException;
    
    public void escribir(Pelicula pelicula, String patName) throws EscrituraDatosException;
    
    public String busar(String patName, String buscar) throws LecturaDatosException;
    
    public void crear(String patName) throws AccesoDatosException;
    
    public void borrar(String patName);
}
