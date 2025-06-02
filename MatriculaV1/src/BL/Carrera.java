package BL;

public class Carrera {
    private int codigo;
    private String nombre;
    private int credito;
    private double duración;
    private String escuela;


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

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public double getDuración() {
        return duración;
    }

    public void setDuración(double duración) {
        this.duración = duración;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", credito=" + credito +
                ", duración=" + duración +
                ", escuela='" + escuela + '\'' +
                '}';
    }
}
