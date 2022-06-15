import java.util.Scanner;

	public class Ejercicio2 {
		public static void main (String args[]) {
		
		System.out.print("\nEjercicio2:" + "\n");
		// 2. Realizar un programa que pida dos n�meros enteros al usuario y muestre el mayor de los dos o un mensaje de igualdad en caso de que sean iguales. 

		//Declaraci�n de variables
			int numero1, numero2;
			Scanner teclado = new Scanner (System.in);

		//C�digo
			System.out.print("\tIntroduzca un n�mero: ");
			numero1=teclado.nextInt();

			System.out.print("\tIntroduzca otro n�mero: ");
			numero2=teclado.nextInt();

			if (numero1 == numero2) {
				System.out.print("El n�mero " +numero1+ " es igual al n�mero " +numero2);
			} else {
			if (numero1 > numero2) {
				System.out.print("El n�mero " +numero1+ " es mayor que el n�mero " +numero2);
			} else {
				System.out.print("El n�mero " +numero2+ " es mayor que el n�mero " +numero1);
			}
		}
		
		//Tambi�n debe indicar si son m�ltiplos o no.
			int resto = numero1%numero2;
			int resto1= numero2%numero1;
				
			if(resto == 0 || resto1 == 0){
				System.out.print("\nLos n�meros " +numero1+ " y " +numero2+ " son m�ltiplos entre s�");
			} else {
				System.out.print("\nLos n�meros " +numero1+ " y " +numero2+ " NO son m�ltiplos entre s�");
			}
			
			teclado.close();

	}
}