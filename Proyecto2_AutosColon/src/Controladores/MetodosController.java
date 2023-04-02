/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import javax.swing.JOptionPane;

/**
 *
 * @author aaraya
 */
public class MetodosController {
        public void msg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public int SIoNo(String msg, String titulo) {
        int respuesta;
        return JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_OPTION);
    }

    public int menuBotones(String msg, String titulo, String opciones[], String valorDefecto) {
        int opcion = JOptionPane.showOptionDialog(null, msg, titulo, 0,
                 JOptionPane.QUESTION_MESSAGE, null, opciones, valorDefecto);
        return opcion;
    }

}
