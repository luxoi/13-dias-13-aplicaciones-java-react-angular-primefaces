<<<<<<< HEAD
    package gm.empleados.controlador;

    import gm.empleados.modelo.Empleado;
    import gm.empleados.servicio.EmpleadoServicio;
    import jakarta.servlet.http.HttpServletRequest;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.ModelMap;
    import org.springframework.web.bind.annotation.*;

    import javax.management.modelmbean.ModelMBean;
    import java.util.List;


    @Controller
    public class IndexControllador {
        private static final Logger logger=
                LoggerFactory.getLogger(IndexControllador.class);

        @Autowired
        EmpleadoServicio empleadoServicio;

        @GetMapping("/")
        public String iniciar(ModelMap modelo){
            List<Empleado> empleados = empleadoServicio.listarEmpleados();
            empleados.forEach((empleado -> logger.info(empleado.toString())));
            modelo.put("empleados", empleados);
            return "index";
        }

        @GetMapping("/agregar")
        public String mostrarAgregar(){
            return "agregar";
        }

        @PostMapping("/agregarempleado")
        public String Agregar(@ModelAttribute("empleadoForm")Empleado empleado){
            logger.info("empleado a agregar: "+empleado);
                empleadoServicio.guardarEmpleado(empleado);
                return "redirect:/";
        }

        @GetMapping("/editar/{idEmpleado}")
        public String mostrarEditar(@PathVariable("idEmpleado") int idEmpleado, ModelMap modelo){
            Empleado empleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
            logger.info("Empleado a editar " + empleado);
            modelo.put("empleado", empleado);
            return "editar";
        }


        @PutMapping("/editar")
        public String editar(@ModelAttribute("empleadoForm") Empleado empleado){
            logger.info("Empleado a guardar (editar): "+empleado);
            empleadoServicio.guardarEmpleado(empleado);
            return "redirect:/";
        }

        @GetMapping("/eliminar/{idEmpleado}")
        public String eliminarEmpleado(@PathVariable int idEmpleado) {
            Empleado empleado = new Empleado();
            empleado.setIdEmpleado(idEmpleado);
            empleadoServicio.eliminarEmpleado(empleado);
            return "redirect:/";
        }


    }
=======
    package gm.empleados.controlador;

    import gm.empleados.modelo.Empleado;
    import gm.empleados.servicio.EmpleadoServicio;
    import jakarta.servlet.http.HttpServletRequest;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.ModelMap;
    import org.springframework.web.bind.annotation.*;

    import javax.management.modelmbean.ModelMBean;
    import java.util.List;


    @Controller
    public class IndexControllador {
        private static final Logger logger=
                LoggerFactory.getLogger(IndexControllador.class);

        @Autowired
        EmpleadoServicio empleadoServicio;

        @GetMapping("/")
        public String iniciar(ModelMap modelo){
            List<Empleado> empleados = empleadoServicio.listarEmpleados();
            empleados.forEach((empleado -> logger.info(empleado.toString())));
            modelo.put("empleados", empleados);
            return "index";
        }

        @GetMapping("/agregar")
        public String mostrarAgregar(){
            return "agregar";
        }

        @PostMapping("/agregarempleado")
        public String Agregar(@ModelAttribute("empleadoForm")Empleado empleado){
            logger.info("empleado a agregar: "+empleado);
                empleadoServicio.guardarEmpleado(empleado);
                return "redirect:/";
        }

        @GetMapping("/editar/{idEmpleado}")
        public String mostrarEditar(@PathVariable("idEmpleado") int idEmpleado, ModelMap modelo){
            Empleado empleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
            logger.info("Empleado a editar " + empleado);
            modelo.put("empleado", empleado);
            return "editar";
        }


        @PutMapping("/editar")
        public String editar(@ModelAttribute("empleadoForm") Empleado empleado){
            logger.info("Empleado a guardar (editar): "+empleado);
            empleadoServicio.guardarEmpleado(empleado);
            return "redirect:/";
        }

        @GetMapping("/eliminar/{idEmpleado}")
        public String eliminarEmpleado(@PathVariable int idEmpleado) {
            Empleado empleado = new Empleado();
            empleado.setIdEmpleado(idEmpleado);
            empleadoServicio.eliminarEmpleado(empleado);
            return "redirect:/";
        }


    }
>>>>>>> a5d00601b59c4ef50c903a5a5f408a5e7a73ab8b
