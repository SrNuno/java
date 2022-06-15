package bol4_ej2.clases;

public class Main {
    public static void main(String[] args) {
        Fecha fecha1 = new Fecha(8, -15, 2008);
        Fecha fecha2 = new Fecha(4, 8, 2005);

        System.out.println("PRIMERA FECHA");
        System.out.println("Fecha corta: " + fecha1.fechaFormateada(true));
        System.out.println("Fecha larga: " + fecha1.fechaFormateada(false));

        System.out.println("\nSEGUNDA FECHA");
        System.out.println("Fecha corta: " + fecha2.fechaFormateada(true));
        System.out.println("Fecha larga: " + fecha2.fechaFormateada(false));

        System.out.println("\nDIFERENCIA ENTRE AÑOS");
        if (fecha1.getAnho() < fecha2.getAnho()) {
            System.out.println("La diferencia entre " + fecha2.getAnho() + " y " + fecha1.getAnho() + " es: "
                    + Fecha.diferenciaFechas(fecha1, fecha2));
        } else {
            System.out.println("La diferencia entre " + fecha1.getAnho() + " y " + fecha2.getAnho() + " es: "
                    + Fecha.diferenciaFechas(fecha1, fecha2));
        }

    }
}
