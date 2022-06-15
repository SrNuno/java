package bol3_ej6.clases;

import java.util.Scanner;

public class Main {
    /**
     * Comprobar si es primo o no
     * 
     * @param numero Número a comprobar si es primo o no
     * @return Devuelve true si es primo y false si no lo es
     */

    public static boolean numeroPrimo(int numero) {
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int i = 2; i < numero / 2; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numero;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca un número: ");
        numero = sc.nextInt();
        System.out.println("Los números primos son los siguientes:");
        int contador = 0;

        do {

            if (numeroPrimo(contador) == true) {
                System.out.println(contador);
            }
            contador++;
        } while (contador <= numero);
        sc.close();
    }
}
