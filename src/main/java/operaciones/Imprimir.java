package operaciones;

import entidad.Producto;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//Metodo para imprimir en txt la lista de productos
public class Imprimir {

    public void imprimirProductos(List<Producto> productos) {
        try {
            File file = new File("Lista-de-Productos.txt");
            //Si no existe el archivo txt crea uno nuevo
            if (!file.exists()) {
                file.createNewFile();
            }
            //Imprime la lista de productos en el txt
            PrintWriter printWriter = new PrintWriter(file);
            for (Producto producto : productos) {
                printWriter.println("ID: " + producto.getIdProducto() + ", Nombre: " + producto.getNombre() + ", Descripcion: " + producto.getDescripcion() +
                        ", Código: " + producto.getCodigo());
            }
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
