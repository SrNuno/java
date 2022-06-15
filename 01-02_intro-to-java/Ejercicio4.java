import java.util.Scanner;

	public class Ejercicio4 {
		public static void main (String args[]) {
		
		System.out.print("\nEjercicio4:" + "\n");
		/*4. Haz un programa que pida un n�m entero al usuario y luego un n�mero real. El entero debe mostrarlo en decimal, en octal ocupando 5 caracteres y rellenando los vac�os a la
		izquierda con ceros y en hexadecimal poniendo los d�gitos "letra" en may�scula. El real lo mostrar� con 3 decimales y ocupando al menos 7 caracteres.*/
		
		//Declaraci�n de variables
			int numEntero;
			float numReal;
			Scanner j = new Scanner (System.in);
		
		//C�digo
			System.out.print("\tIntroduzca un n�mero: ");
			numEntero = j.nextInt();
		
			System.out.print("\tIntroduzca otro n�mero: ");
			numReal = j.nextFloat();
			
			System.out.printf("%d\n%05o\n%X\n%7.3f\n",numEntero,numEntero,numEntero,numReal);
			j.close();
		}
	}
	