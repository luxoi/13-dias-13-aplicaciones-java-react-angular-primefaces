package mundopc.modelo;

public class DispositovoEntrada {
    private String tipoDeEntrada;
    private String marca;

    //constructor con parametros
    public DispositovoEntrada(String tipoDeEntrada, String marca){

        this.tipoDeEntrada = tipoDeEntrada;
        this.marca=marca;

    }

    public String getTipoDeEntrada() {
        return tipoDeEntrada;
    }

    public void setTipoDeEntrada(String tipoDeEntrada) {
        this.tipoDeEntrada = tipoDeEntrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "DispositovoEntrada{" +
                "tipoDeEntrada='" + tipoDeEntrada + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
