public class Ejercicio11 {
	public static void main(String args[]) {
		int contador = 0;
		int acumulador = 0;

		do {
			contador = contador + 1;
			acumulador = acumulador + contador;
		} while (acumulador < 10000);

		System.out.println("El numero es: " +contador);
	}
}