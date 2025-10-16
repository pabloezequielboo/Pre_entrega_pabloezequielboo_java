package Crudpoo;

public class Articulo extends Entidad {
    private String descripcion;
    private double precio;

    public Articulo(int id, String descripcion, double precio) {
        super(id);
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters y setters (encapsulamiento)
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    // Polimorfismo: redefinición del método abstracto
    @Override
    public String mostrarInformacion() {
        return "ID: " + getId() + " | Descripción: " + descripcion + " | Precio: $" + precio;
    }
}
