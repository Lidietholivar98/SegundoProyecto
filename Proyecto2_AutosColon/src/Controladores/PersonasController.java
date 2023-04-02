package Controladores;

//Implementar los métodos abstractos de la interface.
import Interfaces.CrudInterfaces;
import static Main.Inicio.metodos;
import java.util.ArrayList;
import java.util.List;

//Usamos implements
//Implementar los métodos abstractos
public class PersonasController implements CrudInterfaces {

    //Implementa la clase MetodosController (Copia)
    MENU metodos = new MENU();
    private static List lista = new ArrayList();
    
    @Override
    public void Crear() {

    }

    @Override
    public void Modificar() {

    }

    @Override
    public void Anular() {

    }

    @Override
    public void Eliminar() {

    }

    @Override
    public void Informe() {

    }

    @Override
    public void Buscar() {

    }

    public boolean Alquila(int idPersona) {
        //Aquí va el código que busca en la lista de alquileres una persona
        int existe = metodos.SIoNo("Esta alquilando?", "Atención");
        if (existe == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void menuPersonas(){        
        String[] opciones = {"Crear","Modificar","Ver","Eliminar","Informe","Volver"};
        int opcion= -1;
        while (opcion!=opciones.length-1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Personas", opciones, "Volver");
            switch (opcion) {
                case 0:                   
                    break;
                case 1: 
                    Crear();
                    break;
                case 2:   
                    Modificar();
                    break;  
                case 3:         
                    Anular();
                    break; 
                case 4:   
                    Informe();
                    break; 
                    
            }
        }
    }
}
