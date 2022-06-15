package bol7_ej4.clases;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventManage extends JFrame implements ActionListener {
    private JLabel lblDni;
    private JTextField txtDni;
    private JTextField txtNombre;
    private JTextField txtInfo;
    private JTextField txtInicio;
    private JTextField txtFinal;

    public EventManage() {
        super("Cajas de edición de texto");
        this.setLayout(new FlowLayout());

        // Label DNI
        lblDni = new JLabel("Introduzca su DNI");
        this.add(lblDni);

        // Caja DNI
        txtDni = new JTextField(9);
        this.add(txtDni);
        txtDni.addActionListener(this);

        // Caja Nombre
        txtNombre = new JTextField("Escribe tu nombre");
        this.add(txtNombre);
        txtNombre.addActionListener(this);

        // Caja Inicio
        txtInicio = new JTextField("Pos. Inicial", 6);
        this.add(txtInicio);
        txtInicio.addActionListener(this);

        // Caja Final
        txtFinal = new JTextField("Pos. Final", 6);
        this.add(txtFinal);
        txtFinal.addActionListener(this);

        // Caja Info
        txtInfo = new JTextField("Información no editable", 23);
        txtInfo.setEditable(false);
        this.add(txtInfo);
        txtInfo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == txtFinal) {
            try {
                if (Integer.parseInt(txtInicio.getText()) >= 0
                        || Integer.parseInt(txtFinal.getText()) <= txtNombre.getText().length() -1) {
                    txtNombre.select((Integer.parseInt(txtInicio.getText())), (Integer.parseInt(txtFinal.getText())));
                } else {
                    JOptionPane.showMessageDialog(null, "Valor fuera de la longitud", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IllegalArgumentException excepcion) {
                JOptionPane.showMessageDialog(null, "Valores incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }
    }
}
