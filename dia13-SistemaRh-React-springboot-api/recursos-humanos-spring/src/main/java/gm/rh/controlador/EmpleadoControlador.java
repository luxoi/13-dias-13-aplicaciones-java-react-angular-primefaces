package gm.rh.controlador;

import gm.rh.excepcion.RecursoNoEncontradoExcepcion;
import gm.rh.modelo.Empleado;
import gm.rh.servicio.EmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://localhost:8080/rh-app/empleados/1
@RequestMapping("/rh-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlador {


    private static final Logger logger =
            LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping("/empleados")
    public List<Empleado> listaEmpleados(){
        var empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado -> logger.info(empleado.toString())));
        return empleados;
    }

    @PostMapping("/agregar-empleados")
    public Empleado agregarEmpleados(@RequestBody Empleado empleado){
        logger.info("El empleado a agregar: "+empleado);
        return empleadoServicio.guardarEmpleado(empleado);
    }

    @GetMapping("/agregar-empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
        if (empleado == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el empleado id: "+id);
        }else{
            return ResponseEntity.ok(empleado);
        }
    }

    @PutMapping("/agregar-empleados/{id}")
    public ResponseEntity<Empleado> editarEmpleado(@PathVariable Integer id,
                                                   @RequestBody Empleado empleadoRecibido){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
        if (empleado==null){
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe: "+id);
        }else{
            empleado.setNombre(empleadoRecibido.getNombre());
            empleado.setDepartamento(empleadoRecibido.getDepartamento());
            empleado.setSueldo(empleadoRecibido.getSueldo());
            empleadoServicio.guardarEmpleado(empleado);
            return ResponseEntity.ok(empleado);
        }
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(@PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
        if (empleado == null){
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe: "+id);
        }else {
            empleadoServicio.eliminarEmpleado(empleado);
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
        }//json{"eliminado": true}
    }

}

