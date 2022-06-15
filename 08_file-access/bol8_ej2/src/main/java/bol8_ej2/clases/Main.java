package bol8_ej2.clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner opciones = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        String home = System.getProperty("user.home");
        String path = home + "/prueba.txt";
        File f = new File(path);
        System.out.printf("Archivo seleccionado por defecto: %s\n", f.getPath());

        do {
            try {
                System.out.printf("1. Gestionar otro archivo");
                System.out.printf("\n2. Crea o sobreescribe el archivo");
                System.out.printf("\n3. Mostrar contenido archivo");
                System.out.printf("\n4. Añade contenido");
                System.out.printf("\n5. Borrar archivo");
                System.out.printf("\n6. Salir");
                System.out.printf("\n\tIntroduzca opción: ");
                opcion = opciones.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.printf("\t\tIntroduzca la ruta del archivo que quiere gestionar: ");
                        path = sc.nextLine();
                        f = new File(path);
                        System.out.printf("\t\tArchivo seleccionado %s \n\n", f.getName());
                        break;

                    case 2:
                        try {
                            if (f.exists() == false) {
                                f.createNewFile();
                                System.out.printf("\t\tArchivo %s nuevo creado en la ruta %s\n\n", f.getName(),
                                        f.getParent());
                            } else {
                                try (PrintWriter archivo = new PrintWriter(new FileWriter(f, false))) {
                                    String respuesta;

                                    System.out.printf("\t\t¿Desea sobreescribir el archivo %s S/N? ", f.getName());
                                    respuesta = sc.nextLine();

                                    if (respuesta.equals("S") || respuesta.equals("s")) {
                                        archivo.println("Se ha sobreescrito el archivo");
                                        archivo.close();
                                        System.out.printf("\t\tContenido del archivo %s sobreescrito\n\n", f.getName());
                                    } else {
                                        System.out.printf("\t\tNo ha ocurrido nada\n\n");
                                    }
                                } catch (IOException e) {
                                    System.err.println("Error de acceso al archivo");
                                }
                            }
                        } catch (IOException ex) {
                            System.err.printf("\t\tRuta incorrecta, no se puede crear o sobreescribir\n\n");
                        }
                        break;

                    case 3:
                        try (Scanner sc2 = new Scanner(f)) {
                            while (sc2.hasNext()) {
                                System.out.printf("\t%s\n", sc2.nextLine());
                            }
                            System.out.println();
                        } catch (IOException e) {
                            System.err.println("Error de acceso al archivo");
                        }

                        break;

                    case 4:
                        String texto = "";
                        System.out.printf("\t\tIntroduzca texto para añadir al archivo:\n");
                        texto = sc.nextLine();
                        System.out.println();

                        try (PrintWriter arch = new PrintWriter(new FileWriter(f, true))) {
                            arch.println(texto);
                            arch.close();
                        } catch (IOException e) {
                            System.err.println("Error de acceso al archivo");
                        }
                        break;

                    case 5:
                        String respuesta;
                        System.out.printf("\t\t¿Deseas eliminar el archivo %s S/N? ", f.getName());
                        respuesta = sc.nextLine();

                        if ((respuesta.equals("S") || respuesta.equals("s")) && f.exists() && f.canExecute()) {
                            if (f.delete()) {
                                System.out.printf("\t\tSe ha eliminado correctamente %s\n\n", f.getName());
                            }
                        } else {
                            System.out.printf("\t\tNo se ha eliminado %s\n\n", f.getName());
                        }

                        break;

                    case 6:
                        System.out.printf("\tVuelva pronto, gracias\n");
                        break;

                    default:
                        System.out.printf("\t\tOpción incorrecta\n\n");
                        break;
                }
            } catch (InputMismatchException e) {
                opciones.nextLine();
                System.err.println("\tCurro, esta vez no rompe el menú\n");
            }
        } while (opcion != 6);
    }
}
