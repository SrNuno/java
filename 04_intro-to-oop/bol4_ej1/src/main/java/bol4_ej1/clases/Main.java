package bol4_ej1.clases;

public class Main {
    public static void main(String[] args) {
        Geometria geometria1 = new Geometria(true, -5, 8);

        System.out.println("Es un " + geometria1.tipo() + " tiene de altura " + geometria1.getAltura() + " y de base "
                + geometria1.getBase());
    }
}
