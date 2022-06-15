package bol3_ej9.clases;

import java.util.Scanner;

public class Main {
    /**
     * Hallar el factorial de un número
     * 
     * @param numero El número el cual vamos a utilizar
     * @return Devuelve el factorial de ese número
     */

    public static long factorialNumero(long numero) {
        long factorial = 1;
        for (long i = numero; i > 0; i--) {
            factorial = factorial * i;
        }
        return factorial;
    }

    /**
     * Hallar Binomio de Newton
     * 
     * @param m Primer numero factorial
     * @param n Segundo numero factorial
     * @return Devuelve el resultado del binomio
     */

    public static long binomioNewton(long m, long n) {
        return factorialNumero(m) / (factorialNumero(n) * factorialNumero(m - n));
    }

    public static void main(String[] args) {
        long num1 = 1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("\tIntroduzca un número: ");
            num1 = sc.nextInt();

            if (num1 <= 0) {
                System.out.println("\tError, su número tiene que ser mayor que el 0");
            }

        } while (num1 <= 0);
        System.out.println("\tEl factorial de " + num1 + " es: " + factorialNumero(num1));

        System.out.println("-----------------------------------------------------------");
        System.out.println();

        // Apartado B --> Binomio de Newton
        long numero1 = 1;
        long numero2 = 1;
        do {
            System.out.print("\tIntroduzca un número: ");
            numero1 = sc.nextInt();

            System.out.print("\tIntroduzca otro número: ");
            numero2 = sc.nextInt();

        } while (numero1 < 0 || numero2 < 0 || numero1 < numero2);
        System.out.printf(
                "\tEl factorial de " + numero1 + " y " + numero2 + " es: " + binomioNewton(numero1, numero2));
        sc.close();

    }
}
