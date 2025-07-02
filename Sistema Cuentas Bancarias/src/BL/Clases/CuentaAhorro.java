
package BL.Clases;

import java.util.Objects;

public class CuentaAhorro extends CuentaBancaria {
    private double tasaInteres;

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public CuentaAhorro() {
    }

    public CuentaAhorro(String idCuenta, String tipoCuenta, double saldo, String cuentaActiva, Cliente cliente, double tasaInteres) {
        super(idCuenta, tipoCuenta, saldo, cuentaActiva, cliente);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "tasaInteres=" + tasaInteres +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CuentaAhorro that = (CuentaAhorro) o;
        return Double.compare(tasaInteres, that.tasaInteres) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tasaInteres);
    }
}