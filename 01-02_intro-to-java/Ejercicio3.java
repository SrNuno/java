import java.util.Scanner;

	public class Ejercicio3 {
		public static void main (String args[]) {
			
		System.out.print("\nEjercicio3:" + "\n");
		/* 3. Haz un programa que pida un n�m al usuario. Si es positivo realiza mediante un bucle, un contador y un acumulador, que haga la suma de n�meros desde el 1 hasta
			el que meti� el usuario. Finalmente muestra dicha suma final. Si el n�mero es negativo o 0 no hace nada. */
			
		//Declaraci�n de variables
			int numero3;
			int acumula = 0;
			int cont = 1;
			Scanner c = new Scanner (System.in);

		//C�digo
			do {
				System.out.print("\tIntroduzca un n�mero positivo: ");
				numero3=c.nextInt();
			} while (0 > numero3);

			do {
				cont = cont + 1;
				acumula = acumula + cont;
			} while (cont <= numero3);
			System.out.print("\tLa suma del n�mero " +numero3+ " es de " +cont+ " n�meros");
			c.close();
			
		}
	}