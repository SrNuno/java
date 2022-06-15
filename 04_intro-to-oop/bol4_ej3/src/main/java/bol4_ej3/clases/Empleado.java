package bol4_ej3.clases;

public class Empleado {
    private String nombre;
    private String apellidos;
    private int edad;
    private String dni;
    private double salarioAnual;
    private double irpf;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

    public String getDNI() {
        return dni;
    }

    public void setSalario(double salarioAnual) {
        this.salarioAnual = salarioAnual;
        if (salarioAnual < 6000) {
            irpf = 7.5;
        } else {
            if (salarioAnual < 30000) {
                irpf = 15;
            } else {
                irpf = 20;
            }
        }
    }

    public double getSalario() {
        return salarioAnual;
    }

    public double getIRPF() {
        return irpf;
    }

    // Constructores creados
    public Empleado() {
        this.nombre = "";
        this.apellidos = "";
        this.edad = 0;
        this.dni = "";
        this.salarioAnual = 0;
        this.irpf = 7.5;
    }

    public Empleado(String nombre, String apellidos, int edad, String dni, double salarioAnual) {
        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setDNI(dni);
        setSalario(salarioAnual);
    }

    // Métodos creados
    public double dineroHacienda() {
        return getSalario() * getIRPF() / 100;
    }
}
