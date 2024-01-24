package com.codingdojo.presentacion;

import com.codingdojo.datos.EstudianteDAO;
import com.codingdojo.dominio.Estudiante;

import java.util.Scanner;

public class SistemaDeEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        // Se crea una instancia clase servicio
        var estudianteDao = new EstudianteDAO();
        while (!salir){
            try{
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDao);
            }catch (Exception e){
                System.out.println("Ocurrio un error al ejecutar operacion: "+e.getMessage());
            }
            System.out.println();

        }//fin while
    }

    private static void mostrarMenu(){
        System.out.println("""
                ***Sistema de estudiantes****
                1. Listar estudiantes
                2. Buscar estudiantes por id
                3. Agregar estudiantes
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir
                Elige una opcion:
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion) {
            case 1 -> {
                System.out.println("Listado de estudiantes..");
                var estudiantes = estudianteDAO.listar();
                estudiantes.forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("Introduce el id_estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if (encontrado) {
                    System.out.println("Estudiante encontrado: " + estudiante);
                } else {
                    System.out.println("Estudiante no encontrado: " + estudiante);
                }
            }
            case 3 -> {
                System.out.println("Agregar Estudiante: ");
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                // crear el objeto estudiante
                var estudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregado = estudianteDAO.agregarEstudiante(estudiante);
                if (agregado) {
                    System.out.println("Estudiante agregado: " + estudiante);
                } else {
                    System.out.println("Estudiante no agregado: " + estudiante);
                }
            }
            case 4 -> {
                System.out.println("Modificar estudiante: ");
                System.out.println("Id estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                // crear el objeto estudiante a modificar
                var estudiante = new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                var modificado = estudianteDAO.modificar(estudiante);
                if (modificado) {
                    System.out.println("Estudiante modificado: " + estudiante);
                } else {
                    System.out.println("Estudiante no Modificado: " + estudiante);
                }
            }
            case 5 -> {
                System.out.println("Eliminar estudiante: ");
                System.out.println("id estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDAO.eliminar(estudiante);
                if (eliminado) {
                    System.out.println("Estudiante eliminado: " + estudiante);
                } else {
                    System.out.println("Estudiante no eliminado: " + estudiante);
                }
            }
            case 6 -> {
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida");
        }
        return salir;
    } //ejecutar op

}