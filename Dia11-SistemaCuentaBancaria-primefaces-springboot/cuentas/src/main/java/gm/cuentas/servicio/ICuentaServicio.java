<<<<<<< HEAD
package gm.cuentas.servicio;

import gm.cuentas.modelo.Cuenta;

import java.util.List;

public interface ICuentaServicio {
    public List<Cuenta> listarCuentas();

    public Cuenta buscarCuentaPorId(int idCuenta);

    public void guardarCuenta(Cuenta cuenta);

    public void eliminarCuenta(Cuenta cuenta);
}
=======
package gm.cuentas.servicio;

import gm.cuentas.modelo.Cuenta;

import java.util.List;

public interface ICuentaServicio {
    public List<Cuenta> listarCuentas();

    public Cuenta buscarCuentaPorId(int idCuenta);

    public void guardarCuenta(Cuenta cuenta);

    public void eliminarCuenta(Cuenta cuenta);
}
>>>>>>> a5d00601b59c4ef50c903a5a5f408a5e7a73ab8b
