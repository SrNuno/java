package bol7_ej9.clases;

import java.awt.Color;

import javax.swing.JFrame;

public class JFramePrincipal {
    public static void main(String[] args) {
        EventManagePrincipal ventana = new EventManagePrincipal();

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setBackground(new Color(250, 219, 216));
        ventana.setSize(1925, 1035);
        ventana.setVisible(true);
        
    }
}
