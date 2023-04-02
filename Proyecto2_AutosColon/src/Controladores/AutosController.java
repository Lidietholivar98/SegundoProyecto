package Controladores;

import Interfaces.CrudInterfaces;
import static Main.Inicio.menuPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Modelo.Autos;


public class AutosController implements CrudInterfaces{
    
    MENU metodos = new MENU();
    private static List <Autos>listautos = new ArrayList();

    @Override
    public void Crear() {
        String NChasis;
        String Marca;
        String Estilo;
        int Modelo;
        String Color;
        double Costo;
        
        NChasis = JOptionPane.showInputDialog("Ingrese el numero de chasis del carro : ");
        if (NChasis.length()>0) {
            Marca = JOptionPane.showInputDialog("Ingrese la marca del vehiculo: ");
            Estilo = JOptionPane.showInputDialog("Cual es el estilo del vehiculo a ingresar: ");
            Modelo = Integer.parseInt(JOptionPane.showInputDialog("Que modelo es el Vehiculo: "));
            Color = JOptionPane.showInputDialog("Ingrese el color del vehiculo: ");
            Costo = Double.parseDouble(JOptionPane.showInputDialog("En que precio esta el vehiculo ingresado: "));

            Autos Auto = new Autos(NChasis, Marca, Estilo, Modelo, Color, Costo);
            listautos.add(Auto);
        }
        else
        {
            menuPersonas();
        }
        
        
       }

    @Override
    public void Buscar() {
       String Chasis = "";
       int indexAutos= -1;
       try
       {
           Chasis = JOptionPane.showInputDialog( "Ingrese el # del vehiculo: ");
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingreso un chasis no registrado");
       }
       
        for (int i = 0; i < listautos.size(); i++) {
            if (listautos.get(i).getNChasis().equals(Chasis) ) {
                indexAutos = i;
                break;
            }
        }

            if (indexAutos != -1) {
                String info = "";
                String NChasis = listautos.get(indexAutos).getNChasis();
                String Marca = listautos.get(indexAutos).getMarca();
                String Estilo = listautos.get(indexAutos).getEstilo();
                int Año = listautos.get(indexAutos).getAño();
                String Color = listautos.get(indexAutos).getColor();
                double Costo = listautos.get(indexAutos).getCosto() ;
                        
           
            info = info + ("El numero de Chasis del vehiculo es: " + NChasis + "\n La marca del vehiculo es: " + Marca + " \n El estilo del vehiculo es: " + Estilo + "\n"+" El color del vehiculo es: " + Color +"\n"+ " El modelo del vehiculo es: " + Año +"\n"+ " El costo del vehiculo es: " + Costo+"\n\n");
            
                        JOptionPane.showMessageDialog(null, info, "Vehiculo:", JOptionPane.NO_OPTION);
            }else {
                
                JOptionPane.showMessageDialog(null, "Chasis  no registrado");
                            
            }                  

  }
    @Override
    public void Modificar() {
       String Chasis = "";
       int indexAutos= -1;
       try {
              Chasis = JOptionPane.showInputDialog( "Ingrese el # del vehiculo: ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingreso un chasis no registrado");
        }
       
           for (int i = 0; i < listautos.size(); i++) {
                if (listautos.get(i).getNChasis().equals(Chasis) ) {
                    indexAutos = i;
                    break;
                }
            }

            if (indexAutos != -1) {
                
                String NChasis = listautos.get(indexAutos).getNChasis();
                String Marca = listautos.get(indexAutos).getMarca();
                String Estilo = listautos.get(indexAutos).getEstilo();
                int Año = listautos.get(indexAutos).getAño();
                String Color = listautos.get(indexAutos).getColor();
                double Costo = listautos.get(indexAutos).getCosto() ;

               
                NChasis =  JOptionPane.showInputDialog("El # de Chasis a modificar es: ", NChasis);
                Marca = JOptionPane.showInputDialog("La nueva marca del Vehiculo es: ",Marca);
                Estilo = JOptionPane.showInputDialog("El nuevo estilo del Vehiculo es : ",Estilo);
                Color = JOptionPane.showInputDialog("El nuevo color del vehiculo es: ",Color);
                Año = Integer.parseInt (JOptionPane.showInputDialog("El nuevo modelo del vehiculo es: ",Año));
                Costo = Double.parseDouble( JOptionPane.showInputDialog("El nuevo costo del vehiculo es: ",Costo));
                
                
                listautos.get(indexAutos).setMarca(Marca);
                listautos.get(indexAutos).setEstilo(Estilo);
                listautos.get(indexAutos).setColor(Color);
                listautos.get(indexAutos).setAño(Año);
                listautos.get(indexAutos).setCosto(Costo);
                JOptionPane.showMessageDialog(null, "Modificación realizada con exito");
                    
                
            } else {
                
                JOptionPane.showMessageDialog(null, "Chasis  no registrado");
                            
            }
        }    
    
        


    @Override
    public void Eliminar() {
       String Chasis ="";
       int indexAutos= -1;
       try {
              Chasis = JOptionPane.showInputDialog( "Ingrese el # del vehiculo: ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingreso un chasis no registrado");
        }
       
            for (int i = 0; i < listautos.size(); i++) {
                if (listautos.get(i).getNChasis().equals(Chasis)) {
                    indexAutos = i;
                    break;
                }
            }

            if (indexAutos != -1) {
                
                String NChasis = listautos.get(indexAutos).getNChasis(); 
                NChasis =  JOptionPane.showInputDialog("El # de Chasis a eliminar es: ", NChasis);
        
                listautos.remove(indexAutos).setNChasis(NChasis);
        
      }else {
                
                JOptionPane.showMessageDialog(null, "Chasis  no registrado");
                            
            }
            

    }


    public void menuPersonas(){        
        String[] opciones = {"Registrar","Consultar","Modificar","Eliminar","Volver"};
        int opcion= -1;
        while (opcion!=opciones.length-1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Personas", opciones, "Volver");
            switch (opcion) {
                case 0:   
                     Crear();
                    break;
                case 1: 
                   Buscar();
                    break;
                case 2:   
                    Modificar();
                    break;  
                case 3:         
                    Eliminar();
                    break; 
                case 4:
                    menuPrincipal();
                    break;
            }
        }
    }
    
    @Override
    public void Anular() {
      }
        @Override
    public void Informe() {
    }

}
