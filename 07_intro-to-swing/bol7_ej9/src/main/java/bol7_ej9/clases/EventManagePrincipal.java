package bol7_ej9.clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class EventManagePrincipal extends JFrame implements ActionListener {
    private JLabel lblCajaUno;
    private JLabel lblCajaDos;
    private JLabel lblCajaTres;
    private JLabel lblDinero;
    private JLabel lblInformante;
    private JButton btnJugar;

    double dinero = 10;
    Timer tiempo;
    String titulo = "Superminitragaperras";
    int contador = 0;
    int contaParpadeo = 0;
    boolean parpadeo;

    public EventManagePrincipal() {
        super("Boletín_Ejercicio9");
        this.setLayout(null);

        lblCajaUno = new JLabel();
        lblCajaUno.setSize(460, 450);
        lblCajaUno.setLocation(130, 50);
        this.add(lblCajaUno);

        lblCajaDos = new JLabel();
        lblCajaDos.setSize(460, 450);
        lblCajaDos.setLocation(710, 50);
        this.add(lblCajaDos);

        lblCajaTres = new JLabel();
        lblCajaTres.setSize(460, 450);
        lblCajaTres.setLocation(1285, 50);
        this.add(lblCajaTres);

        btnJugar = new JButton("NEW GAME");
        btnJugar.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 50));
        btnJugar.setSize(1620, 85);
        btnJugar.setLocation(130, 550);
        this.add(btnJugar);
        btnJugar.addActionListener(this);

        lblDinero = new JLabel("Dinero actual: " + dinero + "€");
        lblDinero.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 17));
        lblDinero.setForeground(Color.white);
        lblDinero.setSize(200, 50);
        lblDinero.setLocation(130, 900);
        this.add(lblDinero);

        lblInformante = new JLabel("Info. de pérdidas y ganancias");
        lblInformante.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 17));
        lblInformante.setForeground(Color.white);
        lblInformante.setHorizontalAlignment(JLabel.RIGHT);
        lblInformante.setSize(200, 50);
        lblInformante.setLocation(1550, 900);
        this.add(lblInformante);

        tiempo = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contador <= titulo.length()) {
                    setTitle(String.valueOf(titulo.substring(0, contador)));
                    contador++;
                } else {
                    contador = 0;
                }
            }
        });
        tiempo.start();

        tiempo = new Timer(400, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parpadeo == true) {
                    if (contaParpadeo % 2 == 0) {
                        lblInformante.setForeground(Color.white);
                    } else {
                        lblInformante.setForeground(Color.black);
                    }
                    contaParpadeo++;
                } else {
                    lblInformante.setForeground(Color.white);
                }
            }
        });
        tiempo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int contPrimeraCaja = (int) (Math.random() * 6 + 1);
        int contSegundaCaja = (int) (Math.random() * 6 + 1);
        int contTerceraCaja = (int) (Math.random() * 6 + 1);

        ArrayList<ImageIcon> listaImagenes = new ArrayList<ImageIcon>();
        for (int i = 0; i < 7; i++) {
            listaImagenes.add(new ImageIcon("src/main/java/bol7_ej9/imagenes/img" + i + ".jpg"));
        }

        if ((dinero >= 1) && (e.getSource() == btnJugar)) {
            lblCajaUno.setIcon(listaImagenes.get(contPrimeraCaja));
            lblCajaDos.setIcon(listaImagenes.get(contSegundaCaja));
            lblCajaTres.setIcon(listaImagenes.get(contTerceraCaja));

            if ((contPrimeraCaja == contSegundaCaja) && (contSegundaCaja == contTerceraCaja)) {
                dinero += 5;
                lblDinero.setText("Dinero actual: " + dinero + "€");
                lblInformante.setText("Premio " + "+" + "5€");
                parpadeo = true;
            } else if ((contPrimeraCaja == contSegundaCaja) || (contSegundaCaja == contTerceraCaja)
                    || (contPrimeraCaja == contTerceraCaja)) {
                dinero += 0.5;
                lblDinero.setText("Dinero actual: " + dinero + "€");
                lblInformante.setText("Premio " + "+0.5€");
                parpadeo = true;
            } else {
                dinero -= 1;
                lblDinero.setText("Dinero actual: " + dinero + "€");
                lblInformante.setText("Ha perdido " + "-1€");
                parpadeo = false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Créditos insuficientes", "Error", JOptionPane.ERROR_MESSAGE);
            if (JOptionPane.showConfirmDialog(null, "¿Desea realizar un ingreso?", "Ingreso nuevo",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                String introCred = JOptionPane.showInputDialog("Introduzca nuevos créditos");
                try {
                    double creditosNuevos = Double.parseDouble(introCred);
                    dinero += creditosNuevos;
                    lblDinero.setText("Dinero actual: " + dinero + "€");
                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(null, "Tiene que introducir valores numéricos",
                            "Error al introducir créditos", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
