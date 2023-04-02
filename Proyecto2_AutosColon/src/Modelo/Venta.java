/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author aaraya
 */
public class Venta {
    private String numeroChasis;
    private String idComprador;
    private double precioVenta;
    private String fechaVenta;
    private static final int IVA = 13;
    private double totalVenta;
    
    public Venta(){
        
    }

    public Venta(String numeroChasis, String idComprador, double precioVenta, String fechaVenta, double totalVenta) {
        this.numeroChasis = numeroChasis;
        this.idComprador = idComprador;
        this.precioVenta = precioVenta;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public String getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(String idComprador) {
        this.idComprador = idComprador;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }
}
