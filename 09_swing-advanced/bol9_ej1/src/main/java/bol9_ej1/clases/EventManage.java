package bol9_ej1.clases;


import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EventManage extends JFrame {
    JButton btnIzq, btnDcha;
    JLabel lblTeclas;

    Color colorIzq = Color.red;
    Color colorDcha = Color.yellow;
    String titulo = "Control de Ratón";

    public EventManage() {
        super("Control de Ratón");
        this.getContentPane().addMouseListener(new MouseHandler());
        this.getContentPane().addMouseMotionListener(new MouseHandler());
        this.addKeyListener(new KeySelected());
        addWindowListener(new CierreVentana());
        setLayout(null);
        setFocusable(true);

        btnIzq = new JButton("Izquierda");
        btnIzq.setLocation(80, 180);
        btnIzq.setSize(90, 30);
        btnIzq.setBackground(Color.white);
        btnIzq.addMouseListener(new MouseHandler());
        btnIzq.addMouseMotionListener(new MouseHandler());
        btnIzq.addKeyListener(new KeySelected());
        add(btnIzq);

        btnDcha = new JButton("Derecha");
        btnDcha.setLocation(200, 180);
        btnDcha.setSize(90, 30);
        btnDcha.setBackground(Color.white);
        btnDcha.addMouseListener(new MouseHandler());
        btnDcha.addMouseMotionListener(new MouseHandler());
        btnDcha.addKeyListener(new KeySelected());
        add(btnDcha);

        lblTeclas = new JLabel("<html>Código tecla pulsada: Ninguna<br>Letra Seleccionada: Ninguna</html>");
        lblTeclas.setLocation(80, 15);
        lblTeclas.setSize(200, 50);
        add(lblTeclas);
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            if (e.getSource() == getContentPane()) {
                setTitle(String.format("%s - (X:%d, Y:%d)", titulo, e.getX(), e.getY()));
            } else {
                int coordenadaX = (int) (e.getX() + ((JButton) e.getSource()).getX());
                int coordenadaY = (int) (e.getY() + ((JButton) e.getSource()).getY());
                setTitle(String.format("%s - (X:%d, Y:%d)", titulo, coordenadaX, coordenadaY));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setTitle(titulo);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                btnIzq.setBackground(colorIzq);
            } else {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    btnDcha.setBackground(colorDcha);
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                btnIzq.setBackground(Color.white);
            } else {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    btnDcha.setBackground(Color.white);
                }
            }
        }
    }

    private class KeySelected extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C) {
                EventManage2 f = new EventManage2(EventManage.this);

                f.setLocationRelativeTo(null);
                f.setSize(400, 290);
                f.setLocationRelativeTo(null);
                f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                for (int i = 0; i < f.cmbColoresBotones.getItemCount(); i++) {
                    if (colorIzq == f.arrayColor[i]) {
                        f.cmbColoresBotones.setSelectedIndex(i);
                    }
                }
                f.setVisible(true);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            lblTeclas.setText(String.format("<html>Código tecla pulsada: %d <br> Letra seleccionada: %s</html>",
                    e.getKeyCode(), e.getKeyChar()));
        }
    }

    private class CierreVentana extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            int res = JOptionPane.showConfirmDialog(null,
                    "Deseas cerrar el programa?", "Eventos Teclado",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (res == JOptionPane.OK_OPTION)
                System.exit(0);
        }
    }
}
