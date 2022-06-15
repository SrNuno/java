package bol5_ej5.clases;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String salir;
        int anhoElegido = 0;
        Scanner sc = new Scanner(System.in);

        if (args.length == 0) {
            do {
                System.out.printf("Introduzca un anho: ");
                anhoElegido = sc.nextInt();
                sc.nextLine();

                Ventas ventas = new Ventas(anhoElegido);
                ventas.grafica();
                System.out.printf("\nLa media es %.2f\n", ventas.media());

                System.out.println("-------------------------------------------");
                System.out.printf("¿Desea continuar? ");
                salir = sc.nextLine().toLowerCase();
                System.out.println();

            } while (salir.equals("si"));
            System.out.print("Vuelva pronto y gracias");

        } else {
            anhoElegido = Integer.parseInt(args[0]);
            Ventas ventas = new Ventas(anhoElegido);

            ventas.grafica();
            System.out.printf("\nLa media es %.2f\n", ventas.media());
        }
    }
}
