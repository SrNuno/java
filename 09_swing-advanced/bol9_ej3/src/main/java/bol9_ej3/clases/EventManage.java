package bol9_ej3.clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EventManage extends JFrame implements ActionListener, ItemListener {
    public void calcular() {
        for (Component component : this.getContentPane().getComponents()) {
            if (component.getClass() == JRadioButton.class) {
                if (((JRadioButton) component).isSelected()) {
                    lblInformante.setText("");
                    switch (((JRadioButton) component).getActionCommand()) {
                        case "+":
                            calculo = Double.parseDouble(txtCajaUno.getText())
                                    + Double.parseDouble(txtCajaDos.getText());
                            break;

                        case "-":
                            calculo = Double.parseDouble(txtCajaUno.getText())
                                    - Double.parseDouble(txtCajaDos.getText());
                            break;

                        case "*":
                            calculo = Double.parseDouble(txtCajaUno.getText())
                                    * Double.parseDouble(txtCajaDos.getText());
                            break;

                        case "/":
                            calculo = Double.parseDouble(txtCajaUno.getText())
                                    / Double.parseDouble(txtCajaDos.getText());
                            break;
                    }
                }
            }
        }
    }

    public boolean comprobante() {
        Boolean flag;
        try {
            Double.parseDouble(txtCajaUno.getText());
            Double.parseDouble(txtCajaDos.getText());
            flag = true;
            return flag;
        } catch (NumberFormatException e) {
            System.err.println("Error");
            flag = false;
            return flag;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOperacion) {
            try {
                if (txtCajaUno.getText().equals("") && txtCajaDos.getText().equals("")) {
                    lblInformante.setText("Cajas vacías");
                    lblSignoIgualdad.setText("=");
                } else if (txtCajaUno.getText().equals("")) {
                    lblInformante.setText("Primera caja vacía");
                    lblSignoIgualdad.setText("=");
                } else if (txtCajaDos.getText().equals("")) {
                    lblInformante.setText("Segunda caja vacía");
                    lblSignoIgualdad.setText("=");
                } else {
                    calcular();
                    lblSignoIgualdad
                            .setText("= " + String.format("%." + cbDecimales.getSelectedIndex() + "f", calculo));
                }

            } catch (NumberFormatException ex) {
                lblInformante.setText("Error, no se puede operar");
                lblSignoIgualdad.setText("=");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        for (Component component : this.getContentPane().getComponents()) {
            if (component.getClass() == JRadioButton.class) {
                if (((JRadioButton) component).isSelected()) {
                    switch (((JRadioButton) component).getActionCommand()) {
                        case "+":
                            lblSignoOperacion.setText("+");
                            break;

                        case "-":
                            lblSignoOperacion.setText("-");
                            break;

                        case "*":
                            lblSignoOperacion.setText("*");
                            break;

                        case "/":
                            lblSignoOperacion.setText("/");
                            break;
                    }
                }
            }
        }
    }

    public EventManage() {
        super("Calculator 2.0");
        setLayout(null);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(null, "Deseas cerrar el programa?", "Cerrar programa",
                        JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    if (txtCajaUno.getText().equals("") || txtCajaDos.getText().equals("") || comprobante() == false) {
                        JOptionPane.showMessageDialog(null, "Valores incorrectos",
                                "Error al guardar", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try (PrintWriter f = new PrintWriter(new FileWriter(".guardaOperaciones.ini"))) {
                            for (Component component : EventManage.this.getContentPane().getComponents()) {
                                if (component.getClass() == JRadioButton.class) {
                                    if (((JRadioButton) component).isSelected()) {
                                        switch (((JRadioButton) component).getActionCommand()) {
                                            case "+":
                                                f.printf("%s\n%s\n%s\n", txtCajaUno.getText(),
                                                        lblSignoOperacion.getText(),
                                                        txtCajaDos.getText());
                                                break;

                                            case "-":
                                                f.printf("%s\n%s\n%s\n", txtCajaUno.getText(),
                                                        lblSignoOperacion.getText(),
                                                        txtCajaDos.getText());
                                                break;

                                            case "*":
                                                f.printf("%s\n%s\n%s\n", txtCajaUno.getText(),
                                                        lblSignoOperacion.getText(),
                                                        txtCajaDos.getText());
                                                break;

                                            case "/":
                                                f.printf("%s\n%s\n%s\n", txtCajaUno.getText(),
                                                        lblSignoOperacion.getText(),
                                                        txtCajaDos.getText());
                                                break;
                                        }
                                    }
                                }
                            }
                        } catch (IOException ex) {
                            System.err.println("Error de acceso al archivo");
                        }
                        System.exit(0);
                    }
                }
            }

            @Override
            public void windowOpened(WindowEvent e) {
                try (Scanner sc = new Scanner(new File(".guardaOperaciones.ini"))) {
                    linea0 = sc.nextLine();
                    txtCajaUno.setText(linea0);
                    linea1 = sc.nextLine();
                    lblSignoOperacion.setText(linea1);
                    linea2 = sc.nextLine();
                    txtCajaDos.setText(linea2);

                    for (int i = 0; i < signos.length; i++) {
                        if (signos[i].equals(linea1)) {
                            for (Component component : EventManage.this.getContentPane().getComponents()) {
                                if (component.getClass() == JRadioButton.class) {
                                    if (((JRadioButton) component).getActionCommand().equals(signos[i])) {
                                        ((JRadioButton) component).setSelected(true);
                                    }
                                }
                            }
                        }
                    }
                } catch (IOException ev) {
                    System.err.println("Error de acceso al archivo");
                } catch (NoSuchElementException ev) {
                    System.err.println("No hay contenido para leer");
                }
            }
        });

        txtCajaUno = new JTextField();
        txtCajaUno.setSize(100, 25);
        txtCajaUno.setLocation(20, 30);
        txtCajaUno.setFont(new Font("Arial", Font.BOLD, 25));

        add(txtCajaUno);

        lblSignoOperacion = new JLabel("+");
        lblSignoOperacion.setSize(20, 20);
        lblSignoOperacion.setLocation(60, 70);
        lblSignoOperacion.setFont(new Font("Arial", Font.BOLD, 25));
        add(lblSignoOperacion);

        txtCajaDos = new JTextField();
        txtCajaDos.setSize(100, 25);
        txtCajaDos.setLocation(20, 105);
        txtCajaDos.setFont(new Font("Arial", Font.BOLD, 25));
        add(txtCajaDos);

        lblSignoIgualdad = new JLabel("=");
        lblSignoIgualdad.setSize(110, 20);
        lblSignoIgualdad.setLocation(30, 150);
        lblSignoIgualdad.setFont(new Font("Arial", Font.BOLD, 15));
        add(lblSignoIgualdad);

        int x = 140, y = 25;
        for (int i = 0; i < operaciones.length; i++) {
            rdbuton = new JRadioButton(operaciones[i], true);
            rdbuton.setSize(120, 30);
            rdbuton.setLocation(x, y);
            rdbuton.setFont(new Font("Arial", Font.BOLD, 13));
            rdbuton.setActionCommand(signos[i]);
            this.add(rdbuton);
            rdbuton.addItemListener(this);
            grupOperaciones.add(rdbuton);

            if ((i + 1) % 1 == 0) { // Cada radioButton cambia de “línea”
                x = 140;
                y += 25;
            } else {
                x += 100;
            }
        }

        btnOperacion = new JButton("OPERACIÓN");
        btnOperacion.setSize(420, 30);
        btnOperacion.setLocation(20, 200);
        btnOperacion.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        add(btnOperacion);
        btnOperacion.addActionListener(this);

        lblDecimales = new JLabel("Seleccione decimales:");
        lblDecimales.setSize(150, 25);
        lblDecimales.setLocation(290, 25);
        lblDecimales.setFont(new Font("Arial", Font.CENTER_BASELINE, 13));
        add(lblDecimales);

        lblInformante = new JLabel();
        lblInformante.setSize(150, 30);
        lblInformante.setLocation(20, 235);
        lblInformante.setForeground(Color.RED);
        add(lblInformante);

        cbDecimales = new JComboBox<String>(decimales);
        cbDecimales.setMaximumRowCount(4);
        cbDecimales.setSelectedIndex(1);
        cbDecimales.setSize(150, 25);
        cbDecimales.setLocation(290, 50);
        add(cbDecimales);
        cbDecimales.addItemListener(this);
    }

    JTextField txtCajaUno;
    JTextField txtCajaDos;
    JLabel lblSignoOperacion;
    JLabel lblSignoIgualdad;
    JLabel lblInformante;

    JButton btnOperacion;
    JRadioButton rdbuton;
    ButtonGroup grupOperaciones = new ButtonGroup();
    private String[] operaciones = { "Suma", "Resta", "Multiplicación", "División" };
    private String[] signos = { "+", "-", "*", "/" };

    JLabel lblDecimales;
    JComboBox<String> cbDecimales;
    String[] decimales = { "0", "1", "2", "3", "4", "5" };

    double calculo = 0;
    String linea0, linea1, linea2;
}