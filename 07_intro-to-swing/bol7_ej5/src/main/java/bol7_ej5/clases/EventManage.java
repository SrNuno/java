package bol7_ej5.clases;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EventManage extends JFrame implements ActionListener, ItemListener {
    private JTextField txtUsuario;
    private JButton btnEnter;
    private JCheckBox chkVuelta;
    private JCheckBox chkHabilitarTextFil;

    public EventManage() {
        super("Boletin7_Ejercicio5");
        this.setLayout(new FlowLayout());

        // TXT Usuario
        txtUsuario = new JTextField("Introduzca texto", 12);
        this.add(txtUsuario);
        txtUsuario.addActionListener(this);

        // Botón Enter
        btnEnter = new JButton("Pulsar");
        this.add(btnEnter);
        btnEnter.addActionListener(this);

        // CheckBox Vuelta
        chkVuelta = new JCheckBox("Dar la vuelta");
        this.add(chkVuelta);

        // CheckBox Habilitar/No Habilitar
        chkHabilitarTextFil = new JCheckBox("Deshabilitar caja de texto");
        this.add(chkHabilitarTextFil);
        chkHabilitarTextFil.addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cadenaInversa = "";
        if (chkVuelta.isSelected() && (e.getSource() == btnEnter || e.getSource() == txtUsuario)) {
            if (JOptionPane.showConfirmDialog(null,
                    "¿Desea colocar " + "\"" + txtUsuario.getText() + "\""
                            + " de forma inversa como título de la ventana principal?",
                    "Bol7_Ej5_ApB",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                for (int i = 0; i < txtUsuario.getText().length(); i++) {
                    cadenaInversa = txtUsuario.getText().charAt(i) + cadenaInversa;
                }
                setTitle("\"" + cadenaInversa + "\"");
            }

        } else if (e.getSource() == btnEnter || e.getSource() == txtUsuario) {
            if (JOptionPane.showConfirmDialog(null,
                    "¿Desea colocar " + "\"" + txtUsuario.getText() + "\"" + " como título de la ventana principal?",
                    "Bol7_Ej5",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                setTitle("\"" + txtUsuario.getText() + "\"");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        txtUsuario.setEditable(!chkHabilitarTextFil.isSelected());
    }
}
