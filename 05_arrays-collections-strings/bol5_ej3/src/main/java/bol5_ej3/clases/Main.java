package bol5_ej3.clases;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static ArrayList<Integer> apartadoA(int n) {
        ArrayList<Integer> creaColeccion = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            creaColeccion.add((int) (Math.random() * 4001 + 1000));
        }
        return creaColeccion;
    }

    public static void apartadoB(ArrayList<Integer> coleccion) {
        for (int item : coleccion) {
            System.out.println(item + " ");
        }
        System.out.println();
    }

    public static int apartadoC(ArrayList<Integer> coleccion) {
        int variableAuxiliar = coleccion.get(0);
        for (int i = 0; i < coleccion.size(); i++) {
            if (coleccion.get(i) > variableAuxiliar) {
                variableAuxiliar = coleccion.get(i);
            }

        }
        return variableAuxiliar;
    }

    public static int apartadoD(ArrayList<Integer> coleccion) {
        int variableAuxiliar = coleccion.get(0);
        for (int item : coleccion) {
            if (item < variableAuxiliar) {
                variableAuxiliar = item;
            }
        }
        return variableAuxiliar;
    }

    public static boolean apartadoE(ArrayList<Integer> coleccion, int a, int m) {
        if (a >= 0 && a < coleccion.size() && m >= 0 && m < coleccion.size()) {
            Collections.swap(coleccion, a, m);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(500);
        numeros.add(4);
        numeros.add(8);
        numeros.add(10);

        System.out.println("APARTADO A Y B:");
        System.out.printf("Colección ALEATORIA:\n");
        apartadoB(apartadoA(10));

        System.out.printf("Colección NUEVA:\n");
        apartadoB(numeros);

        System.out.println("APARTADO C:");
        System.out.printf("El máximo es: " + apartadoC(numeros) + "\n\n");

        System.out.println("APARTADO D:");
        System.out.printf("El mínimo es: " + apartadoD(numeros) + "\n\n");

        System.out.print("APARTADO E: ");
        System.out.print(apartadoE(numeros, 1, 2));
        System.out.printf("\nCambio de valores:\n");
        apartadoB(numeros);
    }
}
