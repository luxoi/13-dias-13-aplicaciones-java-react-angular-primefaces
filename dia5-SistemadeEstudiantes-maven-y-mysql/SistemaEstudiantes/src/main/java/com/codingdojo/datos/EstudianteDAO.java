<<<<<<< HEAD
package com.codingdojo.datos;

import com.codingdojo.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static com.codingdojo.conexion.Conexion.getConexion;

// DAO -DATA ACCESS OBJECT
public class EstudianteDAO {
    public List<Estudiante> listar(){
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiantes ORDER BY id_estudiante";

        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setEmail(rs.getString("email"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiantes.add(estudiante);
            }
            con.close();

        }catch (Exception e){
            System.out.println("Ocurrio un error al seleccionar datos: "+e.getMessage());
        }
        finally{
            try{
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar conexion: "+e.getMessage());
            }
        }
        return estudiantes;
    }

    //FIndById
    public boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiantes WHERE id_estudiante = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if(rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar estudiante: "+e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar conexion: "+e.getMessage());
            }
        }
        return false;
    }

    public boolean agregarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con =  getConexion();
        String sql = "INSERT INTO estudiantes(nombre, apellido, telefono, email) "+
                "VALUES(?, ?, ?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.execute();
            return true;
        } catch(Exception e){
            System.out.println("Error al agregar estudiante: "+e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch(Exception e){
                System.out.println("Error al cerrar conexion: "+e.getMessage());
             }
        }

        return false;
    }

    public boolean modificar (Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE estudiantes SET nombre=?, apellido=?, telefono=?, email=? WHERE id_estudiante=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al modificar estudiante: "+e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: "+e.getMessage());
            }

        }

        return false;
    }

    public boolean eliminar(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM estudiantes WHERE id_estudiante = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al eliminar estudiante: "+e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: "+e.getMessage());
            }
        }
        return false;


    }

    public static void main(String[] args) {

        //agregar estudiante
           var estudianteDao = new EstudianteDAO();
//        var nuevoEstudiante = new Estudiante("Carlos", "Lara", "5555515", "carlos@gmail.com");
//        var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
//        if (agregado){
//            System.out.println("Estudiante agregado: "+nuevoEstudiante);
//        }else{
//            System.out.println("No se agrego el estudiante: "+nuevoEstudiante);
//        }

//        // Modificamos un estudiante existente
//        var estudianteModificar = new Estudiante(1, "Luxoi", "Juarez", "5544322", "juan@gmail.com");
//        var modificado = estudianteDao.modificar(estudianteModificar);
//        if(modificado){
//            System.out.println("Estudiante modificado: "+ estudianteModificar);
//
//        }else {
//            System.out.println("No se modifico estudiante: "+estudianteModificar);
//        }

        //Eliminar estudiante
        var estudianteEliminar = new Estudiante(2);
        var eliminado = estudianteDao.eliminar(estudianteEliminar);
        if (eliminado){
            System.out.println("Estudiante eliminado: "+estudianteEliminar);
        }else{
            System.out.println("No se pudo eliminar: "+estudianteEliminar);
        }

        //listar estudiantes
        System.out.println("Listado de estudiantes: ");
        List<Estudiante> estudiantes = estudianteDao.listar();
        estudiantes.forEach(System.out::println);

//        //Buscar por id
//        var estudiante1 = new Estudiante(1);
//        System.out.println("Estudiante antes de la busqueda: "+estudiante1);
//        var encontrado  = estudianteDao.buscarEstudiantePorId(estudiante1);
//        if(encontrado){
//            System.out.println("Estudiante encontrado: "+estudiante1);
//        }else{
//            System.out.println("No se encontro estudiante "+estudiante1.getIdEstudiante());
//        }
    }

}
=======
package com.codingdojo.datos;

import com.codingdojo.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static com.codingdojo.conexion.Conexion.getConexion;

// DAO -DATA ACCESS OBJECT
public class EstudianteDAO {
    public List<Estudiante> listar(){
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiantes ORDER BY id_estudiante";

        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setEmail(rs.getString("email"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiantes.add(estudiante);
            }
            con.close();

        }catch (Exception e){
            System.out.println("Ocurrio un error al seleccionar datos: "+e.getMessage());
        }
        finally{
            try{
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar conexion: "+e.getMessage());
            }
        }
        return estudiantes;
    }

    //FIndById
    public boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiantes WHERE id_estudiante = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if(rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar estudiante: "+e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar conexion: "+e.getMessage());
            }
        }
        return false;
    }

    public boolean agregarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con =  getConexion();
        String sql = "INSERT INTO estudiantes(nombre, apellido, telefono, email) "+
                "VALUES(?, ?, ?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.execute();
            return true;
        } catch(Exception e){
            System.out.println("Error al agregar estudiante: "+e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch(Exception e){
                System.out.println("Error al cerrar conexion: "+e.getMessage());
             }
        }

        return false;
    }

    public boolean modificar (Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE estudiantes SET nombre=?, apellido=?, telefono=?, email=? WHERE id_estudiante=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al modificar estudiante: "+e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: "+e.getMessage());
            }

        }

        return false;
    }

    public boolean eliminar(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM estudiantes WHERE id_estudiante = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al eliminar estudiante: "+e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: "+e.getMessage());
            }
        }
        return false;


    }

    public static void main(String[] args) {

        //agregar estudiante
           var estudianteDao = new EstudianteDAO();
//        var nuevoEstudiante = new Estudiante("Carlos", "Lara", "5555515", "carlos@gmail.com");
//        var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
//        if (agregado){
//            System.out.println("Estudiante agregado: "+nuevoEstudiante);
//        }else{
//            System.out.println("No se agrego el estudiante: "+nuevoEstudiante);
//        }

//        // Modificamos un estudiante existente
//        var estudianteModificar = new Estudiante(1, "Luxoi", "Juarez", "5544322", "juan@gmail.com");
//        var modificado = estudianteDao.modificar(estudianteModificar);
//        if(modificado){
//            System.out.println("Estudiante modificado: "+ estudianteModificar);
//
//        }else {
//            System.out.println("No se modifico estudiante: "+estudianteModificar);
//        }

        //Eliminar estudiante
        var estudianteEliminar = new Estudiante(2);
        var eliminado = estudianteDao.eliminar(estudianteEliminar);
        if (eliminado){
            System.out.println("Estudiante eliminado: "+estudianteEliminar);
        }else{
            System.out.println("No se pudo eliminar: "+estudianteEliminar);
        }

        //listar estudiantes
        System.out.println("Listado de estudiantes: ");
        List<Estudiante> estudiantes = estudianteDao.listar();
        estudiantes.forEach(System.out::println);

//        //Buscar por id
//        var estudiante1 = new Estudiante(1);
//        System.out.println("Estudiante antes de la busqueda: "+estudiante1);
//        var encontrado  = estudianteDao.buscarEstudiantePorId(estudiante1);
//        if(encontrado){
//            System.out.println("Estudiante encontrado: "+estudiante1);
//        }else{
//            System.out.println("No se encontro estudiante "+estudiante1.getIdEstudiante());
//        }
    }

}
>>>>>>> a5d00601b59c4ef50c903a5a5f408a5e7a73ab8b
