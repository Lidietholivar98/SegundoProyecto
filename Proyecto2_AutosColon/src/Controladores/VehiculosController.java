package Controladores;

import Interfaces.CrudInterfaces;
import static Main.Inicio.menuPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Modelo.Vehiculo;
import java.time.LocalDate;

public class VehiculosController implements CrudInterfaces {

    UtilsController metodos = new UtilsController();
    private static List<Vehiculo> vehiculos = new ArrayList();
    
    public void CargarDatos() {
        Vehiculo v1 = new Vehiculo("ABC123", "Suzuki", "Vitara", 2020, "Gris", 9800000);
        Vehiculo v2 = new Vehiculo("ABC456", "Suzuki", "Grand Vitara", 2020, "Gris", 6800000);
        Vehiculo v3 = new Vehiculo("ABC789", "Suzuki", "Ciaz", 2020, "Gris", 4800000);
        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
    }

    @Override
    public void Crear() {
        String numeroChasis= "";
        String marca= "";
        int modelo = 0;
        String estilo= "";
        String color= "";
        double precio= 0.0;
        
        Boolean chasisValido = false;
        while(!chasisValido){
            try{
                numeroChasis = JOptionPane.showInputDialog("Ingrese el número de chasis del vehículo: ");//TODO: agregar un consecutivo de vehiculo para usarlo en lugar de buscar por chasis
                if(numeroChasis.isEmpty()){
                    metodos.mensajeAlerta("Debe ingresar un número de chasis válido");
                }
                else if(existeChasis(numeroChasis)){
                    metodos.mensajeAlerta("Este número de chasis ya se encuentra registrado");
                }
                else{
                    chasisValido = true;
                }
            } catch(Exception e){
                metodos.mensajeAlerta("Debe ingresar un número de chasis válido");
            }
        }
        
        Boolean marcaValida = false;
        while (!marcaValida) {
            marca = JOptionPane.showInputDialog("Ingrese la marca del vehículo: ");
            if (marca.isEmpty()) {
                metodos.mensajeAlerta("Debe ingresar una marca válida");
            } else {
                marcaValida = true;
            }
        }
        
        Boolean estiloValido = false;
        while (!estiloValido) {
            estilo = JOptionPane.showInputDialog("Ingrese el estilo del vehículo: ");
            if (estilo.isEmpty()) {
                metodos.mensajeAlerta("Debe ingresar un estilo válido");
            } else {
                estiloValido = true;
            }
        }
        
        Boolean modeloValido = false;
        LocalDate fechaActual = LocalDate.now();
        String modeloStr= "";
        Boolean esSuperiorAnioActual= false;
        while(!modeloValido){
            modeloStr = JOptionPane.showInputDialog("Ingrese el modelo del vehículo: ");
            if(!esEntero(modeloStr)){
                metodos.mensajeAlerta("Debe ingresar un número entero");
            }
            else{
                modelo = Integer.parseInt(modeloStr);
                esSuperiorAnioActual = modelo > fechaActual.getYear();
                if (modelo < 0 || modelo == 0 || esSuperiorAnioActual) {
                    metodos.mensajeAlerta("Debe ingresar un modelo válido");
                } else {
                    modeloValido = true;
                }                
            }
        }
        
        Boolean colorValido = false;
        while (!colorValido) {
            color = JOptionPane.showInputDialog("Ingrese el color del vehículo: ");
            if (color.isEmpty()) {
                metodos.mensajeAlerta("Debe ingresar un color válido");
            } else {
                colorValido = true;
            }
        }
        
        Boolean precioValido = false;
        while(!precioValido){
            precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del vehículo: "));
            if(precio <= 0){
                metodos.mensajeAlerta("Debe ingresar un precio válido");
            }
            else {
                precioValido = true;
            }
        }

        Vehiculo vehiculo = new Vehiculo(numeroChasis, marca, estilo, modelo, color, precio);
        
        String msg = "Número de chasis: " + vehiculo.getNumeroChasis()
                   + "\nMarca: " + vehiculo.getMarca()
                   + "\nModelo: " + vehiculo.getModelo()
                   + "\nEstilo: " + vehiculo.getEstilo()
                   + "\nColor: " + vehiculo.getColor()
                   + "\nPrecio: " + vehiculo.getPrecio();
        String titulo = "Validación de datos";
        int resp = metodos.mensajeConfirmacionSIoNo(msg, titulo);
        
        if (resp == JOptionPane.YES_NO_OPTION) {
            vehiculos.add(vehiculo);
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

                 metodos.mensajeInformacion(info, "Información del vehículo");
            } else {
                metodos.mensajeAlerta(String.format("El número de chasis %s no se encuentra registrado", chasis));
            }
        } catch (Exception e) {
            metodos.mensajeAlerta("Hubo un error en la búsqueda del vehículo");
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

                 metodos.mensajeInformacion("Modificación realizada con éxito", "Modificación vehículo");

            } else {
                 metodos.mensajeAlerta(String.format("El número de chasis %s no se encuentra registrado", chasis));
            }
        } catch (Exception e) {
            metodos.mensajeAlerta("Hubo un error en la modificación del vehículo");
        }
    }

    @Override
    public void Eliminar() {
        String chasis = "";
        int indexVehiculo = -1;

        try {
            chasis = JOptionPane.showInputDialog("Ingrese el número de chasis del vehículo: ");
            indexVehiculo = buscarIndicePorChasis(chasis);

            if (indexVehiculo != -1) {
                Vehiculo vehiculo = vehiculos.get(indexVehiculo);
                if(!vehiculo.estaComprado()){
                    int opcion = metodos.mensajeConfirmacionSIoNo(vehiculo.toString(), "¿Desea eliminar el vehículo?");
                    if(opcion == JOptionPane.YES_NO_OPTION){
                        vehiculos.remove(indexVehiculo);
                        metodos.mensajeInformacion("Vehículo eliminado correctamente", "Eliminación vehículos");
                    }
                }
                else{
                    metodos.mensajeAlerta("El vehículo se encuentra alquilado actualmente, no puede ser eliminado");
                }
            } else {
                metodos.mensajeInformacion(String.format("El número de chasis %s no se encuentra registrado", chasis));
            }
        } catch (Exception e) {
            metodos.mensajeAlerta("Hubo un error en la eliminación del vehículo");
        }
    }

    public void menuVehiculos() {
        String[] opciones = {"Registrar", "Consultar", "Modificar", "Eliminar", "Volver"};
        int opcion = -1;
        while (opcion != opciones.length - 1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Vehículos", opciones, "Volver");
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
        throw new UnsupportedOperationException("Método no requerido");
    }

    @Override
    public void Informe() {
        throw new UnsupportedOperationException("Método no requerido");
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
    
    public boolean esEntero(String texto) {
        int valor;
        try {
            valor = Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
