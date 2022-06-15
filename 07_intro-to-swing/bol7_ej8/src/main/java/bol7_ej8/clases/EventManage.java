package bol7_ej8.clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EventManage extends JFrame implements ActionListener {
    private JTextField txtRojo;
    private JLabel lblRojo;
    private JTextField txtVerde;
    private JLabel lblVerde;
    private JTextField txtAzul;
    private JLabel lblAzul;
    private JButton btnColor;
    private JTextField txtPath;
    private JLabel lblMostrarImagen;

    public EventManage() {
        super("Boletin7_Ejercicio8");
        this.setLayout(new FlowLayout());

        // Txt ROJO
        lblRojo = new JLabel("Rojo:");
        txtRojo = new JTextField();
        txtRojo.setToolTipText("Color Rojo");
        txtRojo.setPreferredSize(new Dimension(65, 20));
        txtRojo.selectAll();
        this.add(lblRojo);
        this.add(txtRojo);

        // Txt VERDE
        lblVerde = new JLabel("Verde:");
        txtVerde = new JTextField("");
        txtVerde.setToolTipText("Color Verde");
        txtVerde.setPreferredSize(new Dimension(65, 20));
        txtVerde.selectAll();
        this.add(lblVerde);
        this.add(txtVerde);

        // Txt AZUL
        lblAzul = new JLabel("Azul:");
        txtAzul = new JTextField("");
        txtAzul.setToolTipText("Color Azul");
        txtAzul.setPreferredSize(new Dimension(65, 20));
        txtAzul.selectAll();
        this.add(lblAzul);
        this.add(txtAzul);
        txtAzul.addActionListener(this);

        // Btn COLOR
        btnColor = new JButton("Color");
        btnColor.setToolTipText("Botón para cambio de colores");
        this.add(btnColor);
        btnColor.addActionListener(this);

        // Txt PATH
        txtPath = new JTextField(25);
        txtPath.setToolTipText("Introduzca ruta absoluta");
        this.add(txtPath);
        txtPath.addActionListener(this);

        // Lbl MuestraImagen
        lblMostrarImagen = new JLabel();
        lblMostrarImagen.setPreferredSize(new Dimension(450, 425));
        this.add(lblMostrarImagen);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon imagenCargada;
        try {
            int numRojo = Integer.parseInt(txtRojo.getText());
            int numVerde = Integer.parseInt(txtVerde.getText());
            int numAzul = Integer.parseInt(txtAzul.getText());

            if ((numRojo >= 0 && numRojo <= 255) && (numVerde >= 0 && numVerde <= 255)
                    && (numAzul >= 0 && numAzul <= 255)) {
                if ((e.getSource() == btnColor)
                        && (e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
                    btnColor.setForeground(new Color(numRojo, numVerde, numAzul));
                } else if (e.getSource() == btnColor || e.getSource() == txtAzul) {
                    btnColor.setBackground(new Color(numRojo, numVerde, numAzul));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Valores fuera de los límites", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Valores erróneos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (e.getSource() == txtPath) {
            imagenCargada = new ImageIcon(txtPath.getText());
            lblMostrarImagen.setIcon(imagenCargada);
        }
    }
}
