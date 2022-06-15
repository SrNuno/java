package bol4_ej3.clases;

import java.util.Scanner;

public class Main {
    public static void verDatosEmpleados(Empresa empresa) {
        int opcionSubmenu;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.printf("\n\t\t\tSubmenú - VER DATOS EMP");
            System.out.printf("\n\t----------------------------------------------------------");
            System.out.printf("\n\t1. Ver todos los datos ambos empleados");
            System.out.printf("\n\t2. Ver solo un dato de ambos empleados");
            System.out.printf("\n\t3. Salir");

            System.out.print("\n\t\tIntroduzca la opción que desee: ");
            opcionSubmenu = sc.nextInt();
            if (opcionSubmenu != 3) {
                System.out.printf("\t\tLa opcion seleccionada es " + opcionSubmenu + "\n");
            }

            switch (opcionSubmenu) {
                case 1:
                    empresa.iuEmpleadoUno.mostrar();
                    empresa.iuEmpleadoDos.mostrar();
                    break;

                case 2:
                    int campo;
                    do {
                        System.out.printf("\n\tIntroduzca un número para mostrar el campo seleccionado: ");
                        campo = sc.nextInt();

                        if (campo >= 1 && campo <= 5) {
                            empresa.iuEmpleadoUno.mostrar(campo);
                            empresa.iuEmpleadoDos.mostrar(campo);
                        } else {
                            System.out.printf("\t\tPrueba otra vez\n");
                        }
                    } while (campo >= 6);
                    System.out.printf("\n");
                    break;

                case 3:
                    break;

                default:
                    System.out.printf("\tOpción no válida\n");
                    break;
            }
        } while (opcionSubmenu != 3);
    }

    public static void modificarDatos(Empresa empresa) {
        int opcionSubmenu;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.printf("\n\t\t\tSubmenú - MODIFICAR DATOS");
            System.out.printf("\n\t----------------------------------------------------------");
            System.out.println("\n\t1. Cambio en el directivo");
            System.out.println("\t2. Cambio en uno de los empleados");
            System.out.println("\t3. Salir");
            System.out.print("\t\tIntroduzca la opción que desee: ");
            opcionSubmenu = sc.nextInt();

            if (opcionSubmenu != 3) {
                System.out.printf("\t\tLa opcion seleccionada es " + opcionSubmenu + "\n");
            }

            switch (opcionSubmenu) {
                case 1:
                    empresa.iuDirectivo.pedirDirectivo();
                    System.out.println();
                    empresa.iuDirectivo.mostrarDirectivo();
                    System.out.println();
                    break;

                case 2:
                    int opcionSubmenuEmpleados;
                    Scanner sc2 = new Scanner(System.in);
                    do {
                        System.out.println("\n\t\t\t\tSubmenú de empleados");
                        System.out.printf("\t\t------------------------------------------------------");
                        System.out.println("\n\t\t1. Cambio en el primer empleado");
                        System.out.println("\t\t2. Cambio en el segundo empleado");
                        System.out.println("\t\t3. Salir");
                        System.out.print("\t\t\tIntroduzca la opción que desee: ");
                        opcionSubmenuEmpleados = sc2.nextInt();

                        switch (opcionSubmenuEmpleados) {
                            case 1:
                                empresa.iuEmpleadoUno.pedir();
                                break;

                            case 2:
                                empresa.iuEmpleadoDos.pedir();
                                break;

                            case 3:
                                break;

                            default:
                                System.out.printf("\tError\n");
                                break;
                        }
                    } while (opcionSubmenuEmpleados != 3);

                case 3:
                    break;

                default:
                    System.out.printf("\tError\n");
                    break;
            }
        } while (opcionSubmenu != 3);
    }

    public static void main(String[] args) {
        Directivo directivo = new Directivo("Juan", "López Pérez", 50, "12345678X", "Mantenimiento", 45);
        Empleado empleado1 = new Empleado("Miguel", "Miguelez Cazapal", 18, "53817232S", 5000);
        Empleado empleado2 = new Empleado("Pedro", "Lopez Mera", 18, "12345678A", 2500);
        Empresa empresa = new Empresa(5000, empleado1, empleado2, directivo);

        int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.printf("\n\t\tMenú\n");
            System.out.println("---------------------------------------");
            System.out.println("1. Ver datos empleados");
            System.out.println("2. Ver datos directivo");
            System.out.println("3. Modificar datos");
            System.out.println("4. Pagar");
            System.out.println("5. Cobrar");
            System.out.println("6. Salir");
            System.out.printf("\tIntroduzca la opción que desee: ");
            opcion = sc.nextInt();
            if (opcion != 6) {
                System.out.printf("\tLa opcion seleccionada es la " + opcion + "\n");
            }

            switch (opcion) {
                case 1:
                    verDatosEmpleados(empresa);
                    break;

                case 2:
                    empresa.iuDirectivo.mostrarDirectivo();
                    System.out.println();
                    break;

                case 3:
                    modificarDatos(empresa);
                    break;

                case 4:
                    System.out.printf("\n\tANTES: ");
                    System.out.print(empresa.getGanancias() + " euros");

                    System.out.printf("\n\n\tDESPUÉS: ");
                    empresa.setGanancias(empresa.getGanancias() - empresa.empleadoUno.getSalario()
                            - empresa.empleadoDos.getSalario());
                    System.out.printf(empresa.getGanancias() + " euros\n");
                    break;

                case 5:
                    Scanner sc3 = new Scanner(System.in);
                    double ganancia;

                    System.out.printf("\n\tANTES: ");
                    System.out.print(empresa.getGanancias());

                    System.out.printf("\n\n\tIntroduzca un valor: ");
                    ganancia = sc3.nextDouble();

                    System.out.printf("\n\tDESPUÉS: ");
                    empresa.setGanancias(empresa.getGanancias() + ganancia);
                    System.out.printf(empresa.getGanancias() + "\n");
                    break;

                case 6:
                    System.out.printf("\tGracias y vuelva pronto");
                    break;

                default:
                    System.out.printf("\tERROR\n");
                    break;
            }
        } while (opcion != 6);
    }
}
