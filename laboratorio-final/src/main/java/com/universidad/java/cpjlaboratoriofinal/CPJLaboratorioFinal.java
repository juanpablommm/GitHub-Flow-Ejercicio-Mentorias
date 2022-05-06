package com.universidad.java.cpjlaboratoriofinal;

import java.util.List;
import java.util.Scanner;

import com.universidad.java.domain.Pelicula;
import com.universidad.java.exceptions.AccesoDatosException;
import com.universidad.java.service.ICatalogoPeliculasService;
import com.universidad.java.serviceImpl.CatalogoPeliculasServiceImpl;

public class CPJLaboratorioFinal {

    public static void main(String[] args) throws AccesoDatosException {

        Scanner scanner = new Scanner(System.in);
        String patName = "";
        ICatalogoPeliculasService service = new CatalogoPeliculasServiceImpl();
        String opcion = "";
        String titulo = "";
        do {
            System.out.println("Elija una Opcion: " 
                    + "\n1.Iniciar Catalogo de Peliculas" 
                    + "\n2.Agregar Pelicula" 
                    + "\n3.Listar Peliculas" 
                    + "\n4.Buscar Peliculas" 
                    + "\n0.Salir");
            opcion = scanner.nextLine();
            switch (opcion) {
            case "1":
                System.out.println("Ingresa el Nombre de la Cartelera a crear");
                patName = scanner.nextLine();
                service.iniciarArchivo(patName);
                break;
            case "2":
                System.out.println("Ingresa el nombre de la Pelicula: ");
                titulo = scanner.nextLine();
                System.out.println("Ingresa el nombre de la cartelera: ");
                patName = scanner.nextLine();
                service.agregarPelicula(titulo, patName);
                break;
            case "3":
                System.out.println("Ingresa el nombre de la cartelera: ");
                patName = scanner.nextLine();
                List<Pelicula> list = service.listarPeliculas(patName);
                list.forEach(System.out::println);
                break;
            case "4":
                System.out.println("Ingresa el nombre de la Pelicula: ");
                titulo = scanner.nextLine();
                System.out.println("Ingresa el nombre de la cartelera: ");
                patName = scanner.nextLine();
                System.out.println(service.busarPelicula(patName, titulo));
                break;
            default:
                System.out.println("Opcion no valida");
                break;
            }    
        } while (!opcion.equals("0"));
        scanner.close();
    }
}
