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
import java.time.LocalDate;
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
        String numeroChasis = "";
        String idComprador = "";
        double precioVenta;
        LocalDate fechaVenta = LocalDate.now();

        Boolean chasisValido = false;
        while (!chasisValido) {
            numeroChasis = JOptionPane.showInputDialog("Ingrese el número de chasis del vehículo: ");
            if (numeroChasis.isEmpty()) {
                metodos.mensajeAlerta("Debe ingresar un número de chasis válido");
            } else if (!hayDisponibilidadVehiculo(numeroChasis)) {
                metodos.mensajeAlerta("Este número de chasis ya fue vendido");
            } else if (!existeVehiculoEnCatalogo(numeroChasis)) {
                metodos.mensajeAlerta("Este número de chasis no existe en el inventario");
            } else {
                chasisValido = true;
            }
        }

        Boolean identificadorValido = false;
        while (!identificadorValido) {
            idComprador = JOptionPane.showInputDialog("Ingrese la identificación del comprador: ");
            if (!existePersonaEnCatalogo(idComprador)) {
                metodos.mensajeAlerta("Esta persona aún no ha sido registrada en el catálogo de personas");
            } else if (idComprador.isEmpty()) {
                metodos.mensajeAlerta("Debe ingresar una identificación válida");
            } else {
                identificadorValido = true;
            }
        }

        Persona persona = personas.buscarPorId(idComprador);
        Vehiculo vehiculo = vehiculos.buscarPorChasis(numeroChasis);
        precioVenta = vehiculo.getPrecio();
        Venta venta = new Venta(numeroChasis, idComprador, precioVenta, fechaVenta);
        String msg = "Identificación: " + venta.getIdComprador()
                + "\nNúmero de chasis a vender: " + venta.getNumeroChasis();
        String titulo = "Validación de datos";
        int resp = metodos.mensajeConfirmacionSIoNo(msg, titulo);

        if (resp == JOptionPane.YES_NO_OPTION) {
            ventas.add(venta);
        }

        vehiculo.marcarComoComprado();
        persona.marcarComoComprado();

    }

    @Override
    public void Anular() {
        String idVentaStr = "";
        int idVenta = -1;

        Boolean idVentaValido = false;

        while (!idVentaValido) {
            idVentaStr = JOptionPane.showInputDialog("Ingrese el número de venta que quiere anular:");
            if (!esEntero(idVentaStr)) {
                metodos.mensajeAlerta("Debe ingresar un número entero");
            } else {
                idVenta = Integer.parseInt(idVentaStr);
                if (idVenta <= 0) {
                    metodos.mensajeAlerta("Debe ingresar una venta válida");
                } else {
                    idVentaValido = true;
                }
            }
        }

        try {
            for (Venta venta : ventas) {
                if (venta.getNumeroVenta() == idVenta) {
                    int opcion = metodos.mensajeConfirmacionSIoNo(venta.toString(), "¿Desea anular la venta?");
                    if (opcion == JOptionPane.YES_NO_OPTION) {
                        venta.marcarComoAnulada();
                        Persona persona = personas.buscarPorId(venta.getIdComprador());
                        Vehiculo vehiculo = vehiculos.buscarPorChasis(venta.getNumeroChasis());
                        persona.marcarComoSinComprar();//Si la venta se anula, la persona debe quedar como sin alquilar
                        vehiculo.marcarComoSinComprar();//si la venta se anula, el vehiculo debe quedar como devuelto
                        metodos.mensajeInformacion("Venta anulada correctamente");
                        break;
                    }                    
                }
            }

        } catch (Exception e) {
            metodos.mensajeInformacion(String.format("El número de venta %s no se encuentra registrado", idVenta));
        }
    }

    @Override
    public void Ver() {//Este metodo retonarna la venta a ver, pero si esta anulada, muestra un mensaje de que esta anulada, incluyendo la info de venta
        String idVentaStr = "";
        int idVenta = -1;

        Boolean idVentaValido = false;
        while (!idVentaValido) {
            idVentaStr = JOptionPane.showInputDialog("Ingrese el número de venta:");
            if (!esEntero(idVentaStr)) {
                metodos.mensajeAlerta("Debe ingresar un número entero");
            } else {
                idVenta = Integer.parseInt(idVentaStr);
                if (idVenta <= 0) {
                    metodos.mensajeAlerta("Debe ingresar una venta válida");
                } else {
                    idVentaValido = true;
                }
            }
        }

        try {
            for (Venta venta : ventas) {
                if (venta.getNumeroVenta() == idVenta) {
                    if (venta.esAnulada()) {
                        metodos.mensajeInformacion("Esta venta está anulada\n" + venta.toString());
                    } else {
                        metodos.mensajeInformacion(venta.toString());
                    }
                }
            }
        } catch (Exception e) {
            metodos.mensajeInformacion(String.format("El número de venta %s no se encuentra registrado", idVenta));
        }
    }

    @Override
    public void Modificar() {
        int indexVenta = -1;
        int idVenta;

        try {
            idVenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la venta:"));
            indexVenta = buscarIndicePorId(idVenta);

            if (indexVenta != -1) {
                String numeroChasis = ventas.get(indexVenta).getNumeroChasis();
                String idComprador = ventas.get(indexVenta).getIdComprador();
                double precioVenta = ventas.get(indexVenta).getPrecioVenta();//TODO: validar que al cambiar precio venta, precio total se modifique

                numeroChasis = JOptionPane.showInputDialog("El nuevo número de chasis del vehículo: ", numeroChasis);
                idComprador = JOptionPane.showInputDialog("La nueva identificación del comprador es: ", idComprador);
                precioVenta = Double.parseDouble(JOptionPane.showInputDialog("El nuevo precio de venta es: ", precioVenta));

                ventas.get(indexVenta).setNumeroChasis(numeroChasis);
                ventas.get(indexVenta).setIdComprador(idComprador);
                ventas.get(indexVenta).setPrecioVenta(precioVenta);

                metodos.mensajeInformacion("Modificación realizada con éxito");

            } else {
                metodos.mensajeInformacion(String.format("El número de venta %s no se encuentra registrado", idVenta));
            }
        } catch (Exception e) {
            metodos.mensajeInformacion("Hubo un error en la modificación de la venta");
        }
    }

    @Override
    public void Informe() {//Este metodo solo retorna ventas que NO esten anuladas
        String info = "";
        for (Venta venta : ventas) {
            if(!venta.esAnulada()){
                info = info + venta.toString();   
            }
        }
        metodos.mensajeInformacion(info);
    }

    public void menuVentas() {
        String[] opciones = {"Registrar", "Anular", "Consultar", "Informe", "Volver"};
        int opcion = -1;
        while (opcion != opciones.length - 1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Ventas", opciones, "Volver");
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
    public void Eliminar() {
        throw new UnsupportedOperationException("Método no requerido");
    }

    public Boolean hayDisponibilidadVehiculo(String numeroChasis) {
        boolean disponible = true;
        for (Venta venta : ventas) {
            if (venta.getNumeroChasis().equals(numeroChasis)) {
                disponible = false;
                break;
            }
        }

        return disponible;
    }

    public Boolean existeVehiculoEnCatalogo(String numeroChasis) {
        boolean existe = false;
        if (vehiculos.existeChasis(numeroChasis)) {
            existe = true;
        }

        return existe;
    }

    public Boolean existePersonaEnCatalogo(String identificacion) {
        boolean existe = false;
        if (personas.existeIdentificador(identificacion)) {
            existe = true;
        }

        return existe;
    }

    public int buscarIndicePorId(int idVenta) {
        int indexVenta = -1;
        for (int i = 0; i < ventas.size(); i++) {
            if (ventas.get(i).getNumeroVenta() == idVenta) {
                indexVenta = i;
                break;
            }
        }
        return indexVenta;
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
