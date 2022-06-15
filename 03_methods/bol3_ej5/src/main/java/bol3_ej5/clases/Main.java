package bol3_ej5.clases;

import java.util.Scanner;

public class Main {
    /**
     * Suma de potencias
     * 
     * @param x Base de la potencia
     * @param y Exponente de la potencia
     * @return Devuelve el resultado de la suma de potencias
     */

    public static double sumaPotencias(float x, int y) {
        double acumulador = 1;
        int contador = 0;
        do {
            contador = contador + 1;
            //acumulador = acumulador + bol3_ej4.clases(x, contador);
        } while (contador != y);
        return acumulador;
    }

    public static void main(String[] args) {
        float numero;
        int variableSecundaria;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un numero");
        numero = sc.nextInt();

        System.out.println("Introduzca un numero para el exponente");
        variableSecundaria = sc.nextInt();
        System.out.println();

        System.out.println(sumaPotencias(numero, variableSecundaria));
        sc.close();

    }
}
