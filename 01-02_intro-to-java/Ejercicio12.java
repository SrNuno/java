import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        int opc;
        Scanner f = new Scanner(System.in);

        do {
            System.out.println("\tOpción 1: Los números del 1 al 50.");
            System.out.println("\tOpción 2: En orden inversa del 50 al 1 ");
            System.out.println(
                    "\tOpción 3: Los números pares menores que 20 por orden creciente (2, 4, 6, 8, ... 16, 18");
            System.out.println("\tOpción 4: Los números impares entre el 90 y el 130 por orden creciente");
            System.out.println(
                    "\tOpción 5: Los múltiplos de 5 entre el 70 y el 25 por orden decreciente (70, 65, ... 30,25).");
            System.out.println("\tOpción 6: Salir. El programa no debe acabar mientras no se pulse esta opción.");
            System.out.println("\tSeleccione opción (1-6):");
            opc = f.nextInt();

            switch (opc) {
            case 1:
                for (int contar = 1; contar <= 50; contar++) {
                    System.out.print(contar + " ");
                }
                System.out.println("\n");
                break;

            case 2:
                for (int cuenta = 50; cuenta >= 1; cuenta --) {
                    System.out.print(cuenta + " ");
                }
                System.out.println("\n");
                break;

            case 3:
                for (int conta = 2; conta < 20; conta += 2) {
                    System.out.print(conta + " ");
                }
                System.out.println("\n");
                break;

            case 4:
                for (int contarImpares = 90; contarImpares <= 130; contarImpares++) {
                    if (contarImpares % 2 != 0) {
                        System.out.print(contarImpares + " ");
                    }
                }
                System.out.println("\n");
                break;

            case 5:
                for (int contarMultiplos = 70; contarMultiplos >= 25; contarMultiplos -= 5) {
                     
                        System.out.print(contarMultiplos + " ");
                     
                }
                System.out.println("\n");
                break;

            case 6:

                break;

            default:
                System.out.print("Opción no válida\n");
                break;
            }

        } while (opc != 6);

        f.close();
    }

}
