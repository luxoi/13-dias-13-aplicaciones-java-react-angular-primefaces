package gm.cuentas.servicio;

import gm.cuentas.modelo.Cuenta;
import gm.cuentas.repositorio.CuentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServicio implements ICuentaServicio{

    @Autowired
    private CuentaRepositorio cr;
    @Override
    public List<Cuenta> listarCuentas() {
        return cr.findAll();
    }

    @Override
    public Cuenta buscarCuentaPorId(int idCuenta) {
        Cuenta cuenta = cr.findById(idCuenta).orElse(null);
        return cuenta;
    }

    @Override
    public void guardarCuenta(Cuenta cuenta) {
        cr.save(cuenta);
    }

    @Override
    public void eliminarCuenta(Cuenta cuenta) {
        cr.delete(cuenta);
    }
}
