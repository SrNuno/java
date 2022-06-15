package bol7_ej6.clases;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EventManage extends JFrame implements ActionListener {
    private JTextField txtNumeroUno;
    private JTextField txtNumeroDos;
    private JLabel lblSigno;
    private JButton btnSuma;
    private JButton btnDivision;
    private JButton btnRaizCuadrada;

    public EventManage() {
        super("Boletin7_Ejercicio6");
        this.setLayout(new FlowLayout());

        // TXT Num1
        txtNumeroUno = new JTextField(3);
        this.add(txtNumeroUno);
        txtNumeroUno.addActionListener(this);

        // TXT Num2
        txtNumeroDos = new JTextField(3);
        this.add(txtNumeroDos);
        txtNumeroDos.addActionListener(this);

        // Label Signo
        lblSigno = new JLabel();
        this.add(lblSigno);

        // Botón Suma
        btnSuma = new JButton("Suma");
        this.add(btnSuma);
        btnSuma.addActionListener(this);

        // Botón División
        btnDivision = new JButton("División");
        this.add(btnDivision);
        btnDivision.addActionListener(this);

        // Botón Raíz Cuadrada
        btnRaizCuadrada = new JButton("Raíz Cuadrada");
        this.add(btnRaizCuadrada);
        btnRaizCuadrada.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double numUno = 0;
        double numDos = 0;
        double resultado = 0;

        if (e.getSource() == btnSuma) {
            try {
                numUno = Double.parseDouble(txtNumeroUno.getText());
                numDos = Double.parseDouble(txtNumeroDos.getText());
                resultado = numUno + numDos;
                lblSigno.setText(String.valueOf(String.format("= %.3f", resultado)));
                lblSigno.setForeground(Color.BLACK);
            } catch (IllegalArgumentException ev) {
                lblSigno.setText("= Valores erróneos");
                lblSigno.setForeground(Color.RED);
            }
        } else if (e.getSource() == btnDivision) {
            try {
                numUno = Double.parseDouble(txtNumeroUno.getText());
                if (Double.parseDouble(txtNumeroDos.getText()) == 0) {
                    lblSigno.setText("= División entre 0");
                    lblSigno.setForeground(Color.RED);
                } else {
                    numDos = Double.parseDouble(txtNumeroDos.getText());
                    resultado = numUno / numDos;
                    lblSigno.setText(String.valueOf(String.format("= %.3f", resultado)));
                    lblSigno.setForeground(Color.BLACK);
                }
            } catch (IllegalArgumentException ev) {
                lblSigno.setText("= Valores erróneos");
                lblSigno.setForeground(Color.RED);
            }

        } else if (e.getSource() == btnRaizCuadrada) {
            try {
                numUno = Double.parseDouble(txtNumeroUno.getText());
                if (numUno >= 0) {
                    resultado = Math.sqrt(numUno);
                    lblSigno.setText(String.valueOf(String.format("= %.3f", resultado)));
                    lblSigno.setForeground(Color.BLACK);
                } else {
                    lblSigno.setText("= Núm. negativo");
                    lblSigno.setForeground(Color.RED);
                }
            } catch (IllegalArgumentException event) {
                lblSigno.setText("= Valor fallido");
                lblSigno.setForeground(Color.RED);
            }
        }

    }
}
