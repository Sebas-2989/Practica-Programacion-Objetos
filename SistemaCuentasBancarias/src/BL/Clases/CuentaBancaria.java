package BL.Clases;

import java.util.Objects;

public class CuentaBancaria {
    private String idCuenta;
    private String tipoCuenta;
    private double saldo;
    private String cuentaActiva;
    private Cliente cliente; //compo

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCuentaActiva() {
        return cuentaActiva;
    }

    public void setCuentaActiva(String cuentaActiva) {
        this.cuentaActiva = cuentaActiva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CuentaBancaria() {
    }

    public CuentaBancaria(String idCuenta, String tipoCuenta, double saldo, String cuentaActiva, Cliente cliente) {
        this.idCuenta = idCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.cuentaActiva = cuentaActiva;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "idCuenta='" + idCuenta + '\'' +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", saldo=" + saldo +
                ", cuentaActiva='" + cuentaActiva + '\'' +
                ", cliente=" + cliente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CuentaBancaria that = (CuentaBancaria) o;
        return Double.compare(saldo, that.saldo) == 0 && Objects.equals(idCuenta, that.idCuenta) && Objects.equals(tipoCuenta, that.tipoCuenta) && Objects.equals(cuentaActiva, that.cuentaActiva) && Objects.equals(cliente, that.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuenta, tipoCuenta, saldo, cuentaActiva, cliente);
    }
}
