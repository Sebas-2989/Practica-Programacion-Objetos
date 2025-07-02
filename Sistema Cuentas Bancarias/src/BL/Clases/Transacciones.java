package BL.Clases;

import java.time.LocalDate;
import java.util.Objects;

public class Transacciones {
    private LocalDate fecha;
    private double monto;
    private int idTransaccion;
    private String tipoTransaccion;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Transacciones() {
    }

    public Transacciones(LocalDate fecha, double monto, int idTransaccion, String tipoTransaccion) {
        this.fecha = fecha;
        this.monto = monto;
        this.idTransaccion = idTransaccion;
        this.tipoTransaccion = tipoTransaccion;
    }

    @Override
    public String toString() {
        return "Transacciones{" +
                "fecha=" + fecha +
                ", monto=" + monto +
                ", idTransaccion=" + idTransaccion +
                ", tipoTransaccion='" + tipoTransaccion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transacciones that = (Transacciones) o;
        return Double.compare(monto, that.monto) == 0 && idTransaccion == that.idTransaccion && Objects.equals(fecha, that.fecha) && Objects.equals(tipoTransaccion, that.tipoTransaccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, monto, idTransaccion, tipoTransaccion);
    }
}
