package bol4_ej3.clases;

import java.util.Scanner;

public class IUDirectivo {
    public Directivo directivo;

    public IUDirectivo(Directivo direct) {
        this.directivo = direct;
    }

    // Métodos creado
    public void pedirDirectivo() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\n\tIntroduzca su nombre: ");
        directivo.setNombre(sc.nextLine());

        System.out.printf("\tIntroduzca sus apellidos: ");
        directivo.setApellidos(sc.nextLine());

        System.out.printf("\tIntroduzca su edad: ");
        directivo.setEdad(sc.nextInt());
        sc.nextLine();

        System.out.printf("\tIntroduzca su DNI: ");
        directivo.setDNI(sc.nextLine());

        System.out.printf("\tIntroduzca su departamento: ");
        directivo.setDepartamento(sc.nextLine());

        System.out.printf("\tIntroduzca un porcentaje de beneficios: ");
        directivo.setPorcentajeBeneficios(sc.nextInt());
        sc.nextLine();
    }

    public void mostrarDirectivo() {
        System.out.printf("\n\t\t\tDIRECTIVO");
        System.out.printf("\n\t--------------------------------------------");
        System.out.println("\n\tNombre: " + directivo.getNombre());
        System.out.println("\tApellidos: " + directivo.getApellidos());
        System.out.println("\tEdad: " + directivo.getEdad() + " años");
        System.out.println("\tDNI: " + directivo.getDNI());
        System.out.println("\tDepartamento: " + directivo.getDepartamento());
        System.out.println("\tPorcentaje de beneficios: " + directivo.getPorcentajeBeneficios() + "%");
    }

    public void mostrarDirectivo(int campo) {
        switch (campo) {
            case 1:
                System.out
                        .printf("\t\tNombre y Apellidos: " + campo + directivo.getNombre() + directivo.getApellidos());
                break;
            case 2:
                System.out.println("Edad: " + campo + directivo.getEdad());
                break;
            case 3:
                System.out.println("DNI: " + campo + directivo.getDNI());
                break;
            case 4:
                System.out.println("Departamento: " + campo + directivo.getDepartamento());
                break;
            case 5:
                System.out.println("Porcentaje de Beneficios: " + campo + directivo.getPorcentajeBeneficios());
                break;
        }
    }
}