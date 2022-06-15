package bol5_ej1.clases;

import java.util.Scanner;

public class Main {
    public static int[] apartadoA(int n) {
        int[] array1 = new int[n];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 4001 + 1000);
        }
        return array1;
    }

    public static void apartadoB(int[] vector) {
        for (int item : vector) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static int apartadoC(int[] vector) {
        int variableAuxiliar = vector[0];
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > variableAuxiliar) {
                variableAuxiliar = vector[i];
            }
        }

        return variableAuxiliar;
    }

    public static int apartadoD(int[] vector) {
        int variableAuxiliar = vector[0];
        for (int item : vector) {
            if (item < variableAuxiliar) {
                variableAuxiliar = item;
            }
        }

        return variableAuxiliar;
    }

    public static boolean apartadoE(int[] vector, int a, int m) {
        int variableAuxiliar;
        if (a >= 0 && a <= vector.length - 1 && m >= 0 && m <= vector.length - 1) {
            variableAuxiliar = vector[a];
            vector[a] = vector[m];
            vector[m] = variableAuxiliar;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("APARTADO A:");
        apartadoB(apartadoA(5));

        System.out.printf("\n");
        System.out.println("APARTADO B:");
        int[] array1 = new int[5];
        for (int i = 0; i <= array1.length - 1; i++) {
            System.out.printf("Introduzca número para la posición %d: ", i);
            array1[i] = sc.nextInt();
        }

        apartadoB(array1);

        System.out.printf("\n");
        System.out.println("APARTADO C:");
        System.out.printf("El máximo es: " + apartadoC(array1) + "\n");

        System.out.printf("\n");
        System.out.println("APARTADO D:");
        System.out.printf("El mínimo es: " + apartadoD(array1) + "\n");

        System.out.printf("\n");
        System.out.println("APARTADO E:");

        System.out.println(apartadoE(array1, 0, 2));
        apartadoB(array1);

        sc.close();
    }
}
