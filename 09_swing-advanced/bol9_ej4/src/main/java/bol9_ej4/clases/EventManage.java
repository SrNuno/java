package bol9_ej4.clases;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EventManage extends JFrame implements ActionListener, ItemListener {
    public String filtroPrimeraLetra(String cadena) {
        if (cadena == null || cadena.length() == 0) {
            return null;
        } else {
            return cadena.substring(0, 1);
        }
    }

    public void indiceSeleccionado() {
        if (cbA.getItemCount() == 0) {
            lblIndiceElementoSelec.setText(String.format("Índice Seleccionado: Ninguno"));
        } else {
            lblIndiceElementoSelec.setText(String.format("Índice Seleccionado: %d", cbA.getSelectedIndex()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] elementos = txtTextoAnhadir.getText().split(";");
        if (e.getSource() == btnAnhadir || e.getSource() == txtTextoAnhadir) {
            if (!txtTextoAnhadir.getText().equals("")) {
                for (int i = 0; i < elementos.length; i++) {
                    if (!elementos[i].trim().equals("")) {
                        cbA.addItem(elementos[i].trim());
                        lblCantElementos.setText("Cantidad: " + cbA.getItemCount());
                        txtTextoAnhadir.setText("");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Introduzca texto", "Error al añadir",
                        JOptionPane.ERROR_MESSAGE);
                txtTextoAnhadir.requestFocus(true);
            }
        }

        if (e.getSource() == btnQuitar) {
            if (cbA.getItemCount() == 0) {
                JOptionPane.showMessageDialog(null, "No existen elementos", "Error al eliminar",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                for (int i = 0; i < cbA.getItemCount(); i++) {
                    if (cbA.getSelectedIndex() == i) {
                        cbA.removeItemAt(i);
                    }
                }
                lblCantElementos.setText("Cantidad: " + cbA.getItemCount());
                indiceSeleccionado();
            }
        }

        if (e.getSource() == btnTraspasar) {
            if (cbA.getItemCount() == 0) {
                JOptionPane.showMessageDialog(null, "No hay elementos para traspasar", "Error al traspasar",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                for (int i = 0; i < cbA.getItemCount(); i++) {
                    if (cbA.getSelectedIndex() == i) {
                        cbB.addItem(String.format("%s", cbA.getSelectedItem()));
                    }
                }
                cbA.removeItem(cbA.getSelectedItem());
                lblCantElementos.setText("Cantidad: " + cbA.getItemCount());
                indiceSeleccionado();
            }
        }

        if (e.getSource() == btnTraspasar1) {
            if (cbB.getItemCount() == 0) {
                JOptionPane.showMessageDialog(null, "No hay elementos para traspasar", "Error al traspasar",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                for (int i = 0; i < cbB.getItemCount(); i++) {
                    if (cbB.getSelectedIndex() == i) {
                        cbA.addItem(String.format("%s", cbB.getSelectedItem()));
                    }
                }
                cbB.removeItem(cbB.getSelectedItem());
                lblCantElementos.setText("Cantidad: " + cbA.getItemCount());
                indiceSeleccionado();
            }
        }

        if (e.getSource() == txtFiltrar) {
            if (cbA.getItemCount() == 0) {
                JOptionPane.showMessageDialog(null,
                        String.format("No hay elementos con la cadena \"%s\"", txtFiltrar.getText()), "Error al buscar",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                if (!txtFiltrar.getText().equals("")) {
                    for (int i = 0; i < elementos.length; i++) {
                        System.out.println(elementos[i]);
                    }
                }
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cbA) {
            lblIndiceElementoSelec.setText(String.format("Índice Seleccionado: %d", cbA.getSelectedIndex()));
        }
    }

    private class MouseHandler extends MouseAdapter {
        public void mouseMoved(MouseEvent e) {
            if (e.getSource().getClass() == JButton.class) {
                ((JButton) e.getSource()).setForeground(Color.RED);
            }
        }

        public void mouseExited(MouseEvent e) {
            if (e.getSource().getClass() == JButton.class) {
                ((JButton) e.getSource()).setForeground(Color.BLACK);
            }
        }
    }

    public EventManage() {
        super("Ejercicio4_bol9");
        setLayout(null);

        btnAnhadir = new JButton("Añadir");
        btnAnhadir.setSize(110, 25);
        btnAnhadir.setLocation(10, 10);
        add(btnAnhadir);
        btnAnhadir.addActionListener(this);
        btnAnhadir.addMouseListener(new MouseHandler());
        btnAnhadir.addMouseMotionListener(new MouseHandler());

        btnQuitar = new JButton("Quitar");
        btnQuitar.setSize(110, 25);
        btnQuitar.setLocation(130, 10);
        add(btnQuitar);
        btnQuitar.addActionListener(this);
        btnQuitar.addMouseListener(new MouseHandler());
        btnQuitar.addMouseMotionListener(new MouseHandler());

        btnTraspasar = new JButton("Trasapar 1 a 2");
        btnTraspasar.setSize(130, 25);
        btnTraspasar.setLocation(250, 10);
        add(btnTraspasar);
        btnTraspasar.addMouseListener(new MouseHandler());
        btnTraspasar.addMouseMotionListener(new MouseHandler());
        btnTraspasar.addActionListener(this);

        btnTraspasar1 = new JButton("Trasapar 2 a 1");
        btnTraspasar1.setSize(130, 25);
        btnTraspasar1.setLocation(390, 10);
        add(btnTraspasar1);
        btnTraspasar1.addMouseListener(new MouseHandler());
        btnTraspasar1.addMouseMotionListener(new MouseHandler());
        btnTraspasar1.addActionListener(this);

        txtTextoAnhadir = new JTextField();
        txtTextoAnhadir.setSize(230, 25);
        txtTextoAnhadir.setLocation(10, 50);
        txtTextoAnhadir.requestFocus(true);
        add(txtTextoAnhadir);
        txtTextoAnhadir.addActionListener(this);

        txtFiltrar = new JTextField();
        txtFiltrar.setSize(270, 25);
        txtFiltrar.setLocation(250, 50);
        add(txtFiltrar);
        txtFiltrar.addActionListener(this);

        cbA = new JComboBox<String>();
        cbA.setSize(230, 25);
        cbA.setLocation(10, 90);
        cbA.addItemListener(this);
        add(cbA);

        cbB = new JComboBox<String>();
        cbB.setSize(270, 25);
        cbB.setLocation(250, 90);
        add(cbB);

        lblCantElementos = new JLabel("Cantidad: " + cbA.getItemCount());
        lblCantElementos.setSize(120, 20);
        lblCantElementos.setLocation(10, 230);
        add(lblCantElementos);

        lblIndiceElementoSelec = new JLabel("Índice seleccionado: Ninguno");
        lblIndiceElementoSelec.setSize(170, 20);
        lblIndiceElementoSelec.setLocation(250, 230);
        add(lblIndiceElementoSelec);
    }

    JComboBox<String> cbA;
    JComboBox<String> cbB;

    JButton btnAnhadir;
    JButton btnQuitar;
    JButton btnTraspasar;
    JButton btnTraspasar1;

    JTextField txtTextoAnhadir;
    JTextField txtFiltrar;

    JLabel lblCantElementos;
    JLabel lblIndiceElementoSelec;
    JLabel lbl;

}
