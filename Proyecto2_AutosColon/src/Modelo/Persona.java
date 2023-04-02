package Modelo;

public class Persona {

    private String numeroId;
    private String nombre;
    private String numeroTelefono;
    private String email;
    
    public Persona() {
    }

    public Persona(String id, String nombre, String numeroTelefono, String email) {
        this.numeroId = id;
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
    }
    
    public String getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(String id) {
        this.numeroId = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Id: " + numeroId + " Nombre=" + nombre;
    }
    
    public String toInforme(){
        return "Id: " + numeroId + " Nombre=" + nombre+"\n";
    }           
}
