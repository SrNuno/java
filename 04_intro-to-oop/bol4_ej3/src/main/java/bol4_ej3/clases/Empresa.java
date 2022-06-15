package bol4_ej3.clases;

public class Empresa {
    private double ganancias;
    public Directivo directivo;
    public Empleado empleadoUno;
    public Empleado empleadoDos;
    public IUEmpleado iuEmpleadoUno;
    public IUEmpleado iuEmpleadoDos;
    public IUDirectivo iuDirectivo;

    public void setGanancias(double ganan) {
        this.ganancias = ganan;
    }

    public double getGanancias() {
        return ganancias;
    }

    // Constructores
    public Empresa() {
        empleadoUno = new Empleado();
        empleadoDos = new Empleado();
        directivo = new Directivo();
        iuEmpleadoUno = new IUEmpleado(empleadoUno);
        iuEmpleadoDos = new IUEmpleado(empleadoDos);
        iuDirectivo = new IUDirectivo(directivo);
    }

    public Empresa(double gananciaEmpresa, Empleado empleadoUno, Empleado empleadoDos, Directivo directivo) {
        this.empleadoUno = empleadoUno;
        this.empleadoDos = empleadoDos;
        this.directivo = directivo;
        setGanancias(gananciaEmpresa);
        iuEmpleadoUno = new IUEmpleado(empleadoUno);
        iuEmpleadoDos = new IUEmpleado(empleadoDos);
        iuDirectivo = new IUDirectivo(directivo);
    }
}
