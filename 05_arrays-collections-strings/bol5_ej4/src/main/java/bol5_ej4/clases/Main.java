package bol5_ej4.clases;

import java.util.Scanner;

public class Main {
    /**
     * 
     * @param cadena Cadena necesaria que hay que introducir
     */

    public static void muestraEnLinea(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            System.out.printf(cadena.charAt(i) + "\n");
        }
    }

    public static String subCadena(String cadena, int posInicio, int cantCaracteres) {
        String cadenAuxiliar = "";
        if (posInicio >= 0 && posInicio < cadena.length() && cantCaracteres > 0 && cantCaracteres < cadena.length()) {
            for (int i = posInicio; i < cantCaracteres + posInicio; i++) {
                cadenAuxiliar += cadena.charAt(i);
            }
            return cadenAuxiliar;

        } else {
            return "Cadena vacía";
        }
    }

    public static void muestraCentrado(String cadena) {
        for (int i = 0; i < 40 - cadena.length() / 2; i++) {
            System.out.print(" ");
        }
        System.out.println(cadena);
    }

    public static char[] cadenaAVector(String cadena) {
        char[] vector = new char[cadena.length()];
        for (int i = 0; i < cadena.length(); i++) {
            vector[i] = cadena.charAt(i);
        }
        return vector;
    }

    public static String alReves(String cadena) {
        String cadenAuxiliar = "";
        for (int i = 0; i < cadena.length(); i++) {
            cadenAuxiliar = cadena.charAt(i) + cadenAuxiliar;
        }
        return cadenAuxiliar;
    }

    public static String pasoAMayusculas(String... cadena) {
        String cad = "";
        String cad2 = "";
        for (int i = 0; i < cadena.length; i++) {
            cad += cadena[i];
        }

        for (int j = 0; j < cad.length(); j++) {
            if (cad.charAt(j) >= 'a' && cad.charAt(j) <= 'z') {
                cad2 += (char) (cad.charAt(j) - 32);
            } else if (cad.charAt(j) == '_') {
                cad2 += " ";
            } else {
                cad2 += cad.charAt(j);
            }
        }
        return cad2;
    }

    public static void main(String[] args) {
        // String cadena1 = "Hola";
        // System.out.println("APARTADO A:");
        // muestraEnLinea(cadena1);

        System.out.printf("\nAPARTADO B:\n");
        String cadena2;
        int posIni, cantCaract;
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca una cadena: ");
        cadena2 = sc.nextLine();

        System.out.print("Introduzca un numero para la posición de inicio: ");
        posIni = sc.nextInt();

        System.out.print("Introduzca la cantidad de caracteres que quiere mostrar: ");
        cantCaract = sc.nextInt();

        System.out.println("La parte resultante es: " + subCadena(cadena2, posIni, cantCaract));
        sc.nextLine();

        // System.out.printf("\nAPARTADO C:\n");
        // String cadena3;
        // System.out.print("Introduzca una cadena: ");
        // cadena3 = sc.nextLine();

        // muestraCentrado(cadena3);
        // muestraCentrado(cadena1);

        // System.out.printf("\nAPARTADO D:\n");
        // System.out.println(cadenaAVector(cadena1));

        // System.out.printf("\nAPARTADO E:\n");
        // System.out.println(alReves(cadena1));

        // System.out.printf("\nAPARTADO F:\n");
        // System.out.println(pasoAMayusculas("Hola_gente_", "ADIOS_1234"));
    }
}
