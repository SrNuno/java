package bol4_ej3.clases;

public class Directivo {
    private String nombre;
    private String apellidos;
    private int edad;
    private String dni;
    private String departamento;
    private float porcentajeBeneficios;

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

    public void setDepartamento(String departamento) {
        this.departamento = departamento.toUpperCase();
    }

    public String getDepartamento() {
        // Se puede utilizar String.format("\"%s\"", departamento);
        return "\"" + departamento + "\"";
    }

    public void setPorcentajeBeneficios(float porcentajeBeneficios) {
        if (porcentajeBeneficios > 0 && porcentajeBeneficios <= 100) {
            this.porcentajeBeneficios = porcentajeBeneficios;
        } else {
            this.porcentajeBeneficios = 0;
        }
    }

    public float getPorcentajeBeneficios() {
        return porcentajeBeneficios;
    }

    // Constructores creados
    public Directivo() {
        this.nombre = "";
        this.apellidos = "";
        this.edad = 0;
        this.dni = "";
        this.departamento = "";
        this.porcentajeBeneficios = 0;
    }

    public Directivo(String nombre, String apellidos, int edad, String dni, String departamento,
            float porcentajeBeneficios) {
        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setDNI(dni);
        setDepartamento(departamento);
        setPorcentajeBeneficios(porcentajeBeneficios);
    }

    // Métodos creados
    public double gananciaEmpresa(double dinGlobalEmp) {
        double calculo = (getPorcentajeBeneficios() / 100) * dinGlobalEmp;
        if (calculo > 0) {
            return calculo;
        } else {
            return 0;
        }
    }
}
