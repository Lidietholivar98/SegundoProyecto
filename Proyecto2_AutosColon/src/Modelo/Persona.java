package Modelo;

public class Persona {
    // 1. Atributos
    private int id;
    private String nombre;
    
    // 2. Constructores
    public Persona() {
    }

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    // 3. Get & Set (Encapsulamiento)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // 4. To String (Override)
    @Override
    public String toString() {
        return "Id: " + id + " Nombre=" + nombre;
    }
    
    public String toInforme(){
        return "Id: " + id + " Nombre=" + nombre+"\n";
    }
           
}
