package bol7_ej5.clases;

import javax.swing.JFrame;

public class JFramePrincipal {
    public static void main(String[] args) {
        EventManage ventana = new EventManage();

        ventana.setLocationRelativeTo(null);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 300);
        ventana.setVisible(true);
    }
}
