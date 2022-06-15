package bol7_ej2.clases;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventManage extends JFrame implements ActionListener {
    private JButton btnDado;
    private JLabel lblDado;
    private JTextField txtDado;
    public int numTxt;
    public int num;
    public String numeroDado;

    public EventManage() {
        super("Dado");
        this.setLayout(new FlowLayout());

        // Botón
        btnDado = new JButton("Pulsar aquí");
        this.add(btnDado);
        btnDado.addActionListener(this);

        // Label
        lblDado = new JLabel("Número");
        this.add(lblDado);

        // TextField
        txtDado = new JTextField(3);
        // No hace falta ponerlo, por defecto pone true
        // txtDado.setEditable(false);
        this.add(txtDado);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == btnDado || evento.getSource() == txtDado) {
            try {
                numTxt = Integer.parseInt(txtDado.getText());
                if (numTxt >= 1) {
                    num = (int) (Math.random() * numTxt + 1);
                    String numDado2 = String.valueOf(num);
                    this.lblDado.setText("Número " + numDado2);
                } else {
                    num = (int) (Math.random() * 6 + 1);
                    numeroDado = String.valueOf(num);
                    this.lblDado.setText("Número: " + numeroDado);
                }
            } catch (NumberFormatException e) {
                num = (int) (Math.random() * 6 + 1);
                numeroDado = String.valueOf(num);
                this.lblDado.setText("Número: " + numeroDado);
            }

        }

    }
}
