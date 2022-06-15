package bol7_ej4.clases;

import javax.swing.JFrame;

public class JFramePrincipal {
    public static void main(String[] args) {
        EventManage ventana = new EventManage();

        ventana.setLocationRelativeTo(null);
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(650, 300); 
        ventana.setVisible(true);
    }
}
