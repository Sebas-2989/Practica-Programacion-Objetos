package DAO;

import BL.*;

import java.sql.*;
import java.util.ArrayList;


public class TransaccionesDAO {
    private Configuracion configuracion = new Configuracion();


    public boolean registrarTransaccion(Transacciones transaccion) {
        try {
            Class.forName(configuracion.getClaseJDBC());
            Connection conexion = DriverManager.getConnection(configuracion.getStringConexion());
            String query = "INSERT INTO transacciones (idTransaccion, tipoTransaccion, monto, fecha, idCuenta) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, transaccion.getIdTransaccion());
            statement.setString(2, transaccion.getTipoTransaccion());
            statement.setDouble(3, transaccion.getMonto());
            statement.setDate(4, java.sql.Date.valueOf(transaccion.getFecha()));
            statement.setString(5, transaccion.getCuentaBancaria().getIdCuenta());
            statement.executeUpdate();
            conexion.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
