package crudpoo;

public abstract class Producto implements Imprimible {
    protected int id;
    protected String descripcion;
    protected double precio;

    public Producto() {}

    public Producto(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String imprimir() {
        return "Producto{id=" + id + ", descripcion='" + descripcion + "', precio=" + precio + "}";
    }
}
