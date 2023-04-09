/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

/**
 *
 * @author aaraya
 */
public class Venta {
    private int numeroVenta;
    private static int nuevoId;
    private String numeroChasis;
    private String idComprador;
    private double precioVenta;
    private LocalDate fechaVenta;
    private static final int IVA = 13;
    private double totalIVA;
    private double totalVentaConIVA;
    private boolean anularVenta;


    public Venta(){
        
    }
    
    public static void setNumeroVenta() {
        nuevoId++;
    }
    
    public Venta(String numeroChasis, String idComprador, double precioVenta, LocalDate fechaVenta ) {
        setNumeroVenta();
//        this.anularVenta = anularventa;
        this.numeroVenta = nuevoId;
        this.numeroChasis = numeroChasis;
        this.idComprador = idComprador;
        this.precioVenta = precioVenta;
        this.fechaVenta = fechaVenta;
        this.totalIVA = precioVenta * (IVA/100.0);
        this.totalVentaConIVA = precioVenta + totalIVA;
    }
    
    public int getNumeroVenta(){
        return numeroVenta;
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

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }
    
    public String getFechaVentaAsStr() {
        return fechaVenta.getDayOfMonth() + "/" + fechaVenta.getMonth() + "/" + fechaVenta.getYear();
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotalVentaConIVA() {
        return totalVentaConIVA;
    }

    public void setTotalVentaConIVA(double totalVenta) {
        this.totalVentaConIVA = totalVenta;
    }
    public boolean isAnularVenta() {
        return anularVenta;
    }

    public void setAnularVenta(boolean anularVenta) {
        this.anularVenta = anularVenta;
    }
    
    
    @Override
    public String toString() {
     
        StringBuilder sb = new StringBuilder();
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "CR"));
        sb.append("**** Información de la venta # ").append(numeroVenta).append("****");
        sb.append("\nVehículo: ").append(numeroChasis);
        sb.append("\nIdentificador comprador: ").append(idComprador);
        sb.append("\nFecha de venta: ")
                .append(fechaVenta.getDayOfMonth())
                .append('/')
                .append(fechaVenta.getMonth())
                .append('/')
                .append(fechaVenta.getYear());
        sb.append("\nPrecio de venta: ").append(formatoMoneda.format(precioVenta));
        sb.append("\nTotal de IVA: ").append(formatoMoneda.format(totalIVA));
        sb.append("\nTotal de venta con IVA: ").append(formatoMoneda.format(totalVentaConIVA));
        sb.append("\n--------\n");
        
        return sb.toString();
    }   
}
