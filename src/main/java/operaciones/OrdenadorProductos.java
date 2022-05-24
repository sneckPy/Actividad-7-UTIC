package operaciones;

import entidad.Producto;

import java.util.Comparator;
import java.util.List;

//Clase para ordenar la lista de Productos
public class OrdenadorProductos {

    //Metodo para ordenar la lista de productos por id
    public List<Producto> ordenarId(List<Producto> productos) {
        productos.sort(Comparator.comparing(producto -> producto.getIdProducto()));
        return productos;
    }

    //Metodo para ordenar la lista de productos por nombre
    public List<Producto> ordenarNombre(List<Producto> productos) {
        productos.sort(Comparator.comparing(producto -> producto.getNombre()));
        return productos;
    }

    //Metodo para ordenar la lista de productos por descripcion
    public List<Producto> ordenarDescripcion(List<Producto> productos) {
        productos.sort(Comparator.comparing(producto -> producto.getDescripcion()));
        return productos;
    }

    //Metodo para ordenar la lista de productos por codigo
    public List<Producto> ordenarCodigo(List<Producto> productos) {
        productos.sort(Comparator.comparing(producto -> producto.getCodigo()));
        return productos;
    }

}
