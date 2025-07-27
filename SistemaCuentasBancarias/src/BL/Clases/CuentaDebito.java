package BL.Clases;

import java.util.Objects;

public class CuentaDebito extends CuentaBancaria {
    private double tasaInteres;

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public CuentaDebito() {
    }

    public CuentaDebito(String idCuenta, String tipoCuenta, double saldo, String cuentaActiva, Cliente cliente, double tasaInteres) {
        super(idCuenta, tipoCuenta, saldo, cuentaActiva, cliente);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public String toString() {
        return "CuentaDebito{" +
                "tasaInteres=" + tasaInteres +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CuentaDebito that = (CuentaDebito) o;
        return Double.compare(tasaInteres, that.tasaInteres) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tasaInteres);
    }
}
