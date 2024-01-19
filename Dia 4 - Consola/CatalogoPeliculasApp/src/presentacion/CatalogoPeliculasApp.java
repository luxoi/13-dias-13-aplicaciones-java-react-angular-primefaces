package presentacion;


import dominio.Pelicula;
import servicio.IServicioPelicula;
import servicio.ServicioPelicula;
import servicio.ServicioPeliculasArchivo;

import java.util.Scanner;

public class CatalogoPeliculasApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        //agregamos la implementacion del servicio
        //IServicioPelicula servicioPeliculas = new ServicioPelicula();
        IServicioPelicula servicioPeliculas = new ServicioPeliculasArchivo();
        while (!salir){
            try{
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPeliculas);
            }catch (Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }
            System.out.println();
        }//fin while
    }

    private static void mostrarMenu(){
        System.out.println("""
            **** Catalogo de peliculas ****
            1. Agregar Pelicula
            2. Listar Peliculas
            3. Buscar Pelicula
            4. Salir
            """);
    }

    private static boolean ejecutarOpciones(Scanner consola,
                                            IServicioPelicula servicioPelicula){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> {
                System.out.println("Introduce el nombre de la pelicula: ");
                var nombrePelicula = consola.nextLine();
                servicioPelicula.agregarPelicula(new Pelicula(nombrePelicula));
            }
            case 2 -> {
                servicioPelicula.listarPeliculas();
            }
            case 3 -> {
                System.out.println("Introduce la pelicula a buscar: ");
                var buscar = consola.nextLine();
                servicioPelicula.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida: "+opcion);
        }
        return salir;
    }
    
}

