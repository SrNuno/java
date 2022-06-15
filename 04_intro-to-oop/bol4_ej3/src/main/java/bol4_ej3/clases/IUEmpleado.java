package bol4_ej3.clases;

import java.util.Scanner;

public class IUEmpleado {
    public Empleado empleado;

    public IUEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    // Métodos creados
    public void pedir() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\n\t\tIntroduzca su nombre: ");
        empleado.setNombre(sc.nextLine());

        System.out.printf("\t\tIntroduzca sus apellidos: ");
        empleado.setApellidos(sc.nextLine());

        System.out.printf("\t\tIntroduzca su edad: ");
        empleado.setEdad(sc.nextInt());
        sc.nextLine();

        System.out.printf("\t\tIntroduzca su DNI: ");
        empleado.setDNI(sc.nextLine());

        System.out.printf("\t\tIntroduzca su salario anual: ");
        empleado.setSalario(sc.nextInt());
    }

    public void mostrar() {
        System.out.printf("\n\t\t\tEMPLEADO");
        System.out.printf("\n\t--------------------------------------------");
        System.out.printf("\n\tNombre: " + empleado.getNombre());
        System.out.printf("\n\tApellidos: " + empleado.getApellidos());
        System.out.printf("\n\tEdad: " + empleado.getEdad() + " años");
        System.out.printf("\n\tDNI: " + empleado.getDNI());
        System.out.printf("\n\tSalario: " + empleado.getSalario() + " euros");
        System.out.printf("\n\tIRPF: " + empleado.getIRPF());
        System.out.printf("\n\tDinero que se lleva Hacienda: " + empleado.dineroHacienda() + " euros\n");
    }

    public void mostrar(int campo) {
        switch (campo) {
            case 1:
                System.out.printf("\tNombre y Apellidos: " + empleado.getNombre() + " " + empleado.getApellidos());
                break;
            case 2:
                System.out.printf("\tEdad: " + empleado.getEdad() + "");
                break;
            case 3:
                System.out.printf("\tDNI: " + empleado.getDNI());
                break;
            case 4:
                System.out.printf("\tSalario: " + empleado.getSalario() + " euros e IRPF: " + empleado.getIRPF());
                break;
            case 5:
                System.out.printf("\tDinero que se lleva Hacienda: " + empleado.dineroHacienda() + " euros");
                break;
        }
    }
}
