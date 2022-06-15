package bol5_ej6.clases;

import java.util.Scanner;

public class Matriz {
    public int[][] matBidimensional;

    public Matriz(int n) {
        this.matBidimensional = new int[n][n];
        for (int i = 0; i < matBidimensional.length; i++) {
            for (int j = 0; j < matBidimensional[i].length; j++) {
                matBidimensional[i][j] = (int) (Math.random() * 10 + 0);
            }
        }
    }

    public static void muestraSuma(int[][] matrizBidimension) {
        int contador = -1;
        int contadorColumna = -1;

        for (int i = 0; i < matrizBidimension[0].length; i++) {
            contadorColumna += 1;
            System.out.printf("%9d", contadorColumna);
        }

        System.out.println();
        for (int[] fila : matrizBidimension) {
            contador += 1;
            System.out.print(contador);
            for (int columna : fila) {
                System.out.printf("%8d ", columna);
            }
            System.out.println();
        }
        System.out.println();
    }

    public int suma() {
        int sumar = 0;
        for (int i = 0; i < matBidimensional.length; i++) {
            for (int j = 0; j < matBidimensional[i].length; j++) {
                sumar += matBidimensional[i][j];
            }
        }
        return sumar;
    }

    public int suma(boolean parametro) {
        int i = 0;
        int j = 0;
        int suma = 0;
        if (parametro == true) {
            while (i < matBidimensional.length && j < matBidimensional[0].length) {
                suma += matBidimensional[i][j];
                i++;
                j++;
            }
        } else {
            suma = suma() - suma(true);
        }
        return suma;
    }

    public int suma(int fila) {
        int suma = 0;
        for (int i = 0; i < matBidimensional.length; i++) {
            for (int j = 0; j < matBidimensional[i].length; j++) {
                if (fila == i) {
                    suma += matBidimensional[i][j];
                }
            }
        }
        return suma;
    }

    public int borraFila(int filaABorrar) {
        for (int i = 0; i < matBidimensional.length; i++) {
            for (int j = 0; j < matBidimensional[i].length; j++) {
                filaABorrar = matBidimensional[i][j];
            }
        }
        return filaABorrar;
    }
}
