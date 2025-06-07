package BL;

import java.time.LocalDate;

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

    @Override
    public String toString() {
        return "Transacciones{" +
                "fecha=" + fecha +
                ", monto=" + monto +
                ", idTransaccion=" + idTransaccion +
                ", tipoTransaccion='" + tipoTransaccion + '\'' +
                '}';
    }


}
