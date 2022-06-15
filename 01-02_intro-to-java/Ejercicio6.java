import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String args[]) {

		System.out.print("\nEjercicio6:" + "\n");
		/*
		 * 6. Realizar un men� con las opciones (los n�meros se piden en cada opci�n, es
		 * decir, en cada case): a) Cuadrado de un n�mero real. Se mostrar� con 2
		 * decimales de aproximaci�n b) Inverso de un n�mero (1/x). Se mostrar� con 4
		 * decimales de aproximaci�n. No se admite el 0 (vuelve a pedirlo hasta que se
		 * meta distinto de 0). c) Ra�z cuadrada de un n�mero. Debe mostrar el resultado
		 * con 3 decimales de aproximaci�n. No admite n�meros negativos (debe pedir
		 * n�mero hasta que se meta uno positivo o 0). Averigua en internet c�mo se haya
		 * la ra�z cuadrada en Java. d) Operaci�n AND a nivel de bit entre dos enteros.
		 * Resultado en hexadecimal. e) Operaci�n OR a nivel de bit entre dos enteros.
		 * Resultado en hexadecimal. f) Salir. El programa no debe acabar mientras no se
		 * pulse esta opci�n.
		 */

		// Declaraci�n de variables
		int opcion;
		Scanner q = new Scanner(System.in);

		// C�digo
		do {
			System.out.println("\tOpción 1: Cuadrado de un número real.");
			System.out.println("\tOpción 2: Inverso de un número.");
			System.out.println("\tOpción 3: Raíz cuadrada de un n�mero.");
			System.out.println("\tOpción 4: Operación AND a nivel de bit entre dos enteros.");
			System.out.println("\tOpción 5: Operación OR a nivel de bit entre dos enteros.");
			System.out.println("\tOpción 6: SALIR");
			System.out.println("\tSeleccione opción (1-6):");
			opcion = q.nextInt();

			switch (opcion) {
			case 1:
				int num1;

				System.out.print("\tIntroduzca un número: ");
				num1 = q.nextInt();
				double elevar = Math.pow(num1, 2);

				System.out.printf("\tEl cuadrado es %.2f\n\n", elevar);
				break;

			case 2:
				double numInvertir = 0;
				double invertir;

				do {
					System.out.print("\tIntroduzca un número: ");
					numInvertir = q.nextInt();
				} while (numInvertir == 0);

				invertir = 1 / numInvertir;
				System.out.printf("\tEl inverso es %.4f\n\n", invertir);
				break;

			case 3:
				double num2;

				do {
					System.out.print("\tIntroduzca un número: ");
					num2 = q.nextInt();
				} while (num2 < 0);

				double raizCuadrada = Math.sqrt(num2);
				System.out.printf("\tLa raíz es %.3f\n\n", raizCuadrada);
				break;

			case 4:
				int entero1;
				int entero2;
				int operacionAND;

				System.out.print("\tIntroduzca un número: ");
				entero1 = q.nextInt();

				System.out.print("\tIntroduzca otro número: ");
				entero2 = q.nextInt();

				operacionAND = entero1 & entero2;
				System.out.printf("\tLa operacion AND es %X\n\n", operacionAND);
				break;

			case 5:
				int entero3;
				int entero4;
				int operacionOR;

				System.out.print("\tIntroduzca un número: ");
				entero3 = q.nextInt();

				System.out.print("\tIntroduzca otro número: ");
				entero4 = q.nextInt();

				operacionOR = entero3 | entero4;
				System.out.printf("\tLa operacion OR es %X\n\n", operacionOR);
				break;

			case 6:
				System.out.print("Vuelva pronto");
				break;

			default:
				System.out.print("Opción no válida\n");
				break;
			}

		} while (opcion != 6);
		q.close();

	}
}