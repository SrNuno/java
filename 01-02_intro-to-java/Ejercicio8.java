import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String args[]) {

		System.out.print("\nEjercicio8:" + "\n");
		/*
		 * 8. Realizar un programa que pida tres n�meros al usuario en tres variables
		 * distintas (no uses bucles) y muestre el mayor de los tres (si son iguales dos
		 * de ellos, o los tres muestra cualquiera de los m�ximos). Trata de hacerlo en
		 * la menor cantidad posible de comparaciones.
		 */

		// Declaraci�n de variables
		int num1;
		int num2;
		int num3;
		Scanner m = new Scanner(System.in);

		// Código
		System.out.print("\tIntroduzca un núm: ");
		num1 = m.nextInt();

		System.out.print("\tIntroduzca un segundo núm: ");
		num2 = m.nextInt();

		System.out.print("\tIntroduzca un último núm: ");
		num3 = m.nextInt();

		if (num1 >= num2 && num1 >= num3) {
			System.out.print("El número " + num1 + " es el mayor de los tres introducidos ");
		} else {
			if (num2 >= num3) {
				System.out.print("El número " + num2 + " es el mayor de los tres introducidos ");
			} else {
				System.out.print("El número " + num3 + " es el mayor de los tres introducidos ");
			}
		}
		m.close();
	}

}
