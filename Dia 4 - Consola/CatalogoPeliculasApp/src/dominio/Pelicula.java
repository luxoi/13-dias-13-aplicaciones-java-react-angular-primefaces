package dominio;

public class Pelicula {
    private String nombre;

    public Pelicula(){}

    public Pelicula(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula pelicula = (Pelicula) o;

        return nombre.equals(pelicula.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public String toString() {
        return this.nombre;
    }


}
