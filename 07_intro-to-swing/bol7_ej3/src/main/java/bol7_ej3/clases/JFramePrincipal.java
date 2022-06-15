package bol7_ej3.clases;

import javax.swing.JFrame;

public class JFramePrincipal {
    public static void main(String[] args) {
        EventManage ventana = new EventManage();

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(650, 400);
        ventana.setVisible(true);
    }
}
