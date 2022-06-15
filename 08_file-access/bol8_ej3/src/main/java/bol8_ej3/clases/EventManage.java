package bol8_ej3.clases;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EventManage extends JFrame implements ActionListener {
    JButton btnCargar;
    JTextArea txtContenido = new JTextArea(10, 10);
    JLabel lblImagen;
    File f, fAuxiliar;
    String finalExtension;

    public EventManage() {
        super("Boletín8_Ejercicio3");
        this.setLayout(new FlowLayout());
        btnCargar = new JButton("Cargar archivos");
        add(btnCargar);
        btnCargar.addActionListener(this);

        lblImagen = new JLabel();
        add(lblImagen);

        txtContenido = new JTextArea(20, 30);
        txtContenido.setVisible(false);
        add(txtContenido);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int respuesta;
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtroImagenes = new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "gif", "png");
        FileNameExtensionFilter filtroTexto = new FileNameExtensionFilter("Archivos de Texto", "txt");

        fc.addChoosableFileFilter(filtroImagenes);
        fc.addChoosableFileFilter(filtroTexto);
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        respuesta = fc.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            String fileName = String.valueOf(fc.getSelectedFile().getName());
            String finalExtension = "";
            int a = fileName.lastIndexOf('.');
            if (a > 0) {
                finalExtension = fileName.substring(a + 1);
            }

            f = fc.getSelectedFile();
            if (f.isDirectory()) {
                try {
                    String[] elementos = f.list();
                    txtContenido.setEditable(false);
                    txtContenido.setText("");
                    lblImagen.setVisible(false);
                    // if (f != null) {
                    for (int i = 0; i < elementos.length; i++) {
                        fAuxiliar = new File(fc.getSelectedFile().getPath() + "/" + elementos[i]);
                        if (fAuxiliar.isDirectory()) {
                            txtContenido.append(String.format("D~%s\n", fAuxiliar.getName()));
                            txtContenido.setSize(this.getPreferredSize());
                            txtContenido.setVisible(true);
                        } else {
                            txtContenido.append(String.format("%s\n", fAuxiliar.getName()));
                            txtContenido.setSize(this.getPreferredSize());
                            txtContenido.setVisible(true);
                        }
                        // }
                    }
                } catch (NullPointerException ex) {
                    System.err.println("Archivo sin permisos");
                }
            } else {
                if (finalExtension.equals("txt")) {
                    String contenido = "";
                    try (Scanner sc = new Scanner(f)) {
                        txtContenido.setVisible(true);
                        txtContenido.setLineWrap(true);
                        txtContenido.setText("");
                        txtContenido.setSize(this.getPreferredSize());
                        while (sc.hasNext()) {
                            contenido = sc.nextLine();
                            txtContenido.append(String.format(contenido + "\n"));
                        }
                        System.out.println();
                        lblImagen.setVisible(false);
                    } catch (IOException ex) {
                        System.err.println("Error de acceso al archivo");
                    }
                } else if (finalExtension.equals("jpg") || finalExtension.equals("jpeg")
                        || finalExtension.equals("gif")
                        || finalExtension.equals("png")) {
                    lblImagen.setIcon(new ImageIcon(fc.getSelectedFile().getPath()));
                    lblImagen.setSize(lblImagen.getPreferredSize());
                    lblImagen.setVisible(true);
                    lblImagen.setText("");
                    this.setSize(lblImagen.getWidth() + 50, lblImagen.getHeight() + 100);
                } else {
                    lblImagen.setVisible(true);
                    txtContenido.setVisible(false);
                    lblImagen.setIcon(null);
                    lblImagen.setSize(this.getPreferredSize());
                    lblImagen.setText(String.format(
                            "<html>Nombre: %s <br> Trayectoria: %s <br> Tamaño: %dKB <br> Permiso de Lectura: %b, permiso de Escritura: %b, permiso de Ejecución: %b",
                            fc.getSelectedFile().getName(), fc.getSelectedFile().getPath(),
                            fc.getSelectedFile().length() / 1024, fc.getSelectedFile().canRead(),
                            fc.getSelectedFile().canWrite(), fc.getSelectedFile().canExecute()));
                }
            }
        }
    }
}