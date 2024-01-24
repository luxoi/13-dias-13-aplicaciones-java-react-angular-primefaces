<<<<<<< HEAD
package gm.contactos.servicio;

import gm.contactos.modelo.Contacto;
import gm.contactos.repositorio.ContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServicio implements IContactoServicio{

    @Autowired
    private ContactoRepositorio cr;

    @Override
    public List<Contacto> listarContacto() {
        return cr.findAll();
    }

    @Override
    public Contacto buscarContactoPorId(Integer idContacto) {
        Contacto contacto = cr.findById(idContacto).orElse(null);
        return contacto;
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        cr.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto contacto) {
        cr.delete(contacto);
    }
}
=======
package gm.contactos.servicio;

import gm.contactos.modelo.Contacto;
import gm.contactos.repositorio.ContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServicio implements IContactoServicio{

    @Autowired
    private ContactoRepositorio cr;

    @Override
    public List<Contacto> listarContacto() {
        return cr.findAll();
    }

    @Override
    public Contacto buscarContactoPorId(Integer idContacto) {
        Contacto contacto = cr.findById(idContacto).orElse(null);
        return contacto;
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        cr.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto contacto) {
        cr.delete(contacto);
    }
}
>>>>>>> a5d00601b59c4ef50c903a5a5f408a5e7a73ab8b
