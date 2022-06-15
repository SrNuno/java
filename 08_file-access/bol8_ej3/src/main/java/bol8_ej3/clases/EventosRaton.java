package bol8_ej3.clases;

import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class EventosRaton extends JFrame {
    JLabel lbl, lbl2;

    public EventosRaton() {
        super("Pueba eventos");
        setLayout(new FlowLayout());
        lbl = new JLabel("<html><h1>Probando eventos de ratón</h1></html>");
        lbl.addMouseListener((MouseListener) new MouseHandler());
        lbl.addMouseMotionListener(new MouseHandler());
        add(lbl);
        lbl2 = new JLabel("Datos");
        add(lbl2);
    }

    // Inner class o clase interna.
    // Desde ella se puede acceder a todos los miembros de la externa.
    private class MouseHandler implements MouseListener, MouseMotionListener {
        @Override
        public void mouseMoved(java.awt.event.MouseEvent e) {
            lbl2.setText(String.format("Posición X:%d Y:%d ", e.getX(),
                    e.getY()));
        }

        @Override
        public void mouseDragged(java.awt.event.MouseEvent e) {
            lbl2.setText(String.format(
                    "Posición X:%d Y:%d Botón pulsado: %s",
                    e.getX(), e.getY(),
                    SwingUtilities.isLeftMouseButton(e) ? "principal" : "otro"));
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            if (e.getClickCount() > 1) {
                lbl2.setText("Pulsación múltiple");
            } else {
                lbl2.setText(String.format(
                        "<html>Boton Pulsado: %d<br>Teclas: CTRL:%s ALT:%s SHIFT:%s ",
                        e.getButton(),
                        e.isControlDown() ? "Sí" : "No",
                        e.isAltDown() ? "Sí" : "No",
                        e.isShiftDown() ? "Sí" : "No"));
            }
        }
    }
}
