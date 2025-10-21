package crudpoo;

public class Categoria {
    private int id;
    private String nombre;

    // contador estatico
    private static int contador = 1;
    
    public Categoria(){}
    // constructor con parametro
    public Categoria(String nombre) {
        this.id = contador++;
        this.nombre = nombre;
    }
     
    // getters y setters
    // Categoria categoria = new Categoria("Electronica");
    //id = categoria.getId()
    //categoria.setNombre("Electrodomesticos");
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // method para mostrar info de la categoria
    public String mostrarInfo() {
        return "Categoria | id=" + this.id + ", nombre='" + this.nombre + "'|";
    }

    /*@Override
    public String toString() {
        return "Categoria{id=" + id + ", nombre='" + nombre + "'}";
    }*/
}
