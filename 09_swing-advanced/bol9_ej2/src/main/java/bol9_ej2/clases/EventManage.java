package bol9_ej2.clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class EventManage extends JFrame implements ActionListener {

    public EventManage() {
        super("iPhone");
        setLayout(null);
        setResizable(false);

        // Menu Archivo
        mnuGrabar = new JMenuItem("Grabar número");
        mnuGrabar.addActionListener(this);
        mnuGrabar.setMnemonic('G');
        mnuLeer = new JMenuItem("Leer números");
        mnuLeer.setMnemonic('L');
        mnuLeer.addActionListener(this);
        mnuArchivo = new JMenu("Archivo");
        mnuArchivo.setMnemonic('A');
        mnuArchivo.add(mnuGrabar);
        mnuArchivo.add(mnuLeer);

        // Menu Móvil
        mnuReset = new JMenuItem("Resetear pantalla");
        mnuReset.setMnemonic('R');
        mnuReset.addActionListener(this);
        mnuSalir = new JMenuItem("Salir");
        mnuSalir.setMnemonic('S');
        mnuSalir.addActionListener(this);
        mnuMovil = new JMenu("Móvil");
        mnuMovil.setMnemonic('M');
        mnuMovil.add(mnuReset);
        mnuMovil.addSeparator();
        mnuMovil.add(mnuSalir);

        // Menu Otros
        mnuAcercaDe = new JMenuItem("Acerca de...");
        mnuAcercaDe.setMnemonic('A');
        mnuAcercaDe.addActionListener(this);
        mnuAcercaDe.addKeyListener(new KeyHandler());
        mnuOtros = new JMenu("Otros");
        mnuOtros.setMnemonic('O');
        mnuOtros.add(mnuAcercaDe);

        // Menu Principal
        mnuPrincipal = new JMenuBar();
        mnuPrincipal.add(mnuArchivo);
        mnuPrincipal.add(mnuMovil);
        mnuPrincipal.add(mnuOtros);
        this.setJMenuBar(mnuPrincipal);

        txtMostrarNumeros = new JTextField();
        txtMostrarNumeros.setSize(200, 70);
        txtMostrarNumeros.setLocation(10, 10);
        txtMostrarNumeros.setEditable(false);
        txtMostrarNumeros.setFont(new Font("Arial", Font.BOLD, 30));
        txtMostrarNumeros.setHorizontalAlignment(JTextField.RIGHT);
        txtMostrarNumeros.addKeyListener(new KeyHandler());
        add(txtMostrarNumeros);

        int x = 10, y = 95;
        for (int i = 0; i < valores.length; i++) {
            btnNumeros = new JButton(valores[i]);
            btnNumeros.setSize(60, 35);
            btnNumeros.setLocation(x, y);
            btnNumeros.setFont(new Font("Arial", Font.BOLD, 17));
            this.add(btnNumeros);
            colorDefault = btnNumeros.getBackground();
            btnNumeros.addActionListener(this);
            btnNumeros.addMouseListener(new MouseHandler());
            btnNumeros.addMouseMotionListener(new MouseHandler());

            if ((i + 1) % 3 == 0) {
                x = 10;
                y += 50;
            } else {
                x += 70;
            }
        }

        btnReset = new JButton("Reset");
        btnReset.setSize(200, 30);
        btnReset.setLocation(10, 295);
        btnReset.addActionListener(this);
        this.add(btnReset);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass() == JButton.class) {
            txtMostrarNumeros.setText(txtMostrarNumeros.getText() + ((JButton) e.getSource()).getText());
        }

        if (e.getSource() == mnuGrabar) {
            try (PrintWriter f = new PrintWriter(new FileWriter("guardaNumeros.txt", true))) {
                if ((txtMostrarNumeros.getText().startsWith("6") || txtMostrarNumeros.getText().startsWith("8")
                        || txtMostrarNumeros.getText().startsWith("9"))
                        && txtMostrarNumeros.getText().length() == 9) {

                    f.println(txtMostrarNumeros.getText());
                    JOptionPane.showMessageDialog(null, "Número guardado correctamente",
                            "Guardado correcto",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Numero incorrecto", "Error al guardar",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                System.err.println("Error de acceso al archivo");
            }
        }

        if (e.getSource() == mnuLeer) {
            try (Scanner obj = new Scanner(new File("guardaNumeros.txt"))) {
                texto = "";
                if (obj.hasNext()) {
                    while (obj.hasNext()) {
                        texto = obj.next() + String.format("\n%s", texto);
                    }
                    JOptionPane.showMessageDialog(null, texto, "Nums. guardados", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay registros", "Ningún registro",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex) {
                System.err.println("Error de acceso al archivo: " + ex.getMessage());
            }
        }

        if (e.getSource() == btnReset || e.getSource() == mnuReset) {
            for (Component component : this.getContentPane().getComponents()) {
                if (component.getClass() == JButton.class) {
                    component.setBackground(colorDefault);
                }
            }
            txtMostrarNumeros.setText("");
        }

        if (e.getSource() == mnuSalir) {
            int res = JOptionPane.showConfirmDialog(null,
                    "¿Deseas cerrar el programa?", "Salir del programa",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (res == JOptionPane.YES_OPTION)
                System.exit(0);
        }

        if (e.getSource() == mnuAcercaDe) {
            JOptionPane.showMessageDialog(null,
                    "<html>Título: Mobile Phone<br> Creador y Desarrollador: Nuno Galán</html>",
                    "Información sobre la aplicación", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class MouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (e.getSource().getClass() == JButton.class) {
                if (e.getSource() != btnReset) {
                    ((JButton) e.getSource()).setBackground(Color.GREEN);
                }
            }
        }

        public void mouseEntered(MouseEvent e) {
            if (e.getSource().getClass() == JButton.class) {
                if (((JButton) e.getSource()).getBackground() != Color.GREEN) {
                    ((JButton) e.getSource()).setBackground(Color.RED);
                }
            }
        }

        public void mouseExited(MouseEvent e) {
            if (e.getSource().getClass() == JButton.class) {
                if (((JButton) e.getSource()).getBackground() != Color.GREEN) {
                    ((JButton) e.getSource()).setBackground(colorDefault);
                }
            }
        }
    }

    private class KeyHandler extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() >= 48 && e.getKeyChar() <= 57) {
                txtMostrarNumeros.setText(txtMostrarNumeros.getText() + e.getKeyChar());
            }
        }
    }

    private String[] valores = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "#", "0", "*" };
    JButton btnNumeros;
    JButton btnReset;
    JTextField txtMostrarNumeros;
    JLabel lblNombre;
    Color colorDefault;
    JMenuBar mnuPrincipal;
    JMenu mnuArchivo, mnuMovil, mnuOtros;
    JMenuItem mnuGrabar, mnuLeer, mnuReset, mnuSalir, mnuAcercaDe;
    Timer temporizador;
    String texto = "";
}