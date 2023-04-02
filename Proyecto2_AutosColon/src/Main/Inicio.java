package Main;

import Controladores.AutosController;
import Controladores.PersonasController;
import Controladores.MENU;
import Controladores.VentasController;

public class Inicio {
    public static MENU metodos = new MENU();
    public static AutosController autos = new AutosController();
    public static PersonasController personas = new PersonasController();
    public static VentasController ventas = new VentasController();
    
    public static void main(String[] args) {
        menuPrincipal();
    }
    
    public static void menuPrincipal(){        
        String[] opciones = {"Autos","Personas","Ventas","Salir"};
        int opcion= -1;
        while (opcion!=opciones.length-1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Reservaciones 1.0", opciones, "Salir");
            switch (opcion) {
                case 0:   
                    autos.menuPersonas();
               
                    
                    break;
                case 1: 
                    personas.menuPersonas();
                    break;
                case 2:  
                    ventas.menuPersonas();
                    break;
                case 3:
                    int salir = metodos.SIoNo("Realmente desea salir?", "Atención");
                    if (salir==1){
                        opcion=-1;
                    }
                    else{
                        metodos.msg("Gracias por su visita...");
                        System.exit(0);
                    }
            }
        }
    }
}
