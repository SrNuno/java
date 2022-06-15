package bol8_ej1.clases;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner opciones = new Scanner(System.in);
        int opcion = 0;

        Scanner sc2 = new Scanner(System.in);
        String path = "";
        String pathNuevo = "";
        File f;

        do {
            try {
                System.out.printf("\n1. Seleccionar archivo o directorio");
                System.out.printf("\n2. Información");
                System.out.printf("\n3. Crear directorio");
                System.out.printf("\n4. Salir");
                System.out.printf("\n\tIntroduzca opción: ");
                opcion = opciones.nextInt();
                switch (opcion) {
                    case 1:
                        do {
                            System.out.printf("\t\tIntroduzca path de archivo o directorio: ");
                            path = sc2.nextLine();
                            f = new File(path);
                        } while (f.exists() == false || f.canRead() == false);
                        break;

                    case 2:
                        f = new File(path);
                        if (f.isFile()) {
                            System.out.printf("El nombre del archivo es %s y la ruta es %s", f.getName(),
                                    f.getParent());
                        } else if (f.isDirectory()) {
                            String[] listarArchivos = f.list();
                            File fn;

                            if (listarArchivos == null || listarArchivos.length == 0) {
                                System.out.println("\t\tError, carpeta sin permisos");
                            } else {
                                for (int i = 0; i < listarArchivos.length; i++) {
                                    fn = new File(path + "/" + listarArchivos[i]);
                                    if (fn.isFile()) {
                                        System.out.printf("Nombre: %s y tamaño: %d\n", fn.getName(), fn.length());
                                    }
                                }
                            }
                        }
                        break;

                    case 3:
                        System.out.printf("\t\tIntroduzca ruta y el nombre para crear un directorio: ");
                        path = sc2.nextLine();
                        f = new File(path);

                        if (f.mkdir()) {
                            System.out.println("Archivo creado correctamente");
                        } else {
                            System.out.println("Archivo existente");
                        }
                        break;

                    case 4:
                        System.out.println("Vuelva pronto");
                        break;

                    default:
                        System.out.println("Opción no valida");
                        break;
                }
            } catch (InputMismatchException e) {
                opciones.nextLine();
                System.err.println("\tDebe ingresar obligatoriamente un número entero");
            }
        } while (opcion != 4);

    }
}
