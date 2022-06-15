package bol3_ej3.clases;

import java.util.Scanner;

public class Main {
    
    /**
     * Saber si un año es bisiesto o no
     * 
     * @param año Para comprobar si es o no bisiesto
     * @return True = Bisiesto y False = NO Bisiesto
     */
    
    public boolean bisiesto(int año) {
        if (año % 4 == 0 && año % 100 != 0 || año % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int añoIntroducido;
        boolean j;
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Introduzca año");
            añoIntroducido = sc.nextInt();
            j = m.bisiesto(añoIntroducido);

            if (j == true) {
                System.out.println("El año es bisiesto");
            } else {
                System.out.println("El año no es bisiesto");
            }

        } while (añoIntroducido != 0);

        sc.close();
    }
}
