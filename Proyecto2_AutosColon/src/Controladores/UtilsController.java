/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author aaraya
 */
public class UtilsController {

    public void mensajeInformacion(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mensajeInformacion(String msg, String titulo) {
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mensajeAlerta(String msg){
        JOptionPane.showMessageDialog(null, msg, "Alerta!", JOptionPane.WARNING_MESSAGE);
    }

    public int mensajeConfirmacionSIoNo(String msg, String titulo) {
        int respuesta;
        return JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_OPTION);
    }

    public int menuBotones(String msg, String titulo, String opciones[], String valorDefecto) {
        int opcion = JOptionPane.showOptionDialog(null, msg, titulo, 0,
                JOptionPane.QUESTION_MESSAGE, null, opciones, valorDefecto);
        return opcion;
    }

    /*
        Metodo investigado en Internet para poder realizar una validacion del correo electronico
     */
    public Boolean esCorreoValido(String correoAValidar) {
        String expresionRegular = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern patron = Pattern.compile(expresionRegular);
        Matcher coincidencia = patron.matcher(correoAValidar);
        return coincidencia.matches();
    }
}
