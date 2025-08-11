package DAO;

import BL.Configuracion;
import BL.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {

    Configuracion configuracion = new Configuracion();
    public void registrarCliente(Cliente cliente) {
        Connection conexion = null;
        try {
            Class.forName(configuracion.getClaseJDBC());
            String url = configuracion.getStringConexion();
            //Crear la conexion a la base de datos
            conexion = DriverManager.getConnection(url);
            //Crear las operaciones
            String query="insert into cliente(idCliente,NOMBRE,PRIMERAPELLIDO,SEGUNDOAPELLIDO,cedula,sexo,correoElectronico,profesion,direccion) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, cliente.getIdCliente());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getPrimerApellido());
            statement.setString(4, cliente.getSegundoApellido());
            statement.setString(5, cliente.getCedula());
            statement.setString(6, cliente.getSexo());
            statement.setString(7, cliente.getCorreoElectronico());
            statement.setString(8, cliente.getProfesion());
            statement.setString(9, cliente.getDireccion());
            statement.execute();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }


    public void modificarCliente(Cliente cliente) {
        Connection conexion = null;
        try {
            Class.forName(configuracion.getClaseJDBC());
            String url = configuracion.getStringConexion();
            //Crear la conexion a la base de datos
            conexion = DriverManager.getConnection(url);
            //Crear las operaciones
            String query="update cliente set nombre=?,primerapellido=?,segundoapellido=?,cedula=?,sexo=?,correoelectronico=?,profesion=?,direccion=? where idCliente=?";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getPrimerApellido());
            statement.setString(3, cliente.getSegundoApellido());
            statement.setString(4, cliente.getCedula());
            statement.setString(5, cliente.getSexo());
            statement.setString(6, cliente.getCorreoElectronico());
            statement.setString(7, cliente.getProfesion());
            statement.setString(8, cliente.getDireccion());
            statement.setString(9, cliente.getIdCliente());
            statement.execute();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }



    public void eliminarCliente(String idCliente) {
        Connection conexion = null;
        try {
            Class.forName(configuracion.getClaseJDBC());
            String url = configuracion.getStringConexion();
            //Crear la conexion a la base de datos
            conexion = DriverManager.getConnection(url);
            //Crear las operaciones
            String query="delete from cliente where idCliente=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, idCliente);
            statement.execute();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }


    public ArrayList<Cliente> listarClientes() {
        Connection conexion = null;
        ArrayList<Cliente> clientes = new ArrayList();
        try {
            Class.forName(configuracion.getClaseJDBC());
            String url = configuracion.getStringConexion();
            //Crear la conexion a la base de datos
            conexion = DriverManager.getConnection(url);
            //Crear las operaciones
            String query="select * from cliente";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getString("idCliente"));
                cliente.setNombre(resultSet.getString("NOMBRE"));
                cliente.setPrimerApellido(resultSet.getString("PRImerApellido"));
                cliente.setSegundoApellido(resultSet.getString("SegundoApellido"));
                cliente.setCedula(resultSet.getString("cedula"));
                cliente.setSexo(resultSet.getString("sexo"));
                cliente.setCorreoElectronico(resultSet.getString("CorreoElectronico"));
                cliente.setProfesion(resultSet.getString("profesion"));
                cliente.setDireccion(resultSet.getString("direccion"));
                clientes.add(cliente);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return clientes;
    }

    public Cliente buscarClientePorId(String idCliente) {
        if (idCliente == null || idCliente.isEmpty()) {
            return null;
        }
        Connection conexion = null;
        Cliente cliente = null;
        try {
            Class.forName(configuracion.getClaseJDBC());
            String url = configuracion.getStringConexion();
            //Crear la conexion a la base de datos
            conexion = DriverManager.getConnection(url);
            //Crear las operaciones
            String query="select * from cliente where idCliente=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, idCliente);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(resultSet.getString("idCliente"));
                cliente.setNombre(resultSet.getString("NOMBRE"));
                cliente.setPrimerApellido(resultSet.getString("PRImerApellido"));
                cliente.setSegundoApellido(resultSet.getString("SegundoApellido"));
                cliente.setCedula(resultSet.getString("cedula"));
                cliente.setSexo(resultSet.getString("sexo"));
                cliente.setCorreoElectronico(resultSet.getString("CorreoElectronico"));
                cliente.setProfesion(resultSet.getString("profesion"));
                cliente.setDireccion(resultSet.getString("direccion"));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return cliente;
    }


    // public Estudiante obtenerEstudiante(String cedula) {
    //     Connection conexion = null;
    //     Estudiante estudiante = new Estudiante();
    //     try {
    //         Class.forName(configuracion.getClaseJDBC());
    //         String url = configuracion.getStringConexion();
    //         //Crear la conexion a la base de datos
    //         conexion = DriverManager.getConnection(url);
    //         //Crear las operaciones
    //         String query="select * from estudiante where cedula=?";
    //         PreparedStatement statement = conexion.prepareStatement(query);
    //         statement.setString(1, cedula);
    //         ResultSet resultSet = statement.executeQuery();
    //         while(resultSet.next()) {
    //             estudiante.setCedula(resultSet.getString("cedula"));
    //             estudiante.setNombre(resultSet.getString("NOMBRE"));
    //             estudiante.setPrimerApellido(resultSet.getString("PRImerApellido"));
    //             estudiante.setSegundoApellido(resultSet.getString("SegundoApellido"));
    //             estudiante.setCorreoElectronico(resultSet.getString("CorreoElectronico"));
    //             estudiante.setFechaNacimiento(resultSet.getDate("fechanacimiento").toLocalDate());
    //             estudiante.setBecado(resultSet.getBoolean("Becado"));
    //         }

    //     }
    //     catch (Exception e) {
    //         System.out.println(e);
    //     }
    //     finally {
    //         try {
    //             conexion.close();
    //         } catch (SQLException e) {
    //             System.out.println(e);
    //         }
    //     }
    //     return estudiante;
    // }



}
