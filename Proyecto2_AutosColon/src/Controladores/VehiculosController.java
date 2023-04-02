package Controladores;

import Interfaces.CrudInterfaces;
import static Main.Inicio.menuPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Modelo.Vehiculo;

public class VehiculosController implements CrudInterfaces {

    MetodosController metodos = new MetodosController();
    private static List<Vehiculo> listaVehiculos = new ArrayList();

    @Override
    public void Crear() {
        String numeroChasis;
        String marca;
        String estilo;
        int modelo;
        String color;
        double precio;

        numeroChasis = JOptionPane.showInputDialog("Ingrese el número de chasis del vehículo: ");

        if (numeroChasis.length() > 0) {
            marca = JOptionPane.showInputDialog("Ingrese la marca del vehículo: ");
            estilo = JOptionPane.showInputDialog("Ingrese el estilo del vehículo: ");
            modelo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el modelo del vehículo: "));
            color = JOptionPane.showInputDialog("Ingrese el color del vehículo: ");
            precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el preciodel vehículo: "));

            Vehiculo auto = new Vehiculo(numeroChasis, marca, estilo, modelo, color, precio);
            listaVehiculos.add(auto);
        } else {
            menuVehiculos();
        }
    }

    @Override
    public void Buscar() {
        String chasis = "";
        int indexVehiculo = -1;
        try {
            chasis = JOptionPane.showInputDialog("Ingrese el número de chasis del vehículo: ");

            indexVehiculo = obtenerIndiceDeVehiculoPorChasis(chasis);

            if (indexVehiculo != -1) {
                String info = "";
                String numeroChasis = listaVehiculos.get(indexVehiculo).getNumeroChasis();
                String marca = listaVehiculos.get(indexVehiculo).getMarca();
                String estilo = listaVehiculos.get(indexVehiculo).getEstilo();
                int modelo = listaVehiculos.get(indexVehiculo).getModelo();
                String color = listaVehiculos.get(indexVehiculo).getColor();
                double precio = listaVehiculos.get(indexVehiculo).getPrecio();

                info = info + ("El número de chasis del vehículo es: " + numeroChasis
                        + "\nLa marca del vehículo es: " + marca
                        + "\nEl estilo del vehículo es: " + estilo
                        + "\nEl color del vehículo es: " + color
                        + "\nEl modelo del vehículo es: " + modelo
                        + "\nEl costo del vehículo es: " + precio + "\n\n");

                JOptionPane.showMessageDialog(null, info, "Información del vehículo", JOptionPane.NO_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, String.format("El número de chasis %s no se encuentra registrado", chasis));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la búsqueda del vehículo");
        }
    }

    @Override
    public void Modificar() {
        String chasis = "";
        int indexAutos = -1;
        try {
            chasis = JOptionPane.showInputDialog("Ingrese el número de chasis del vehículo: ");

            indexAutos = obtenerIndiceDeVehiculoPorChasis(chasis);

            if (indexAutos != -1) {
                String numeroChasis = listaVehiculos.get(indexAutos).getNumeroChasis();
                String marca = listaVehiculos.get(indexAutos).getMarca();
                String estilo = listaVehiculos.get(indexAutos).getEstilo();
                int modelo = listaVehiculos.get(indexAutos).getModelo();
                String color = listaVehiculos.get(indexAutos).getColor();
                double precio = listaVehiculos.get(indexAutos).getPrecio();

                numeroChasis = JOptionPane.showInputDialog("El nuevo número de chasis es: ", numeroChasis);
                marca = JOptionPane.showInputDialog("La nueva marca del vehículo es: ", marca);
                estilo = JOptionPane.showInputDialog("El nuevo estilo del vehículo es : ", estilo);
                color = JOptionPane.showInputDialog("El nuevo color del vehículo es: ", color);
                modelo = Integer.parseInt(JOptionPane.showInputDialog("El nuevo modelo del vehículo es: ", modelo));
                precio = Double.parseDouble(JOptionPane.showInputDialog("El nuevo precio del vehículo es: ", precio));

                listaVehiculos.get(indexAutos).setNumeroChasis(numeroChasis);//TODO: verificar si esto es valido
                listaVehiculos.get(indexAutos).setMarca(marca);
                listaVehiculos.get(indexAutos).setEstilo(estilo);
                listaVehiculos.get(indexAutos).setColor(color);
                listaVehiculos.get(indexAutos).setModelo(modelo);
                listaVehiculos.get(indexAutos).setPrecio(precio);

                JOptionPane.showMessageDialog(null, "Modificación realizada con éxito");

            } else {
                JOptionPane.showMessageDialog(null, String.format("El número de chasis %s no se encuentra registrado", chasis));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la modificación del vehículo");
        }
    }

    @Override
    public void Eliminar() {
        String chasis = "";
        int indexVehiculo = -1;

        try {
            chasis = JOptionPane.showInputDialog("Ingrese el número de chasis del vehículo: ");

            indexVehiculo = obtenerIndiceDeVehiculoPorChasis(chasis);

            if (indexVehiculo != -1) {
                String numeroChasis = listaVehiculos.get(indexVehiculo).getNumeroChasis();
                numeroChasis = JOptionPane.showInputDialog("El número de chasis a eliminar es: ", numeroChasis);

                listaVehiculos.remove(indexVehiculo);//.setNumeroChasis(numeroChasis);//TODO: porque se hace un SET si quiero eliminar?
            } else {
                JOptionPane.showMessageDialog(null, String.format("El número de chasis %s no se encuentra registrado", chasis));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la eliminación del vehículo");
        }
    }

    public void menuVehiculos() {
        String[] opciones = {"Registrar", "Consultar", "Modificar", "Eliminar", "Volver"};
        int opcion = -1;
        while (opcion != opciones.length - 1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Vehiculos", opciones, "Volver");
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
    
    private int obtenerIndiceDeVehiculoPorChasis(String chasis){
        int indexVehiculo = -1;
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getNumeroChasis().equals(chasis)) {
                indexVehiculo = i;
                break;
            }
        }
        return indexVehiculo;
    }
}
