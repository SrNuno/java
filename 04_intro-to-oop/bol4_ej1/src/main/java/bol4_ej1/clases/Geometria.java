package bol4_ej1.clases;

public class Geometria {
    public boolean figura;
    private float altura;
    private float base;

    public void setAltura(float altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            this.altura = 0;
        }
    }

    public float getAltura() {
        return altura;
    }

    public void setBase(float base) {
        if (base > 0) {
            this.base = base;
        } else {
            this.base = 0;
        }
    }

    public float getBase() {
        return base;
    }

    // Constructores creados
    public Geometria() {
        figura = false;
        altura = 2;
        base = 2;
    }

    public Geometria(float altura, float base) {
        figura = false;
        this.altura = altura;
        this.base = base;
    }

    public Geometria(boolean figura, float altura, float base) {
        this.figura = figura;
        setAltura(altura);
        setBase(base);
    }

    // Métodos creados
    public float area() {
        if (figura == true) {
            return base * altura;
        }
        return base * altura / 2;
    }

    public double perimetro() {
        if (figura == true) {
            return (base * 2) + (altura * 2);
        }
        return base + altura + diagonal();
    }

    public double diagonal() {
        return Math.sqrt(Math.pow(altura, 2) + Math.pow(base, 2));
    }

    public String tipo() {
        if (figura == true) {
            return "Rectángulo";
        }
        return "Triángulo";
    }
}
