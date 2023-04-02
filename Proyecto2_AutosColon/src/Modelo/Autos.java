/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Autos {
    private int Nauto;
    private String NChasis;
    private String Marca;
    private String Estilo;
    private int Año;
    private String Color;
    private double Costo;
    private static int NewNauto;




    
    
    public Autos() {



}


    public static void setNewNauto() {
        NewNauto++;
    }

    public Autos( String NChasis, String Marca, String Estilo, int Año, String Color, double Costo) {
        setNewNauto();
        this.Nauto = NewNauto;
        this.NChasis = NChasis;
        this.Marca = Marca;
        this.Estilo = Estilo;
        this.Año = Año;
        this.Color = Color;
        this.Costo = Costo;
    }
    
       public int getNauto() {
        return Nauto;
    }

    public void setNauto(int Nauto) {
        this.Nauto = Nauto;
    }

    public String getNChasis() {
        return NChasis;
    }

    public void setNChasis(String NChasis) {
        this.NChasis = NChasis;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getEstilo() {
        return Estilo;
    }

    public void setEstilo(String Estilo) {
        this.Estilo = Estilo;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double Costo) {
        this.Costo = Costo;
    }



    
   
}
