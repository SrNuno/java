import java.util.Scanner;

	public class Ejercicio10 {
		public static void main (String args[]) {
			
		/*10. Realizar un programa que pida dos n�meros al usuario en sendas variables y luego intercambie el valor dichas variables. Finalmente mostrar� en pantalla ambas 
		variables. */
			
		int variable1;
		int variable2;
		
			
		Scanner m = new Scanner (System.in);
		
		System.out.print("\nIntroduzca un n�:  ");
		variable1 = m.nextInt();
		
		System.out.print("Introduzca otro n�:  ");
		variable2  = m.nextInt();
		
		int intercambio = 0;
		
		intercambio = variable1;
		variable1 = variable2;
		variable2 = intercambio;
		
		System.out.print("\nEl primer n�mero es: " +variable1);
		System.out.print("\nEl segundo n�mero es: " +variable2);

		m.close();
		}

		
	}