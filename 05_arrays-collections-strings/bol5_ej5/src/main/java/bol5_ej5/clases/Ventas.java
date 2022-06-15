package bol5_ej5.clases;

import java.time.LocalDate;

public class Ventas {
    public int[] meses = new int[12];
    private int anho;

    public void setAnho(int anho) {
        LocalDate ano = LocalDate.now();
        int anhoActual = ano.getYear();

        if (anho < anhoActual) {
            this.anho = anho;
        } else {
            this.anho = anhoActual - 1;
        }
    }

    public int getAnho() {
        return anho;
    }

    /**
     * Año introducido
     * 
     * @param anho Año a introducir
     */

    public Ventas(int anho) {
        for (int i = 0; i < this.meses.length; i++) {
            this.meses[i] = (int) (Math.random() * 1001 + 0);
        }
        setAnho(anho);
    }

    /**
     * Media de valores
     * 
     * @return Devuelve la media de los valores del vector
     */

    public double media() {
        double suma = 0;
        for (int i = 0; i < meses.length; i++) {
            suma += meses[i];
        }
        return suma / meses.length;
    }

    /**
     * Muestra la gráfica con sus valores y #
     * 
     */

    public void grafica() {
        System.out.printf("Año: " + getAnho());
        for (int i = 0; i < meses.length; i++) {
            System.out.printf("\nMes%4d(%3d): ", i + 1, meses[i]);
            for (int j = 0; j <= meses[i] / 100; j++) {
                System.out.printf("#");
            }
        }
    }
}
