package gm.inventario.servicio;

import gm.inventario.modelo.Producto;
import gm.inventario.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio{
    @Autowired
    ProductoRepositorio pr;

    @Override
    public List<Producto> listarProductos() {
        return this.pr.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        Producto producto =
                this.pr.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
       return this.pr.save(producto);
    }

    @Override
    public void eliminarProductoPorId(Integer idProducto) {
        this.pr.deleteById(idProducto);
    }
}
