package Controladores;

import Interfaces.CrudInterfaces;
import static Main.Inicio.menuPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Modelo.Vehiculo;

public class VehiculosController implements CrudInterfaces {

    UtilsController metodos = new UtilsController();
    private static List<Vehiculo> vehiculos = new ArrayList();

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
            precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del vehículo: "));

            Vehiculo auto = new Vehiculo(numeroChasis, marca, estilo, modelo, color, precio);
            vehiculos.add(auto);
        } else {
            menuVehiculos();
        }
    }

    @Override
    public void Ver() {
        String chasis = "";
        int indexVehiculo = -1;
        try {
            chasis = JOptionPane.showInputDialog("Ingrese el número de chasis del vehículo: ");

            indexVehiculo = buscarIndicePorChasis(chasis);

            if (indexVehiculo != -1) {
                String info = "";
                String numeroChasis = vehiculos.get(indexVehiculo).getNumeroChasis();
                String marca = vehiculos.get(indexVehiculo).getMarca();
                String estilo = vehiculos.get(indexVehiculo).getEstilo();
                int modelo = vehiculos.get(indexVehiculo).getModelo();
                String color = vehiculos.get(indexVehiculo).getColor();
                double precio = vehiculos.get(indexVehiculo).getPrecio();

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

            indexAutos = buscarIndicePorChasis(chasis);

            if (indexAutos != -1) {
                String numeroChasis = vehiculos.get(indexAutos).getNumeroChasis();
                String marca = vehiculos.get(indexAutos).getMarca();
                String estilo = vehiculos.get(indexAutos).getEstilo();
                int modelo = vehiculos.get(indexAutos).getModelo();
                String color = vehiculos.get(indexAutos).getColor();
                double precio = vehiculos.get(indexAutos).getPrecio();

                numeroChasis = JOptionPane.showInputDialog("El nuevo número de chasis es: ", numeroChasis);
                marca = JOptionPane.showInputDialog("La nueva marca del vehículo es: ", marca);
                estilo = JOptionPane.showInputDialog("El nuevo estilo del vehículo es : ", estilo);
                color = JOptionPane.showInputDialog("El nuevo color del vehículo es: ", color);
                modelo = Integer.parseInt(JOptionPane.showInputDialog("El nuevo modelo del vehículo es: ", modelo));
                precio = Double.parseDouble(JOptionPane.showInputDialog("El nuevo precio del vehículo es: ", precio));

                vehiculos.get(indexAutos).setNumeroChasis(numeroChasis);//TODO: verificar si esto es valido
                vehiculos.get(indexAutos).setMarca(marca);
                vehiculos.get(indexAutos).setEstilo(estilo);
                vehiculos.get(indexAutos).setColor(color);
                vehiculos.get(indexAutos).setModelo(modelo);
                vehiculos.get(indexAutos).setPrecio(precio);

                JOptionPane.showMessageDialog(null, "Modificación realizada con éxito");

            } else {
                JOptionPane.showMessageDialog(null, String.format("El número de chasis %s no se encuentra registrado", chasis));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la modificación del vehículo");
        }
    }

    @Override
    public void Eliminar() {//TODO: validar si el vehiculo ya esta alquilado
        String chasis = "";
        int indexVehiculo = -1;

        try {
            chasis = JOptionPane.showInputDialog("Ingrese el número de chasis del vehículo: ");

            indexVehiculo = buscarIndicePorChasis(chasis);

            if (indexVehiculo != -1) {
                String numeroChasis = vehiculos.get(indexVehiculo).getNumeroChasis();
                numeroChasis = JOptionPane.showInputDialog("El número de chasis a eliminar es: ", numeroChasis);

                vehiculos.remove(indexVehiculo);//.setNumeroChasis(numeroChasis);//TODO: porque se hace un SET si quiero eliminar?
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
                    Ver();
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
    
    public int buscarIndicePorChasis(String chasis){
        int indexVehiculo = -1;
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getNumeroChasis().equals(chasis)) {
                indexVehiculo = i;
                break;
            }
        }
        return indexVehiculo;
    }
    
    public Vehiculo buscarPorChasis(String chasis){
        Vehiculo vehiculo = new Vehiculo();
        for (Vehiculo v : vehiculos) {
            if (v.getNumeroChasis().equals(chasis)) {
                vehiculo = v;
                break;
            }
        }

        return vehiculo;
    }
    
    public Boolean existeChasis(String chasis) {
        boolean existe = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getNumeroChasis().equals(chasis)) {
                existe = true;
                break;
            }
        }

        return existe;
    }
}
