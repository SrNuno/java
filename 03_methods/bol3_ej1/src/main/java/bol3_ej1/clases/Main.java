package bol3_ej1.clases;

public class Main {
    /**
     * Deja líneas en blanco
     * 
     * @param parametroN Número de líneas en blanco
     */

    public static void lineas(int parametroN) {
        for (int i = 0; i < parametroN; i++) {
            System.out.println();
        }
    }

    /**
     * Comprueba número si es par o impar
     * 
     * @param numero Numero a comprobar
     * @return Par = true e impar = false
     */

    public static boolean par(int numero) {
        if (numero % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comprueba si un numero es > 0
     * 
     * @param num Numero a comprobar
     * @return  P si es > o N si es <
     */

    public static char tercerApartado(int num) {
        return num > 0 ? 'P' : 'N';
    }

    public static void main(String[] args) {
        lineas(10);
        System.out.println(par(15));
        System.out.println(tercerApartado(15));
    }
}
