package Controladores;

//Implementar los métodos abstractos de la interface.
import Interfaces.CrudInterfaces;
import static Main.Inicio.menuPrincipal;
import Modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//Usamos implements
//Implementar los métodos abstractos
public class PersonasController implements CrudInterfaces {

    //Implementa la clase MetodosController (Copia)
    UtilsController metodos = new UtilsController();
    private static List<Persona> personas = new ArrayList();

    @Override
    public void Crear() {
        String numeroId = "";
        String nombre = "";
        String numeroTelefono;
        String email;
        
        Boolean identificadorValido = false;
        while(!identificadorValido){
            try{
                numeroId = JOptionPane.showInputDialog("Ingrese el número de identificación: ");
                if(existeIdentificador(numeroId)){
                    metodos.msg("Este identificador ya se encuentra registrado");
                }
                else{
                    identificadorValido = true;
                }
            } catch(Exception e){
                metodos.msg("Debe ingresar una identificación válida");
            }
        }

        Boolean nombreValido = false;
        while (!nombreValido) {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
            if (nombre.isEmpty()) {
                metodos.msg("Debe ingresar un nombre válido");
            } else {
                nombreValido = true;
            }
        }
        
        numeroTelefono = JOptionPane.showInputDialog("Ingrese el número de teléfono: ");
        email = JOptionPane.showInputDialog("Ingrese el correo electrónico: ");//TODO: validar formato de correo

        Persona persona = new Persona(numeroId, nombre, numeroTelefono, email);
        
        int resp;
        String msg = "Identificador: " + persona.getNumeroId() 
                   + "\nNombre: " + persona.getNombre()
                   + "\nNúmero teléfono: " + persona.getNumeroTelefono()
                   + "\nCorreo electrónico: " + persona.getEmail();
        String titulo = "Validación de datos";
        resp = metodos.SIoNo(msg, titulo);
        
        if (resp == 0) {
            personas.add(persona);
        }
    }
    
     @Override
    public void Ver() {
        int indexPersona = -1;
        String identificacion;
        try {
            identificacion = JOptionPane.showInputDialog("Ingrese el número de identificación: ");
            indexPersona = buscarIndicePorId(identificacion);

            if (indexPersona != -1) {
                String info = "";
                String numeroId = personas.get(indexPersona).getNumeroId();
                String nombre = personas.get(indexPersona).getNombre();
                String numeroTelefono = personas.get(indexPersona).getNumeroTelefono();
                String email = personas.get(indexPersona).getEmail();

                info = info + ("El número de identificación de la persona es: " + numeroId
                        + "\nEl nombre es: " + nombre
                        + "\nEl número de teléfono es: " + numeroTelefono
                        + "\nEl correo electrónico es: " + email + "\n\n");

                JOptionPane.showMessageDialog(null, info, "Información de la persona", JOptionPane.NO_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, String.format("El número de identificación %s no se encuentra registrado", identificacion));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la búsqueda de la persona");
        }
    }

    @Override
    public void Modificar() {
        String identificacion = "";
        int indexPersona = -1;
        try {
            identificacion = JOptionPane.showInputDialog("Ingrese el número de identificación: ");
            indexPersona = buscarIndicePorId(identificacion);

            if (indexPersona != -1) {
                String numeroIdentificacion = personas.get(indexPersona).getNumeroId();
                String nombre = personas.get(indexPersona).getNombre();
                String numeroTelefono = personas.get(indexPersona).getNumeroTelefono();
                String email = personas.get(indexPersona).getEmail();

                numeroIdentificacion = JOptionPane.showInputDialog("El nuevo número de identificación es: ", numeroIdentificacion);
                nombre = JOptionPane.showInputDialog("El nuevo nombre es: ", nombre);
                numeroTelefono = JOptionPane.showInputDialog("El nuevo número de teléfono es : ", numeroTelefono);
                email = JOptionPane.showInputDialog("El nuevo correo electrónico es: ", email);

                personas.get(indexPersona).setNumeroId(numeroIdentificacion);//TODO: verificar si esto es valido
                personas.get(indexPersona).setNombre(nombre);
                personas.get(indexPersona).setNumeroTelefono(numeroTelefono);
                personas.get(indexPersona).setEmail(email);
                
                JOptionPane.showMessageDialog(null, "Modificación realizada con éxito");

            } else {
                JOptionPane.showMessageDialog(null, String.format("El número de identificación %s no se encuentra registrado", identificacion));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la modificación de la persona");
        }
    }
    
    @Override
    public void Eliminar() {//TODO: validar si la persona tiene alquileres
        String identificacion = "";
        int indexPersona = -1;

        try {
            identificacion = JOptionPane.showInputDialog("Ingrese el número de identificación: ");
            indexPersona = buscarIndicePorId(identificacion);

            if (indexPersona != -1) {
                String numeroIdentificador = personas.get(indexPersona).getNumeroId();
                numeroIdentificador = JOptionPane.showInputDialog("El número de identificación a eliminar es: ", numeroIdentificador);

                personas.remove(indexPersona);
            } else {
                JOptionPane.showMessageDialog(null, String.format("El número de identificación %s no se encuentra registrado", identificacion));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la eliminación de la persona");
        }
    }
    
    public void menuPersonas() {
        String[] opciones = {"Registrar", "Consultar", "Modificar", "Eliminar", "Volver"};
        int opcion = -1;
        while (opcion != opciones.length - 1) {
            opcion = metodos.menuBotones("Seleccione una opción", "Personas", opciones, "Volver");
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

    public boolean poseeAlquiler(String idPersona) {
        //Aquí va el código que busca en la lista de alquileres una persona
        boolean existe = buscarIndicePorId(idPersona) != -1;//metodos.SIoNo("Esta alquilando?", "Atención");
        if (existe) {
            return true;
        } else {
            return false;
        }
    }
    
    public int buscarIndicePorId(String identificador){
        int indexPersona = -1;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getNumeroId().equals(identificador)) {
                indexPersona = i;
                break;
            }
        }
        return indexPersona;
    }
    
    public Persona buscarPorId(String identificador){
        Persona persona = new Persona();
        for (Persona p : personas) {
            if (p.getNumeroId().equals(identificador)) {
                persona = p;
                break;
            }
        }

        return persona;
    }
    
    public Persona buscarPorNombre(String nombre) {
        Persona persona = new Persona();
        for (Persona p : personas) {
            if (p.getNombre().equals(nombre)) {
                persona = p;
                break;
            }
        }

        return persona;
    }
    
    public Boolean existeIdentificador(String identificador) {
        boolean existe = false;
        for (Persona persona : personas) {
            if (persona.getNumeroId().equals(identificador)) {
                existe = true;
                break;
            }
        }

        return existe;
    }
}
