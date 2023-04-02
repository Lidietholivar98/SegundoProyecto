/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Interfaces.CrudInterfaces;
import static Main.Inicio.menuPrincipal;
import Modelo.Persona;
import Modelo.Vehiculo;
import Modelo.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VentasController implements CrudInterfaces {

    UtilsController metodos = new UtilsController();
    PersonasController personas = new PersonasController();
    VehiculosController vehiculos = new VehiculosController();
    private static List<Venta> ventas = new ArrayList();

    @Override
    public void Crear() {
        String numeroChasis;
        String idComprador;
        double precioVenta;
        String fechaVenta;
        double totalVenta;

        numeroChasis = JOptionPane.showInputDialog("Ingrese el número de chasis del vehículo: ");
        
        if (numeroChasis.length() > 0) {
            idComprador = JOptionPane.showInputDialog("Ingrese la identificación del comprador: ");
            //Vehiculo vehiculo = vehiculos.buscarPorChasis(numeroChasis);
            //Persona persona = personas.buscarPorId(idComprador);
            
            precioVenta = Double.parseDouble(JOptionPane.showInputDialog("El precio del vehículo es: "));
            fechaVenta = JOptionPane.showInputDialog("Ingrese la fecha de venta: ");
            totalVenta = 0;
            
            Venta venta = new Venta(numeroChasis, idComprador, precioVenta, fechaVenta, totalVenta);
            ventas.add(venta);
        } else {
            menuVentas();
        }
    }
    
    @Override
    public void Ver() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void menuVentas() {
        String[] opciones = {"Registrar", "Anular", "Consultar", "Informe", "Volver"};
        int opcion = -1;
        while (opcion != opciones.length - 1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Personas", opciones, "Volver");
            switch (opcion) {
                case 0:
                    Crear();
                    break;
                case 1:
                    Anular();
                    break;
                case 2:
                    Ver();
                    break;
                case 3:
                    Informe();
                    break;
                case 4:
                    menuPrincipal();
                    break;
            }
        }
    }

    @Override
    public void Anular() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Informe() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Boolean existeVenta(String chasis) {
        boolean existe = false;
        for (Venta venta : ventas) {
            if (venta.getNumeroChasis().equals(chasis)) {
                existe = true;
                break;
            }
        }

        return existe;
    }
}
