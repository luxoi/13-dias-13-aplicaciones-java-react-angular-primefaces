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
