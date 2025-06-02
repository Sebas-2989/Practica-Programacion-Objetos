package BL;

public class Curso {
    private int codigo;
    private String nombre;
    private double costo;
    private String modalidad;
    private int cantidadCreditos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getCantidadCreditos() {
        return cantidadCreditos;
    }

    public void setCantidadCreditos(int cantidadCreditos) {
        this.cantidadCreditos = cantidadCreditos;
    }

    public Curso() {
    }

    public Curso(int codigo, String nombre, double costo, String modalidad, int cantidadCreditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costo = costo;
        this.modalidad = modalidad;
        this.cantidadCreditos = cantidadCreditos;
    }
}
