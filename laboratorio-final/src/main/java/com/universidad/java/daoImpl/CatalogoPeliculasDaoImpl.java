package com.universidad.java.daoImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.universidad.java.dao.ICatalogoPeliculasDao;
import com.universidad.java.domain.Pelicula;
import com.universidad.java.exceptions.AccesoDatosException;
import com.universidad.java.exceptions.EscrituraDatosException;
import com.universidad.java.exceptions.LecturaDatosException;

public class CatalogoPeliculasDaoImpl implements ICatalogoPeliculasDao {

    public List<Pelicula> listar(String patname) throws LecturaDatosException {
        File file = new File(patname);
        List<Pelicula> list = new ArrayList<>();
        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    String nombre = line.substring(line.indexOf("=") + 1, line.length());
                    list.add(new Pelicula(nombre));
                    line = bufferedReader.readLine();
                }
            } catch (IOException e) {
                throw new LecturaDatosException("Error!! no se pudo listar las peliculas: ", e);
            }
        }else {
            System.out.println("No se puden listar las peliculas porque el archivo no existe");
        }
        return list;
    }

    public void escribir(Pelicula pelicula, String patName) throws EscrituraDatosException {
        File file = new File(patName);
        if (file.exists()) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
                bufferedWriter.write(pelicula.toString());
                bufferedWriter.newLine();
                System.out.println("Se ha agregado la pelicula \"" + pelicula.getNombre() + "\" a cartelera");
            } catch (IOException e) {
                throw new EscrituraDatosException("Error!! no se puede escribir en el archivo " + file.getName(), e);
            }
        }
    }

    public String busar(String patName, String buscar) throws LecturaDatosException {
        File file = new File(patName);
        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    if (line.contains(buscar)) {
                        return line;
                    }
                    line = bufferedReader.readLine();
                }
            } catch (IOException e) {
                throw new LecturaDatosException("Error!! no se puede buscar \"" + buscar + "\" en el archivo"
                        + file.getName(), e);
            }
        }
        return null;
    }

    public void crear(String patName) throws AccesoDatosException {
        File file = new File(patName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Se creao la cartelera de peliculas en: " + patName);
            } catch (IOException e) {
                throw new AccesoDatosException("No se pudo crear el archivo " + patName, e);
            }
        } else {
            System.out.println("No se puede crear, el archivo ya existe: " + patName);
        }
    }

    public void borrar(String patName) {
        File file = new File(patName);
        if(file.exists()) {
            System.out.println((file.delete())?  "Se ha elimnado la cartelera " + file.getName():
                "No se puedo elimnar " + file.getName());
        }else {
            System.out.println("El archivo no exite, por lo que no se puede borrar...");
        }
    }
}
