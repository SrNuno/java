package bol3_ej2.clases;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    /**
     * Pedir un número
     * 
     * @return Devuelve el número introducido
     */
    public double pedirDato() {
        double num;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduzca un número positivo: ");
            num = sc.nextDouble();
        } while (0 > num);
        return num;
    }

    /**
     * Calcular superficie de un cilindro
     * 
     * @param radio  Numero del radio
     * @param altura Número de la altura
     * @return Devuelve el cálculo de la superficie del cilindro
     */

    public double calcSuperficie(double radio, double altura) {
        double PIValue = Double.parseDouble(String.format(Locale.US, "%.25f", Math.PI));
        double calc = (2 * PIValue * radio * altura);
        return calc;
    }

    /**
     * Mostrar dato por pantalla con 3 decimales
     * 
     * @param parametro Numero que se va a mostrar
     */

    public void mostrarDato(double parametro) {
        System.out.printf("%.3f", parametro);
    }

    public static void main(String[] args) {
        Main m = new Main();
        double num1 = m.pedirDato();
        double num2 = m.pedirDato();

        m.mostrarDato(m.calcSuperficie(num1, num2));
    }
}
