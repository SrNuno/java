import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String args[]) {

		System.out.print("\nEjercicio5:" + "\n");
		/*
		 * 5. Programa un conversor de temperaturas. Al usuario se le pide los grados
		 * Celsius y se le da dos opciones: Si los quiere convertir a Farenheit (1) o a
		 * Kelvin (2). Las opciones ser�n 1 y 2 para pedir tipo de conversi�n y 3 salir.
		 * Usa como plantilla el c�digo que hay en el apartado de la estructura
		 * do-while. El programa se repetir� hasta que se elija 3. Finalmente muestra el
		 * resultado de la conversi�n con 2 decimales. Usa doubles. Las funciones de
		 * conversi�n son:
		 * 
		 * K=C+273 F=1.8*C+32
		 */

		// Declaraci�n de variables
		double kelvin;
		double fahrenheit;
		double celsius;
		int opcion;
		Scanner l = new Scanner(System.in);

		// C�digo
		do {
			System.out.println("\tOpción 1: Conversión de Celsius-Kelvin");
			System.out.println("\tOpción 2: Conversión de Celsius-Fahrenheit");
			System.out.println("\tOpción 3: SALIR");
			System.out.println("Seleccione opción (1-3):");
			opcion = l.nextInt();

			switch (opcion) {
			case 1:
				System.out.print("Introduzca una temperatura de Celsius: ");
				celsius = l.nextDouble();

				kelvin = celsius + 273;

				System.out.printf("La temperatura en Kelvin es %.2f\n ", kelvin);
				break;

			case 2:
				System.out.print("Introduzca una temperatura de Celsius: ");
				celsius = l.nextDouble();

				fahrenheit = 1.8 * celsius + 32;

				System.out.printf("La temperatura en Fahrenheit es %.2f\n ", fahrenheit);
				break;

			case 3:
				System.out.print("Vuelva pronto ");
				break;

			default:
				System.out.print("\nOpción no válida\n");
				break;
			}

		} while (opcion != 3);
		l.close();
	}
}