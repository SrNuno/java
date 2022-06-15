package bol4_ej2.clases;

public class Fecha {
    private int dia;
    private int mes;
    private int anho;

    public void setDia(int dia) {
        if (dia < 1 || dia > 31) {
            this.dia = 1;
        } else {
            this.dia = dia;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setMes(int mes) {
        if (mes < 1 || mes > 12) {
            this.mes = 1;
        } else {
            this.mes = mes;
        }
    }

    public int getMes() {
        return mes;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public int getAnho() {
        return anho;
    }

    // Constructores creados
    public Fecha() {
        this.dia = 17;
        this.mes = 6;
        this.anho = 2003;
    }

    public Fecha(int dia, int mes, int ano) {
        setDia(dia);
        setMes(mes);
        this.anho = ano;
    }

    // Métodos creados
    public String fechaFormateada(boolean tipoFecha) {
        String mes = "";
        if (tipoFecha == true) {
            return getDia() + "/" + getMes() + "/" + anho;
        }
        switch (getMes()) {
            case 1:
                mes = "Enero";
                break;

            case 2:
                mes = "Febrero";
                break;

            case 3:
                mes = "Marzo";
                break;

            case 4:
                mes = "Abril";
                break;

            case 5:
                mes = "Mayo";
                break;

            case 6:
                mes = "Junio";
                break;

            case 7:
                mes = "Julio";
                break;

            case 8:
                mes = "Agosto";
                break;

            case 9:
                mes = "Septiembre";
                break;

            case 10:
                mes = "Octubre";
                break;

            case 11:
                mes = "Noviembre";
                break;

            case 12:
                mes = "Diciembre";
                break;
        }
        return getDia() + " de " + mes + " de " + anho;
    }

    public static int diferenciaFechas(Fecha fecha1, Fecha fecha2) {
        return Math.abs(fecha2.anho - fecha1.anho);
    }
}
