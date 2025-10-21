package crudpoo;

public class Articulo extends Producto {
    // que es el encapsulamiento?
    // Es una forma de proteger los datos de una clase, restringiendo el acceso directo a sus atributos.
    // atributos privados --> solo se pueden acceder mediante metodos publicos (getters y setters)
    // beneficios: control sobre los datos, validacion, mantenimiento, seguridad
    // ejemplo: si queremos que el precio de un articulo no sea negativo, podemos validar en el setter
    // si el atributo es publico, cualquiera puede modificarlo sin restricciones
    // contador estatico para asignar ids unicos a cada articulo
    private static int contador = 1;
    // constructor sin parametros por defecto que crea java automaticamente y solo crea una instancia en memoria sin inicializar atributos

    // Los constructores son metodos especiales que se llaman cuando se crea una instancia de una clase
    // Sirven para inicializar los atributos de la clase
    // Si no definimos un constructor, java crea uno por defecto sin parametros
    // Podemos sobrecargar el constructor creando varios con diferentes parametros
    // Los constructores no son methods static porque se llaman cuando se crea una instancia de la clase
    // No tienen tipo de retorno ni void
    // El nombre del constructor es el mismo que el de la clase

    public Articulo() {}

    // constructor con parametros (descripcion, precio)
    public Articulo(String descripcion, double precio) {
        super(descripcion, precio);
        this.setId(contador++);
    }
    // getters y setters
    // para que sirven?
    // Permiten acceder y modificar los atributos privados de una clase desde fuera de la clase
    // Getters: devuelven el valor de un atributo
    // Setters: modifican el valor de un atributo
    // Validacion: podemos validar los datos antes de asignarlos a un atributo en el setter
    // get/set heredados de Producto
    @Override
    public void setPrecio(double precio) {
        // validamos precio no negativo
        if (precio < 0) {
            this.precio = 0;
        } else {
            this.precio = precio;
        }
    }
    // setPrecio que valide que el precio no sea negativo
    // if (precio < 0) { this.precio = 0; } else { this.precio = precio; }

    // ejemplo de un método que no es un getter ni un setter
    public String mostrarInfo() {
        return "Articulo | id=" + this.getId() + ", descripcion='" + this.getDescripcion() + "', precio=" + this.getPrecio() + "|";
    }

    // sobrecarga del método mostrarInfo
    public String mostrarInfo(boolean conDescripcion) {
        return mostrarInfo();
    }

    // sobreescribimos el metodo toString() para mostrar la informacion del articulo
    // toString() es un metodo de la clase Object que todas las clases heredan
    // sirve para representar un objeto como una cadena de texto
    // por defecto devuelve la direccion de memoria del objeto
    // podemos sobreescribirlo para mostrar la informacion que queramos
    // @Override es una anotacion que indica que estamos sobreescribiendo un metodo de la superclase
    // nos ayuda a evitar errores de sintaxis y a mejorar la legibilidad del codigo
    // ejemplo: si queremos mostrar el nombre y el precio del articulo, podemos sobreescribir toString()
    // y devolver una cadena con esa informacion
    // cuando imprimimos un objeto, java llama automaticamente al metodo toString()
    // System.out.println(articulo) --> articulo.toString()
    @Override
    public String toString() {
        return imprimir();
    }

    @Override
    public String imprimir() {
        return "Articulo{id=" + this.getId() + ", descripcion='" + this.getDescripcion() + "', precio=" + this.getPrecio() + "}";
    }

}
