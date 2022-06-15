package bol7_ej7.clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EventManage extends JFrame implements ActionListener {
    private JTextField txtNumUno;
    private JTextField txtNumDos;
    private JTextField txtNumTres;
    private JButton btnJugar;
    private JLabel lblInformativo;
    private JLabel lblTiempo;

    private int contSegundosU;
    private int contMinutosU;
    Timer temporizador;

    public EventManage() {
        super("Boletin7_Ejercicio7");
        this.setLayout(null);

        // LBL Informativo
        lblInformativo = new JLabel("PROHIBIDO -18");
        lblInformativo.setSize(140, 15);
        lblInformativo.setFont(new Font("Arial", Font.BOLD, 18));
        lblInformativo.setLocation(165, 40);
        this.add(lblInformativo);

        // TXT Num1
        txtNumUno = new JTextField(5);
        txtNumUno.setSize(110, 110);
        txtNumUno.setFont(new Font("Arial", Font.PLAIN, 50));
        txtNumUno.setHorizontalAlignment(JTextField.CENTER);
        txtNumUno.setLocation(30, 90);
        txtNumUno.setEditable(false);
        this.add(txtNumUno);

        // TXT Num2
        txtNumDos = new JTextField(5);
        txtNumDos.setSize(110, 110);
        txtNumDos.setFont(new Font("Arial", Font.PLAIN, 50));
        txtNumDos.setHorizontalAlignment(JTextField.CENTER);
        txtNumDos.setLocation(170, 90);
        txtNumDos.setEditable(false);
        this.add(txtNumDos);

        // TXT Num3
        txtNumTres = new JTextField(5);
        txtNumTres.setSize(110, 110);
        txtNumTres.setFont(new Font("Arial", Font.PLAIN, 50));
        txtNumTres.setHorizontalAlignment(JTextField.CENTER);
        txtNumTres.setLocation(310, 90);
        txtNumTres.setEditable(false);
        this.add(txtNumTres);

        // LBL Tiempo
        lblTiempo = new JLabel("Tiempo transcurrido: ");
        lblTiempo.setSize(400, 50);
        lblTiempo.setFont(new Font("Arial", Font.BOLD, 14));
        lblTiempo.setLocation(30, 400);
        this.add(lblTiempo);

        contSegundosU = 55;
        temporizador = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contSegundosU++;
                if (contSegundosU >= 60) {
                    contMinutosU ++;
                    contSegundosU = 0;
                }
                lblTiempo.setText(String.format("Tiempo transcurrido: %02d:%02d", contMinutosU, contSegundosU));
            }
        });
        temporizador.start();

        // Botón Jugar
        btnJugar = new JButton("JUEGO");
        btnJugar.setSize(350, 50);
        btnJugar.setFont(new Font("Arial", Font.BOLD, 25));
        btnJugar.setLocation(50, 250);
        btnJugar.setFocusPainted(true);
        this.add(btnJugar);
        btnJugar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numTxtUno = 0;
        int numTxtDos = 0;
        int numTxtTres = 0;
        String valTxtUno;
        String valTxtDos;
        String valTxtTres;

        if (e.getSource() == btnJugar) {
            numTxtUno = (int) (Math.random() * 6 + 1);
            valTxtUno = String.valueOf(numTxtUno);
            this.txtNumUno.setText(valTxtUno);

            numTxtDos = (int) (Math.random() * 6 + 1);
            valTxtDos = String.valueOf(numTxtDos);
            this.txtNumDos.setText(valTxtDos);

            numTxtTres = (int) (Math.random() * 6 + 1);
            valTxtTres = String.valueOf(numTxtTres);        
            this.txtNumTres.setText(valTxtTres);

            if ((numTxtUno == numTxtDos) && (numTxtUno == numTxtTres)) {
                lblInformativo.setText("PREMIO");
                lblInformativo.setForeground(Color.RED);
            } else {
                lblInformativo.setText("HA PERDIDO");
                lblInformativo.setForeground(Color.BLACK);
            }
        }
    }
}
