/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Controladores.VehiculosController;
import Controladores.PersonasController;
import Interfaces.CrudInterfaces;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VentasController implements CrudInterfaces{
      MetodosController metodos = new MetodosController();
      
      private static List listautos = new ArrayList();
      private static List listventas = new ArrayList();
    
    
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

    @Override
    public void Crear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Anular() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Informe() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Buscar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
