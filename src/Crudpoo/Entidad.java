package Crudpoo;

public abstract class Entidad {
    private int id;

    public Entidad(int id) {
        this.id = id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // Método abstracto (Polimorfismo)
    public abstract String mostrarInformacion();
}
