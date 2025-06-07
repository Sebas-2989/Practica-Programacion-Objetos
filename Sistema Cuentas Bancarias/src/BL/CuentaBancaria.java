package BL;

public class CuentaBancaria {
    private String idCuenta;
    private String tipoCuenta;
    private double saldo;
    private String cuentaActiva;

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


    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "idCuenta='" + idCuenta + '\'' +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", saldo=" + saldo +
                ", cuentaActiva='" + cuentaActiva + '\'' +
                '}';
    }
}
