package entidad;

//Clase donde se definen las características de los productos con sus respectivos accesos a los componentes del objeto
public class Producto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private String codigo;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "ID Producto= " + idProducto +
                ", Nombre= " + nombre +
                ", Descripcion= " + descripcion+
                ", Código= " + codigo;
    }
}
