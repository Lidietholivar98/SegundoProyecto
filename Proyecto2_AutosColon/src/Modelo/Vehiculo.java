/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.NumberFormat;
import java.util.Locale;

public class Vehiculo {
    private int numeroVehiculo;
    private String numeroChasis;
    private String marca;
    private int modelo;
    private String estilo;    
    private String color;
    private double precio;
    private static int nuevoNumeroVehiculo;
    private Boolean estaAlquilado;

    public Vehiculo() {}

    public static void setNuevoNumeroVehiculo() {
        nuevoNumeroVehiculo++;
    }

    public Vehiculo( String numeroChasis, String marca, String estilo, int modelo, String color, double precio) {
        setNuevoNumeroVehiculo();
        this.numeroVehiculo = nuevoNumeroVehiculo;
        this.numeroChasis = numeroChasis;
        this.marca = marca;
        this.estilo = estilo;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.estaAlquilado = false;
    }
    
    public int getNumeroVehiculo() {
        return numeroVehiculo;
    }

    public void setNumeroVehiculo(int numeroVehiculo) {
        this.numeroVehiculo = numeroVehiculo;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void marcarComoAlquilado(){
        this.estaAlquilado = true;
    }
    
    public void marcarComoDevuelto(){
        this.estaAlquilado = false;
    }
    
    public Boolean estaAlquilado(){
        return estaAlquilado;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "CR"));
        sb.append("**** Información del vehículo ****");
        sb.append("\nNúmero de chasis: ").append(numeroChasis);
        sb.append("\nMarca: ").append(marca);
        sb.append("\nModelo: ").append(modelo);
        sb.append("\nEstilo: ").append(estilo);
        sb.append("\nColor: ").append(color);
        sb.append("\nPrecio: ").append(formatoMoneda.format(precio));
        sb.append("\n--------\n");
        return sb.toString();
    }
}
