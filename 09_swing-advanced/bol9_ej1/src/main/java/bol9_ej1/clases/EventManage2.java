package bol9_ej1.clases;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EventManage2 extends JDialog implements ItemListener, ActionListener {
    EventManage f = (EventManage) this.getOwner();
    JTextField txtTitulo;
    JLabel lblTitulo;
    JComboBox<String> cmbColoresBotones;
    String[] colores = { "Verde", "Azul", "Naranja", "Magenta" };
    Color arrayColor[] = { Color.GREEN, Color.BLUE, Color.ORANGE, Color.MAGENTA };

    public EventManage2(EventManage f) {
        super(f, true);
        setLayout(null);
        setTitle("Elegir título y colores");

        this.f = f;
        lblTitulo = new JLabel("Título ventana principal:");
        lblTitulo.setLocation(25, 15);
        lblTitulo.setSize(150, 20);
        // lblTitulo.setBorder(BorderFactory.createLineBorder(Color.blue));
        add(lblTitulo);

        txtTitulo = new JTextField();
        txtTitulo.setLocation(185, 15);
        txtTitulo.setSize(180, 20);
        add(txtTitulo);
        txtTitulo.addActionListener(this);

        cmbColoresBotones = new JComboBox<String>(colores);
        cmbColoresBotones.setMaximumRowCount(4);
        cmbColoresBotones.setSelectedIndex(-1);
        cmbColoresBotones.setLocation(25, 40);
        cmbColoresBotones.setSize(340, 20);
        cmbColoresBotones.addActionListener(this);
        cmbColoresBotones.addItemListener(this);
        add(cmbColoresBotones);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (txtTitulo.getText().equals("")) {
            f.setTitle(f.titulo);
        } else {
            f.titulo = txtTitulo.getText();
            f.setTitle(txtTitulo.getText());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        for (int i = 0; i < cmbColoresBotones.getItemCount(); i++) {
            if (cmbColoresBotones.getSelectedIndex() == i) {
                f.colorIzq = arrayColor[i];
                f.colorDcha = arrayColor[i];
            }
        }
    }
}
