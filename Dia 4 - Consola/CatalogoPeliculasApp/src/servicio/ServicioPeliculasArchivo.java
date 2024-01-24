package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPelicula{

    private final String NOMBRE_ARCHIVO="peliculas.txt";

    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            //Si ya existe el archivo no se vuelve a crear
            if (archivo.exists()){
                System.out.println("El archivo ya existe!");
            }else{
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al abrir el archivo: "+e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        //volver a abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            System.out.println("Listado de peliculas...");
            //abrimos el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            //leemos linea a linea el archivo
            String linea;
            linea = entrada.readLine();
            //Leemos todas las lineas
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //Antes de terminar el ciclo volvemos a leer la siguiente linea
                linea = entrada.readLine();
            } // Cerrar el archivo
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error al leer el archivo: "+e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agrego al archivo el nombre de la pelicula: "+pelicula);
        }catch (Exception e){
            System.out.println("Ocurrio un error al agregar pelicula: "+e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            //Abrimos el archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();
            while (lineaTexto!=null){
                //Buscamos sin importar mayusculas/minusculas
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }else {
                    lineaTexto = entrada.readLine();
                    indice++;
                }
            }//Fin while
            //Imprimimos los resultados
            if (encontrada){
                System.out.println("Pelicula: "+lineaTexto+"Encontrada - linea "+indice);
            }else{
                System.out.println("No se encontro la pelicula: "+pelicula.getNombre());
                entrada.close();
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar pelicula: "+e.getMessage());
        }
    }
}
