package DAO;

import BL.*;

import java.sql.*;
import java.util.ArrayList;

public class CuentaBancariaDAO {
    private Configuracion configuracion = new Configuracion();

    public boolean registrarCuenta(CuentaBancaria cuenta) {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = clienteDAO.buscarClientePorId(cuenta.getCliente().getIdCliente());
            if (cliente == null) {
            System.out.println("No se puede crear la cuenta: el cliente no existe.");
            return false;
            }
            Class.forName(configuracion.getClaseJDBC());
            Connection conexion = DriverManager.getConnection(configuracion.getStringConexion());
            String query = "INSERT INTO cuentabancaria (idCuenta, tipoCuenta, saldo, cuentaActiva, idCliente, limiteCredito, tasaInteres) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, cuenta.getIdCuenta());
            statement.setString(2, cuenta.getTipoCuenta());
            statement.setDouble(3, cuenta.getSaldo());
            statement.setBoolean(4, cuenta.getCuentaActiva());
            statement.setString(5, cuenta.getCliente().getIdCliente());
            // Solo aplica para crédito
            if (cuenta instanceof CuentaCredito) {
                statement.setDouble(6, ((CuentaCredito) cuenta).getLimiteCredito());
            } else {
                statement.setDouble(6, 0.0);
            }
            // Solo aplica para ahorro/débito
            if (cuenta instanceof CuentaAhorro) {
                statement.setDouble(7, ((CuentaAhorro) cuenta).getTasaInteres());
            } else if (cuenta instanceof CuentaDebito) {
                statement.setDouble(7, ((CuentaDebito) cuenta).getTasaInteres());
            } else {
                statement.setDouble(7, 0.0);
            }
            statement.executeUpdate();
            conexion.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public CuentaBancaria buscarCuentaPorId(String idCuenta) {
        CuentaBancaria cuenta = null;
        try {
            Class.forName(configuracion.getClaseJDBC());
            Connection conexion = DriverManager.getConnection(configuracion.getStringConexion());
            String query = "SELECT * FROM cuentabancaria WHERE idCuenta=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, idCuenta);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String tipo = resultSet.getString("tipoCuenta");
                if ("Ahorro".equals(tipo)) {
                    cuenta = new CuentaAhorro();
                    ((CuentaAhorro) cuenta).setTasaInteres(resultSet.getDouble("tasaInteres"));
                } else if ("Debito".equals(tipo)) {
                    cuenta = new CuentaDebito();
                    ((CuentaDebito) cuenta).setTasaInteres(resultSet.getDouble("tasaInteres"));
                } else if ("Credito".equals(tipo)) {
                    cuenta = new CuentaCredito();
                    ((CuentaCredito) cuenta).setLimiteCredito(resultSet.getDouble("limiteCredito"));
                }
                cuenta.setIdCuenta(resultSet.getString("idCuenta"));
                cuenta.setTipoCuenta(tipo);
                cuenta.setSaldo(resultSet.getDouble("saldo"));
                cuenta.setCuentaActiva(resultSet.getBoolean("cuentaActiva"));

                // Asignar el cliente a la cuenta bancaria
                ClienteDAO clienteDAO = new ClienteDAO();
                String idCliente = resultSet.getString("idCliente");
                Cliente cliente = clienteDAO.buscarClientePorId(idCliente);
                cuenta.setCliente(cliente);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return cuenta;
    }

    public boolean modificarCuenta(CuentaBancaria cuenta) {
        try {
            Class.forName(configuracion.getClaseJDBC());
            Connection conexion = DriverManager.getConnection(configuracion.getStringConexion());
            String query = "UPDATE cuentabancaria SET saldo=?, cuentaActiva=?, limiteCredito=?, tasaInteres=? WHERE idCuenta=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setDouble(1, cuenta.getSaldo());
            statement.setBoolean(2, cuenta.getCuentaActiva());

            // Solo aplica para crédito
            if (cuenta instanceof CuentaCredito) {
                statement.setDouble(3, ((CuentaCredito) cuenta).getLimiteCredito());
            } else {
                statement.setDouble(3, 0.0);
            }

            // Solo aplica para ahorro/débito
            if (cuenta instanceof CuentaAhorro) {
                statement.setDouble(4, ((CuentaAhorro) cuenta).getTasaInteres());
            } else if (cuenta instanceof CuentaDebito) {
                statement.setDouble(4, ((CuentaDebito) cuenta).getTasaInteres());
            } else {
                statement.setDouble(4, 0.0);
            }

            statement.setString(5, cuenta.getIdCuenta());
            statement.executeUpdate();
            conexion.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean eliminarCuenta(String idCuenta) {
        try {
            Class.forName(configuracion.getClaseJDBC());
            Connection conexion = DriverManager.getConnection(configuracion.getStringConexion());
            String query = "DELETE FROM cuentabancaria WHERE idCuenta=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, idCuenta);
            statement.executeUpdate();
            conexion.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public ArrayList<CuentaBancaria> listarCuentas() {
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        try {
            Class.forName(configuracion.getClaseJDBC());
            Connection conexion = DriverManager.getConnection(configuracion.getStringConexion());
            String query = "SELECT * FROM cuentabancaria";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            ClienteDAO clienteDAO = new ClienteDAO(); 
            while (resultSet.next()) {
                String tipo = resultSet.getString("tipoCuenta");
                CuentaBancaria cuenta;
                if ("Ahorro".equals(tipo)) {
                cuenta = new CuentaAhorro();
                ((CuentaAhorro) cuenta).setTasaInteres(resultSet.getDouble("tasaInteres"));
                } else if ("Debito".equals(tipo)) {
                    cuenta = new CuentaDebito();
                    ((CuentaDebito) cuenta).setTasaInteres(resultSet.getDouble("tasaInteres"));
                } else if ("Credito".equals(tipo)) {
                    cuenta = new CuentaCredito();
                    ((CuentaCredito) cuenta).setLimiteCredito(resultSet.getDouble("limiteCredito"));
                } else {
                    continue;
                }
                cuenta.setIdCuenta(resultSet.getString("idCuenta"));
                cuenta.setSaldo(resultSet.getDouble("saldo"));
                cuenta.setCuentaActiva(resultSet.getBoolean("cuentaActiva"));

                // Asignar el cliente a la cuenta bancaria
                String idCliente = resultSet.getString("idCliente");
                Cliente cliente = clienteDAO.buscarClientePorId(idCliente);
                cuenta.setCliente(cliente);

                cuentas.add(cuenta);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return cuentas;
    }



}