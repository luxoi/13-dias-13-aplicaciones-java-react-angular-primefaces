<<<<<<< HEAD
package mundopc.modelo;

public class Raton extends  DispositovoEntrada{
    private final int idRaton;
    private static int contadorRatones;

    // constructor
    public Raton(String tipoEntrada, String marca){
        super(tipoEntrada, marca);
        idRaton = ++contadorRatones;
    }

    @Override
    public String toString() {
        return "Raton{" +
                "idRaton=" + idRaton +
                "}" + super.toString();
    }

    public int getIdRaton() {
        return idRaton;
    }

    public static int getContadorRatones() {
        return contadorRatones;
    }

    public static void setContadorRatones(int contadorRatones) {
        Raton.contadorRatones = contadorRatones;
    }
}
=======
package mundopc.modelo;

public class Raton extends  DispositovoEntrada{
    private final int idRaton;
    private static int contadorRatones;

    // constructor
    public Raton(String tipoEntrada, String marca){
        super(tipoEntrada, marca);
        idRaton = ++contadorRatones;
    }

    @Override
    public String toString() {
        return "Raton{" +
                "idRaton=" + idRaton +
                "}" + super.toString();
    }

    public int getIdRaton() {
        return idRaton;
    }

    public static int getContadorRatones() {
        return contadorRatones;
    }

    public static void setContadorRatones(int contadorRatones) {
        Raton.contadorRatones = contadorRatones;
    }
}
>>>>>>> a5d00601b59c4ef50c903a5a5f408a5e7a73ab8b
