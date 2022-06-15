package bol3_ej7.clases;

import java.util.Scanner;

public class Main {
    /**
     * Comprobación de números
     * 
     * @param numero1 Primer número a comprobar
     * @param numero2 Segundo número a comprobar
     * @return Devuelve 0 si el primero es mayor, 1 si son iguales y 2 si el primero
     *         es menor
     */

    public static int comprobarNumero(int numero1, int numero2) {
        if (numero1 < numero2) {
            return 0;
        }
        if (numero1 == numero2) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * Introducción de datos
     * 
     * @return Devuelve el dato introducido si está entre el rango 1-100 y sino
     *         devuelve "Error"
     */

    public static int introducirDato() {
        int dato;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduzca un número: ");
            dato = sc.nextInt();
            if (dato < 1 || dato > 100) {
                System.out.println("Número erróneo");
            }
        } while (dato < 1 || dato > 100);
        return dato;
    }

    /**
     * Muestra en pantalla
     * 
     * @param valor1 Primer número mostrado
     * @param valor2 Segundo número mostrado
     */

    public static void mostrarPantalla(int valor1, int valor2) {
        switch (comprobarNumero(valor1, valor2)) {
        case 0:
            System.out.println("El primero es menor");
            break;

        case 1:
            System.out.println("Enhorabuena, has acertado");
            break;

        case 2:
            System.out.println("El primero es mayor");
            break;
        }
    }

    /**
     * Muestra los intentos hasta averiguar el primer número/número aleatorio
     * 
     * @param num1 Número que hay que acertar
     */

    public static void funcionIntentos(int num1) {
        int contador2 = 0;
        int num2 = 0;
        do {
            num2 = introducirDato();
            contador2++;
            mostrarPantalla(num1, num2);
            System.out.println("Número de intentos = " + contador2);
        } while (num1 != num2 && contador2 < 5);

        if (num1 != num2){
            System.out.println("El número a adivinar era el " +num1);
        }
        
    }

    public static void main(String[] args) {
        int opcionJugadores, num1;
        String opcion;
        System.out.println("1 jugador");
        System.out.println("2 jugadores");
        System.out.printf("\tSeleccione cuantos jugadores van a jugar: ");
        Scanner sc = new Scanner(System.in);
        opcionJugadores = sc.nextInt();

        do {
            switch (opcionJugadores) {
            case 1:
                System.out.println("1 jugador");
                num1 = (int) (Math.random() * 100 + 1);
                funcionIntentos(num1);
                break;

            case 2:
                System.out.println("2 jugadores");
                num1 = introducirDato();
                funcionIntentos(num1);
                break;

            default:
                System.out.println("Error");
                break;
            }

            sc.nextLine();
            System.out.print("¿Desea salir S/N?");
            opcion = sc.nextLine();
        } while (opcion.equals("n") || opcion.equals("N"));
        System.out.println("Vuelva pronto");
        sc.close();
    }
}
