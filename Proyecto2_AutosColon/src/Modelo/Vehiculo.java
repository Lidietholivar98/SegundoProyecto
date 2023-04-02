/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Vehiculo {
    private int numeroVehiculo;
    private String numeroChasis;
    private String marca;
    private String estilo;
    private int modelo;
    private String color;
    private double precio;
    private static int nuevoNumeroVehiculo;   

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
}
