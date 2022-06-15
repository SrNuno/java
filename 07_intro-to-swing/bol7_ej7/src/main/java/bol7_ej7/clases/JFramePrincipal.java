package bol7_ej7.clases;

import javax.swing.JFrame;

public class JFramePrincipal {
    public static void main(String[] args) {
        EventManage ventana = new EventManage();

        ventana.setLocationRelativeTo(null);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(460, 500);
        ventana.setVisible(true);
    }
}
