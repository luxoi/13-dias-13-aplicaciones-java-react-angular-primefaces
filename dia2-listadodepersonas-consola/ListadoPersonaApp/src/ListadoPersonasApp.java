import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        //Definimos la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();
        //empezamos con el menu
        var salir = false;
        while(!salir){
         mostrarMenu();
            try{
                salir = ejecutarOperacion(consola, personas);
            }catch (Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }
            System.out.println();
        }
    }


    private static void mostrarMenu(){
        System.out.print("""
                ****Listado personas app****
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Proporciona la opcion: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        // Revisamos la opcion proporcionada

        switch (opcion){
            case 1 -> {//agregar persona a la lista
                System.out.println("Proporciona el nombre: " );
                var nombre = consola.nextLine();
                System.out.println("Proporciona el telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Proporcione el email: ");
                var email = consola.nextLine();

                var persona = new Persona(nombre, telefono, email);
                personas.add(persona);
                System.out.println("La lista tiene: "+personas.size() + " elementos");
            }//fin caso 1

            case 2 ->{
                System.out.println(" Listado de personas");
                // Mejora usando lambda y metodo de referencia
                personas.forEach(System.out::println);
            }
            case 3 ->{ // salimos del ciclo
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion erronea: "+ opcion);
        }//fin switch
        return salir;
    }

}