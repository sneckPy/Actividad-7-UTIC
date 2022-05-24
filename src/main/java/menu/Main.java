package menu;

import entidad.Producto;
import operaciones.Imprimir;
import operaciones.ManejadorProductos;
import operaciones.OrdenadorProductos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//Clase para acceder a los distintos metodos definidos en el programa anteriormente
public class Main {
    ManejadorProductos manejadorProductos = new ManejadorProductos();
    List<Producto> productos = new ArrayList<>();
    OrdenadorProductos ordenadorProductos = new OrdenadorProductos();
    Imprimir imprimir = new Imprimir();

    public static void main(String[] args) {
        Main main = new Main();
        main.opciones();
    }

    //Metodo para elegir la operacion deseada
    public void opciones() {
        String[] opciones = getArrayOpciones();
        try {
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion" +
                            "\n1- Agregar un producto" +
                            "\n2- Editar un producto" +
                            "\n3- Eliminar un producto" +
                            "\n4- Mostrar todos los productos" +
                            "\n5- Ordenar por ID" +
                            "\n6- Ordenar por nombre" +
                            "\n7- Ordenar por descripción" +
                            "\n8- Ordenar por código" +
                            "\n9- Imprimir Texto" +
                            "\n10- Salir del Programa",
                    "Nick Laconich CI: 5.224.943", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            switch (opcion) {
                case "1":
                    productos.add(manejadorProductos.agregar(productos));
                    break;
                case "2":
                    manejadorProductos.editar(productos);
                    break;
                case "3":
                    manejadorProductos.eliminar(productos);
                    break;
                case "4":
                    manejadorProductos.verProductos(productos);
                    break;
                case "5":
                    ordenadorProductos.ordenarId(productos);
                    manejadorProductos.verProductos(productos);
                    break;
                case "6":
                    ordenadorProductos.ordenarNombre(productos);
                    manejadorProductos.verProductos(productos);
                    break;
                case "7":
                    ordenadorProductos.ordenarDescripcion(productos);
                    manejadorProductos.verProductos(productos);
                    break;
                case "8":
                    ordenadorProductos.ordenarCodigo(productos);
                    manejadorProductos.verProductos(productos);
                    break;
                case "9":
                    imprimir.imprimirProductos(productos);
                    break;
                case "10":
                    return;
            }
            opciones();
        } catch (Exception e) {
            opciones();
        }
    }

    //Metodo para definir el array de operaciones disponibles
    public String[] getArrayOpciones() {
        String[] opciones = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        return opciones;
    }

}
