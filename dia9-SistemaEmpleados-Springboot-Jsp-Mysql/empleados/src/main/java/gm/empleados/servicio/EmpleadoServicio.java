<<<<<<< HEAD
package gm.empleados.servicio;

import gm.empleados.modelo.Empleado;
import gm.empleados.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{

    @Autowired
    EmpleadoRepositorio ep;

    @Override
    public List<Empleado> listarEmpleados() {
        return ep.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorId(Integer idEmpleado) {
        Empleado empleado = ep.findById(idEmpleado).orElse(null);
        return empleado;
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        ep.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        ep.delete(empleado);
    }
}
=======
package gm.empleados.servicio;

import gm.empleados.modelo.Empleado;
import gm.empleados.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{

    @Autowired
    EmpleadoRepositorio ep;

    @Override
    public List<Empleado> listarEmpleados() {
        return ep.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorId(Integer idEmpleado) {
        Empleado empleado = ep.findById(idEmpleado).orElse(null);
        return empleado;
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        ep.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        ep.delete(empleado);
    }
}
>>>>>>> a5d00601b59c4ef50c903a5a5f408a5e7a73ab8b
