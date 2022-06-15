import java.util.Scanner;

	public class Ejercicio7 {
		public static void main (String args[]) {
		
		System.out.print("\nEjercicio7:" + "\n");
		/* 7.Realizar un programa que acepte 5 n�meros del usuario y calcule y muestre su media (la media es la suma de los n�meros dividido entre 5). Al final debe permitir ejecutar 
		de nuevo el programa o salir del mismo.*/
		
		String opcion;
		Scanner l = new Scanner (System.in);
		
		do {
			double num1, media = 0;
			double acumula = 0;
			double contador = 0;
					
			do {
				System.out.print("\tIntroduzca un número: ");
				num1 = l.nextDouble();
				l.nextLine();
						
				if (num1 != 0) {
					contador = contador + 1;
				}
				acumula = acumula + num1;
				
			} while (num1 != 0);
					
			media = acumula / contador;
			System.out.print("\tLa media es: " +media+ "\n\n");	
			
			System.out.print("¿Desea salir S/N?");
			opcion = l.nextLine();
		} while (opcion.equals("n") || opcion.equals("N"));
		System.out.println("Vuelva pronto");
		l.close();
	}
}