package BL.Clases;

import java.util.Objects;

public class CuentaCredito extends CuentaBancaria{
    private double limiteCredito;

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public CuentaCredito() {
    }

    public CuentaCredito(String idCuenta, String tipoCuenta, double saldo, String cuentaActiva, Cliente cliente, double limiteCredito) {
        super(idCuenta, tipoCuenta, saldo, cuentaActiva, cliente);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public String toString() {
        return "CuentaCredito{" +
                "limiteCredito=" + limiteCredito +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CuentaCredito that = (CuentaCredito) o;
        return Double.compare(limiteCredito, that.limiteCredito) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), limiteCredito);
    }
}
