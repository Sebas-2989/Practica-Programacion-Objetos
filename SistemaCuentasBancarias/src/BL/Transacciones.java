package BL;

import java.time.LocalDate;
import java.util.Objects;

public class Transacciones {
    private LocalDate fecha;
    private double monto;
    private String idTransaccion;
    private String tipoTransaccion;
    private CuentaBancaria cuentaBancaria;

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

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Transacciones() {
    }

    public Transacciones(LocalDate fecha, double monto, String idTransaccion, String tipoTransaccion, CuentaBancaria cuentaBancaria) {
        this.fecha = fecha;
        this.monto = monto;
        this.idTransaccion = idTransaccion;
        this.tipoTransaccion = tipoTransaccion;
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public String toString() {
        return "Transacciones{" +
                "fecha=" + fecha +
                ", monto=" + monto +
                ", idTransaccion='" + idTransaccion + '\'' +
                ", tipoTransaccion='" + tipoTransaccion + '\'' +
                ", cuentaBancaria=" + cuentaBancaria +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transacciones that = (Transacciones) o;
        return Double.compare(monto, that.monto) == 0 && Objects.equals(fecha, that.fecha) && Objects.equals(idTransaccion, that.idTransaccion) && Objects.equals(tipoTransaccion, that.tipoTransaccion) && Objects.equals(cuentaBancaria, that.cuentaBancaria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, monto, idTransaccion, tipoTransaccion, cuentaBancaria);
    }
}
