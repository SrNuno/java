import java.util.Scanner;

public class Ejercicio9 {
	public static void main(String args[]) {

		/*
		 * 9. Realizar un programa que muestre el máximo de una serie de números enteros
		 * leídos por teclado. Primero se debe pedir la cantidad de números a leer, tras
		 * lo cual se debe pedir un número tras otro y cuando se llegue a la cantidad
		 * indicada se debe mostrar cuál es el máximo de los introducidos.
		 */

		int numerosIntroducidos;
		int numero;
		int acumulador = 0;
		int contador = 0;
		int maximo = -2147483648;
		Scanner m = new Scanner(System.in);

		System.out.print("\n¿Cuantos números deseas introducir? ");
		numerosIntroducidos = m.nextInt();
		do {
			System.out.print("Introduce número: ");
			numero = m.nextInt();

			if (numero > maximo) {
				maximo = numero;
			}

			contador = contador + 1;
			acumulador = acumulador + contador;

		} while (numerosIntroducidos != contador);

		System.out.print("El número máximo introducido es el " + maximo);

		m.close();
	}
}