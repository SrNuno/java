package bol7_ej1.clases;

import javax.swing.*;

public class JFramePrincipal {
    public static void main(String[] args) {
        String numeroUno;
        int valorUno = 0;
        String numeroDos;
        int valorDos = 0;
        int resultado = 0;

        do {
            numeroUno = JOptionPane.showInputDialog("Ingrese primer valor: ");
            numeroDos = JOptionPane.showInputDialog("Ingrese segundo valor:");

            try {
                valorUno = Integer.parseInt(numeroUno);
                valorDos = Integer.parseInt(numeroDos);
                resultado = valorUno + valorDos;
                JOptionPane.showMessageDialog(null,
                        "La suma de " + valorUno + " + " + valorDos + " = " + resultado, "Suma",
                        JOptionPane.PLAIN_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Tiene que introducir valores numéricos", "Mensaje ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }

        } while (JOptionPane.showConfirmDialog(null, "¿Desea realizar otra suma?", "Salir",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}
