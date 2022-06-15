package bol7_ej3.clases;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventManage extends JFrame implements ActionListener {
    private JButton btnAmarillo;
    private JButton btnAzul;
    private JButton btnRandom;

    public EventManage() {
        super("Ejercicio botones");
        this.setLayout(null);

        // Botón Amarillo
        btnAmarillo = new JButton("Amarillo");
        btnAmarillo.setLocation(50, 50);
        btnAmarillo.setSize(100, 100);
        this.add(btnAmarillo);
        btnAmarillo.addActionListener(this);

        // Botón Azul
        btnAzul = new JButton("Azul");
        btnAzul.setForeground(Color.blue);
        btnAzul.setLocation(175, 50);
        btnAzul.setSize(100, 100);
        this.add(btnAzul);
        btnAzul.addActionListener(this);

        // Botón Aleatorio
        btnRandom = new JButton("Aleatorio");
        btnRandom.setLocation(300, 50);
        btnRandom.setSize(100, 100);
        this.add(btnRandom);
        btnRandom.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == btnAmarillo) {
            this.getContentPane().setBackground(Color.yellow);
        }

        if (evento.getSource() == btnAzul) {
            this.getContentPane().setBackground(Color.blue);
        }

        if ((evento.getSource() == btnRandom)
                && (evento.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {
            btnRandom.setLocation((int) (Math.random() * 249 + 50), (int) (Math.random() * 249 + 25));
        } else if (evento.getSource() == btnRandom) {
            super.setLocation((int) (Math.random() * 601 + 0), (int) (Math.random() * 401 + 0));
        }
    }

}
