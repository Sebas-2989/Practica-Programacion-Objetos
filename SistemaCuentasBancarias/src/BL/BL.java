package BL;

import DAO.ClienteDAO;
import DAO.CuentaBancariaDAO;
import DAO.TransaccionesDAO;

import java.util.ArrayList;

public class BL {
    
    private ClienteDAO clientedao = new ClienteDAO();
    private CuentaBancariaDAO cuentabancariaDAO = new CuentaBancariaDAO();
    private TransaccionesDAO transaccionesDAO = new TransaccionesDAO();

    public boolean registrarCliente(Cliente cliente) {
        boolean clienteAgregado = false;
        if (!existeCliente(cliente)) {
            clientedao.registrarCliente(cliente);
            clienteAgregado = true;
        }
        return clienteAgregado;
    }


    public boolean existeCliente(Cliente cliente) {
        Cliente encontrado = clientedao.buscarClientePorId(cliente.getIdCliente());
        return encontrado != null;
    }


    public boolean modificarCliente(Cliente cliente) {
        if (existeCliente(cliente)) {
            clientedao.modificarCliente(cliente);
            return true;
        }
        return false;
    }

    public ArrayList<Cliente> listarClientes() {
        return clientedao.listarClientes();
    }

    public boolean eliminarCliente(String idCliente) {
        if (clientedao.buscarClientePorId(idCliente) != null) {
            clientedao.eliminarCliente(idCliente);
            return true;
        }
        return false;
    }

    public boolean registrarCuenta(CuentaBancaria cuenta) {
        boolean cuentaAgregada = false;
        if (!existeCuenta(cuenta)) {
            cuentabancariaDAO.registrarCuenta(cuenta);
            cuentaAgregada = true;
        }
        return cuentaAgregada;
    }

    public boolean existeCuenta(CuentaBancaria cuenta) {
        CuentaBancaria encontrado = cuentabancariaDAO.buscarCuentaPorId(cuenta.getIdCuenta());
        return encontrado != null;
    }


    public boolean modificarCuenta(CuentaBancaria cuenta) {
        if (existeCuenta(cuenta)) {
            cuentabancariaDAO.modificarCuenta(cuenta);
            return true;
        }
        return false;
    }

    public ArrayList<CuentaBancaria> listarCuentas() {
        return cuentabancariaDAO.listarCuentas();
    }


    public boolean eliminarCuenta(String idCuenta) {
        if (cuentabancariaDAO.buscarCuentaPorId(idCuenta) != null) {
            cuentabancariaDAO.eliminarCuenta(idCuenta);
            return true;
        }
        return false;

    }

    public CuentaBancaria buscarCuentaPorId(String idCuenta) {
        CuentaBancaria cuenta = cuentabancariaDAO.buscarCuentaPorId(idCuenta);
        return cuenta;
    }


    public boolean retirarCuenta(Transacciones transaccion) {
        CuentaBancaria cuenta = transaccion.getCuentaBancaria();
        if (cuenta == null || !cuenta.getCuentaActiva()) {
            return false; // Cuenta no existe o está inactiva
        }
        double saldoActual = cuenta.getSaldo();
        double monto = transaccion.getMonto();

        // Reglas de negocio
        if (cuenta instanceof CuentaAhorro) {
            if (saldoActual - monto < 100) return false; // Siempre debe quedar al menos $100
        } else if (cuenta instanceof CuentaDebito) {
            if (saldoActual - monto < 0) return false; // Nunca saldo negativo
        } else if (cuenta instanceof CuentaCredito) {
            CuentaCredito credito = (CuentaCredito) cuenta;
            if (saldoActual - monto < credito.getLimiteCredito()) return false; // No puede exceder el límite 
            if (saldoActual - monto > 0) return false; // Nunca saldo positivo
        } else {
            return false; 
        }

        cuenta.setSaldo(saldoActual - monto);
        boolean actualizado = cuentabancariaDAO.modificarCuenta(cuenta);
        if (actualizado) {
            transaccionesDAO.registrarTransaccion(transaccion);
            return true;
        }
        return false;
    }


}
