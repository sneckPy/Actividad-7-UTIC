package operaciones;

import entidad.Producto;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

//Clase para hacer operaciones de altas, bajas y modificaciones del objeto Producto
public class ManejadorProductos {
    OrdenadorProductos ordenadorProductos = new OrdenadorProductos();

    //Metodo para agregar un producto a la lista de productos
    public Producto agregar(List<Producto> productos) {
        Producto producto = new Producto();
        //Ordena los productos por id para determinar el id del siguiente producto
        productos = ordenadorProductos.ordenarId(productos);
        producto.setIdProducto(getUltimoID(productos));
        //Agrega los elementos faltantes del objeto producto
        setProducto(producto);
        return producto;
    }

    //Metodo para eliminar un producto de la lista de productos
    public List<Producto> eliminar(List<Producto> productos) {
        //Pide que selecciones el producto a eliminar
        Producto productoSeleccionado = seleccionProducto(productos);
        //Elimina el producto si el id del producto de la lista de productos coincide con el id del producto seleccionado
        productos.removeIf(producto -> producto.getIdProducto() == productoSeleccionado.getIdProducto());
        return productos;
    }

    //Metodo para editar los productos
    public List<Producto> editar(List<Producto> productos) {
        //Pide que selecciones el producto a editar
        Producto productoSeleccionado = seleccionProducto(productos);
        //Edita el producto si el id del producto de la lista de productos coincide con el id del producto seleccionado
        productos.stream().filter(producto -> producto.getIdProducto() == productoSeleccionado.getIdProducto()).forEach(this::setProducto);
        return productos;
    }

    //Metodo para ver todos los productos
    public void verProductos(List<Producto> productos) {
        //Convierte la coleccion de productos de tipo List a tipo Array
        Producto[] productoArray = listToArray(productos);
        //Muesta el array de productos en una ventana emergente
        JOptionPane.showMessageDialog(null, new JList(productoArray));
    }

    //Metodo para seleccionar un producto
    private Producto seleccionProducto(List<Producto> productoList) {
        Producto[] productoArray = listToArray(productoList);
        Producto opcion = (Producto) JOptionPane.showInputDialog(null, "Selecciona un producto", "Seleccione", JOptionPane.QUESTION_MESSAGE, null, productoArray, productoArray[0]);
        return opcion;
    }

    //Metodo para convertir de tipo list a tipo array
    private Producto[] listToArray(List<Producto> productoList) {
        Producto productoArray[] = new Producto[productoList.size()];
        for (int i = 0; i < productoList.size(); i++) {
            Producto producto = productoList.get(i);
            productoArray[i] = producto;
        }
        return productoArray;
    }

    //Metodo para definir algunos componentes del objeto producto
    private void setProducto(Producto producto) {
        producto.setNombre(JOptionPane.showInputDialog("Inserte Nombre del Producto"));
        producto.setDescripcion(JOptionPane.showInputDialog("Inserte la descripcion del Producto"));
        producto.setCodigo(JOptionPane.showInputDialog("Inserte el codigo del producto"));
    }

    //Metodo para obtener el id del ultimo producto de la lista de productos
    private int getUltimoID(List<Producto> productos) {
        if (!productos.isEmpty()) {
            LinkedList<Producto> linkedList = new LinkedList<Producto>(productos);
            Producto producto = linkedList.getLast();
            return producto.getIdProducto() + 1;
        } else {
            return 1;
        }
    }
}
