package gm.contactos.controlador;

import gm.contactos.modelo.Contacto;
import gm.contactos.servicio.ContactoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactoControlador {
    @Autowired
    ContactoServicio cs;

    private static final Logger logger =
            LoggerFactory.getLogger(ContactoControlador.class);

    @GetMapping("/")
    public String index(ModelMap modelo){
        List<Contacto> contactos = cs.listarContacto();
        contactos.forEach((contacto -> logger.info(contacto.toString())));
        modelo.put("contactos", contactos);
        return "index";
    }

    @GetMapping("/agregar")
    public String mostrarFormulario(){
        return "agregar";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("contactoForm") Contacto contacto){
        logger.info("Contacto a agregar: "+contacto);
        cs.guardarContacto(contacto);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable("id")int idContacto,
                                ModelMap modelo){
        Contacto contacto = cs.buscarContactoPorId(idContacto);
        logger.info("Contacto a editar(mostrar): "+contacto);
        modelo.put("contacto", contacto);
        return "editar";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("contacto")Contacto contacto){
        logger.info("Contacto a guardar(editar): "+contacto);
        cs.guardarContacto(contacto);
        return "redirect:/";
    }

    @GetMapping("eliminar/{id}")
    public String eliminar(@PathVariable("id") int idContacto){
        Contacto contacto = new Contacto();
        contacto.setIdContacto(idContacto);
        cs.eliminarContacto(contacto);
        return "redirect:/";
    }

}
