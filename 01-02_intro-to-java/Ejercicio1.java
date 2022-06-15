import java.util.Scanner;

	public class Ejercicio1 {
		public static void main (String args[]) {

		System.out.print("\nEjercicio1" + "\n");
		/* 1. */
		
		System.out.print("Apartado A):" + "\n");
		/* a) Realiza un programa que muestre los números del 1 al 20. Debes hacerlo con los 3 bucles (while, do_while y for) y un contador en cada bucle... */

		//Menú para elegir tipo de bucle: While, Do_While, For.
			int opcion;
			Scanner elegirOpcion = new Scanner (System.in);

		do{
			System.out.println("\tOpción 1: Bucle WHILE");
			System.out.println("\tOpción 2: Bucle DO_WHILE");
			System.out.println("\tOpción 3: Bucle FOR");
			System.out.println("Seleccione tOpción (1-3):");
			opcion = elegirOpcion.nextInt();

			switch (opcion) {
			case 1:
				//Declaración de variables
				int contador = 1;

				//Código --> Bucle while
				System.out.println("\nBucle utilizado: While");
				while (contador <= 20){
					System.out.printf("%5d\n",contador);
					contador++;
				}
				break;

			case 2:
				//Declaración de variables
				int conta = 1;

				//Código --> Bucle Do_While
				System.out.println("\nBucle utilizado: Do_While");
				do{
					System.out.printf("%5d\n",conta);
					conta++;
				} while (conta <= 20);

			break;

			case 3:
				//Código --> Bucle For
				System.out.println("\nBucle utilizado: For");
				for (int cont = 1; cont <= 20; cont++){
					System.out.printf("%5d\n",cont);
				}
			break;

			default:
				System.out.print("\nVuelve a intentarlo" + "\n");
			break;
			}
		} while (opcion >=4);

		/*b) En el mismo programa y con el bucle que prefieras, haz que muestre los números pares entre 1 y 50. Estos deben quedar bien formateados en una columna
		de tamaño 5 caracteres justificados a la derecha mediante printf. */

			System.out.print("\nApartado B):" + "\n");
			int nuevoContador = 0;
				while (nuevoContador <= 49){
				nuevoContador++;
					if (nuevoContador % 2 == 0) {
						System.out.printf("%5d\n",nuevoContador);
			}
		}
		elegirOpcion.close();
		
	}
}
