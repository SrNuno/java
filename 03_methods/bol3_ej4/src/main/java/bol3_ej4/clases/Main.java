package bol3_ej4.clases;

import java.util.Scanner;

public class Main {
    /**
     * Potencia de un numero
     * 
     * @param base      Numero que va a ser repetido
     * @param exponente Numero de veces que va ser repetida la base
     * @return Devuelve el resultado de la potencia
     */

    public static double potencia(float base, int exponente) {
        double poten = 1;
        if (exponente >= 0) {
            for (int i = 1; i <= exponente; i++) {
                poten *= base;
            }
        } else {
            for (int i = -1; i >= exponente; i--) {
                poten *= (1 / base);
            }
        }
        return poten;
    }

    /**
     * Mostrar en pantalla n potencias de un numero
     * 
     * @param numero    Numero que va a ser elevado
     * @param potencias Numero determinado de potencias que se van a mostrar
     */

    public static void apartadoB(int numero, int potencias) {
        int contador = 0;
        do {
            // potencia(numero, contador);
            contador = contador + 1;

            System.out.println("Numero " + numero + " y exponente " + contador + " = " + potencia(numero, contador));
        } while (contador != potencias);

    }

    public static void main(String[] args) {
        int num;
        int expo;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un numero");
        num = sc.nextInt();

        System.out.println("Introduzca un numero para el exponente");
        expo = sc.nextInt();

        System.out.println();
        System.out.println(potencia(num, expo));
        apartadoB(num, expo);

        sc.close();
    }
}
