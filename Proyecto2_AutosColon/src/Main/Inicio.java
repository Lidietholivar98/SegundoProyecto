package Main;

import Controladores.VehiculosController;
import Controladores.PersonasController;
import Controladores.UtilsController;
import Controladores.VentasController;
import javax.swing.JOptionPane;

public class Inicio {
    public static UtilsController metodos = new UtilsController();
    public static VehiculosController vehiculos = new VehiculosController();
    public static PersonasController personas = new PersonasController();
    public static VentasController ventas = new VentasController();
    
    public static void main(String[] args) {
        vehiculos.CargarDatos();
        personas.CargarDatos();
        menuPrincipal();
    }
    
    public static void menuPrincipal(){        
        String[] opciones = {"Vehículos","Personas","Ventas","Salir"};
        int opcion= -1;
        while (opcion!=opciones.length-1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Reservaciones de Vehiculos", opciones, "Salir");
            switch (opcion) {
                case 0:   
                    vehiculos.menuVehiculos();
                    break;
                case 1: 
                    personas.menuPersonas();
                    break;
                case 2:  
                    ventas.menuVentas();
                    break;
                case 3:
                    int salir = metodos.mensajeConfirmacionSIoNo("¿Realmente desea salir?", "Atención");
                    if (salir == JOptionPane.YES_NO_OPTION){
                        metodos.mensajeInformacion("Gracias por utilizar nuestro sistema");
                        System.exit(0);
                    }
                    else{
                        opcion= -1;
                    }
            }
        }
    }
}
