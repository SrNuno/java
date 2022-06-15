package bol5_ej2.clases;

public class Main {
    public static char[][] ejercicioDos(int n, int m) {
        char[][] tabla = new char[n][m];

        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                tabla[i][j] = (char) (Math.random() * 24 + 'A');
            }
        }
        return tabla;
    }

    public static void apartadoB(char[][] tabla) { // foreach
        int contador = -1;
        for (char[] fila : tabla) {
            contador += 1;
            System.out.print("Fila " + contador + ": ");
            for (char letra : fila) {
                System.out.printf(letra + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static char apartadoC(char[][] tabla) {
        char variableAuxiliar = tabla[0][0];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                if (tabla[i][j] > variableAuxiliar) {
                    variableAuxiliar = tabla[i][j];
                }
            }
        }
        return variableAuxiliar;
    }

    public static char apartadoD(char[][] tabla) {// foreach
        char variableAuxiliar = tabla[0][0];
        for (char[] fila : tabla) {
            for (char letra : fila) {
                if (letra < variableAuxiliar) {
                    variableAuxiliar = letra;
                }
            }
        }
        return variableAuxiliar;
    }

    public static boolean apartadoE(char[][] tabla, int a, int m, int f, int g) {
        char variableAuxiliar;
        if (a >= 0 && a <= tabla.length - 1 && m >= 0 && m <= tabla[a].length - 1 && f >= 0 && f <= tabla.length - 1
                && g >= 0 && g <= tabla[f].length - 1) {
            variableAuxiliar = tabla[a][m];
            tabla[a][m] = tabla[f][g];
            tabla[f][g] = variableAuxiliar;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] array1 = {
                { 'A', 'B', 'C', 'D' },
                { 'E', 'F', 'G', 'H' },
                { 'I', 'J', 'K', 'L' },
        };

        System.out.println("APARTADO A:");
        System.out.println("Array aleatorio");
        apartadoB(ejercicioDos(3, 4));

        System.out.println("Array introducido");
        apartadoB(array1);

        System.out.printf("APARTADO C: \n");
        System.out.println("Máximo: " + apartadoC(array1));

        System.out.printf("\nAPARTADO D: \n");
        System.out.println("Mínimo: " + apartadoD(array1));

        System.out.printf("\nAPARTADO E: \n");
        System.out.println("Cambio: " + apartadoE(array1, 1, 1, 2, 2));
        apartadoB(array1);
    }
}
