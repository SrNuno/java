package bol7_ej8.clases;

import javax.swing.JFrame;

public class JFramePrincipal {
    public static void main(String[] args) {
        EventManage ventana = new EventManage();

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 550);
        ventana.setVisible(true);

    }
}
