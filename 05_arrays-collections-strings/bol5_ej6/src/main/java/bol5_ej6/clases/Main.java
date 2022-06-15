package bol5_ej6.clases;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Matriz matUno = new Matriz(3);
        int opcion;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Mostrar matriz");
            System.out.println("2. Mostrar suma de todos los elementos");
            System.out.println("3. Mostrar suma diagonal");
            System.out.println("4. Mostrar suma de elementos salvo diagonal");
            System.out.println("5. Mostrar suma de elementos de una fila");
            System.out.println("6. Mostrar matriz sin una fila ");
            System.out.println("7. Salir");
            System.out.printf("\tIntroduzca opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println();
                    Matriz.muestraSuma(matUno.matBidimensional);
                    break;

                case 2:
                    System.out.printf("\tLa suma es: " + matUno.suma() + "\n\n");
                    break;

                case 3:
                    System.out.printf("\tLa suma de la diagonal es: " + matUno.suma(true) + "\n\n");
                    break;

                case 4:
                    System.out.printf("\tLa suma de todo sin diagonal es: " + matUno.suma(false) + "\n\n");
                    break;

                case 5:
                    int fila = 0;
                    Scanner sc2 = new Scanner(System.in);
                    System.out.printf("\tIntroduzca fila: ");
                    fila = sc2.nextInt();

                    System.out.printf("\tLa suma de la fila " + fila + " es: " + matUno.suma(fila) + "\n\n");
                    break;

                case 6:
                    int filaABorrar = 0;
                    Scanner sc3 = new Scanner(System.in);
                    System.out.printf("\tIntroduzca fila: ");
                    filaABorrar = sc3.nextInt();

                    System.out.println(matUno.borraFila(filaABorrar));
                    break;

                default:
                    System.out.printf("\t¡ERROR!\n");
                    break;
            }
        } while (opcion != 7);
    }
}
