<<<<<<< HEAD
package gm.tienda_libros.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity


@ToString
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idLibro;
    String nombre;
    String autor;
    Double precio;
    Integer existencias;

    public Libro() {
    }

    public Libro(Integer idLibro, String nombre, String autor, Double precio, Integer existencias) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.autor = autor;
        this.precio = precio;
        this.existencias = existencias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }
}
=======
package gm.tienda_libros.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity


@ToString
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idLibro;
    String nombre;
    String autor;
    Double precio;
    Integer existencias;

    public Libro() {
    }

    public Libro(Integer idLibro, String nombre, String autor, Double precio, Integer existencias) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.autor = autor;
        this.precio = precio;
        this.existencias = existencias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }
}
>>>>>>> a5d00601b59c4ef50c903a5a5f408a5e7a73ab8b
