package bol3_ej8.clases;

import java.util.Scanner;

public class Main {
    /**
     * Hallar área de un rectángulo o triángulo
     * 
     * @param base    Numero asociado a la base
     * @param altura  Numero asociado a la altura
     * @param bandera Si es true realiza el área de un rectángulo y si es false
     *                realiza el área de un triángulo
     * @return Devuelve el área de la forma que el usuario quiere
     */

    public static double hallarArea(double base, double altura, boolean bandera) {
        double area;
        if (bandera == true) {
            area = base * altura;
        } else {
            area = (base * altura) / 2;
        }
        return area;
    }

    /**
     * Hallar área de un círculo
     * 
     * @param radio Distancia que hay entre un punto cualquiera de la circunferencia
     *              hasta su centro
     * @return Devuelve el área del círculo
     */

    public static double hallarAreaCirculo(double radio) {
        double areaCírculo;
        areaCírculo = Math.PI * Math.pow(radio, 2);
        return areaCírculo;
    }

    public static void main(String[] args) {
        int opcion;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Menú");
            System.out.println("----------------------------------");
            System.out.println("Área de un triángulo");
            System.out.println("Área de un rectángulo");
            System.out.println("Área de un cuadrado");
            System.out.println("Área de un círculo");
            System.out.println("Salir");
            System.out.printf("\tSeleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
            case 1:

                double b, alt;
                System.out.print("\tIntroduzca un número para la base: ");
                b = sc.nextInt();

                System.out.print("\tIntroduzca un número para la altura: ");
                alt = sc.nextInt();

                System.out.printf("\tEl área del rectángulo es: %.3f" , hallarArea(b, alt, true));
                System.out.println("\n");
                break;

            case 2:
                double base, altura;
                System.out.print("\tIntroduzca un número para la base: ");
                base = sc.nextInt();

                System.out.print("\tIntroduzca un número para la altura: ");
                altura = sc.nextInt();

                System.out.printf("\tEl área del triángulo es: %.3f" , hallarArea(base, altura, false));
                System.out.println("\n");
                break;

            case 3:
                double lado;
                System.out.print("\tIntroduzca un número para el lado: ");
                lado = sc.nextInt();

                System.out.printf("\tEl área del cuadrado es: %.3f", hallarArea(lado, lado, true));
                System.out.println("\n");
                break;

            case 4:
                double radio;
                System.out.print("\tIntroduzca un número para el radio del círculo: ");
                radio = sc.nextInt();

                System.out.printf("\tEl área del círculo es: %.3f", hallarAreaCirculo(radio));
                System.out.println("\n");
                break;

            case 5:
                System.out.println("Vuelva pronto");
                break;

            default:
                System.out.println("\tError, pruebe otra vez");
                System.out.println();
                break;
            }

        } while (opcion != 5);
        sc.close();
    }
}
