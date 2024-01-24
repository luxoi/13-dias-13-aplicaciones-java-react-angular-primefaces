<<<<<<< HEAD
package mundopc.modelo;

public class Teclado extends DispositovoEntrada{
    private final int idTeclado;
    private static int contadorTeclado;

    public Teclado(String tipoDeEntrada, String marca){
        super(tipoDeEntrada, marca);
        idTeclado = ++contadorTeclado;
    }

    @Override
    public String toString() {
        return "Teclado{" +
                "idTeclado=" + idTeclado +
                "}"+super.toString();
    }

}
=======
package mundopc.modelo;

public class Teclado extends DispositovoEntrada{
    private final int idTeclado;
    private static int contadorTeclado;

    public Teclado(String tipoDeEntrada, String marca){
        super(tipoDeEntrada, marca);
        idTeclado = ++contadorTeclado;
    }

    @Override
    public String toString() {
        return "Teclado{" +
                "idTeclado=" + idTeclado +
                "}"+super.toString();
    }

}
>>>>>>> a5d00601b59c4ef50c903a5a5f408a5e7a73ab8b
