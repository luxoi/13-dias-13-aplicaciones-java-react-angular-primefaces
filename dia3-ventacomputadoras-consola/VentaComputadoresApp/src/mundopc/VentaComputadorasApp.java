package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.servicio.Orden;

public class VentaComputadorasApp {
    public static void main(String[] args) {
        Raton ratonLenovo = new Raton("bluetooth", "Lenovo");
        Teclado tecladoLenovo = new Teclado("bluetooth", "Lenovo");
        Monitor monitorLenovo = new Monitor("Lenovo", 27);
        //Creamos un objeto de tipo Computadora
        Computadora computadoraLenovo = new Computadora("Computadora lenovo", monitorLenovo, tecladoLenovo, ratonLenovo);

        Monitor monitorDell = new Monitor("Dell", 15);
        Teclado tecladoDell = new Teclado("usb", "Dell");
        Raton ratonDell = new Raton("usb", "Dell");
        Computadora computadoraDell = new Computadora("Computadora Dell",
                monitorDell, tecladoDell, ratonDell);


        //Creamos una orden
        Orden orden1 = new  Orden();
        orden1.agregarComputadora(computadoraLenovo);
        orden1.agregarComputadora(computadoraDell);
        orden1.mostrarOrden();
    }
}