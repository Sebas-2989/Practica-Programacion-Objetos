package UI;

import BL.BL;
import BL.Cliente;
import BL.CuentaBancaria;
import BL.CuentaAhorro;
import BL.CuentaCredito;
import BL.CuentaDebito;
import BL.Transacciones;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GUI {
    private BL bl = new BL();
    private JButton registrarClienteButton;
    public JPanel panel1;
    private JButton eliminarClienteButton;
    private JButton listarClientesButton;
    private JButton modificarClienteButton;
    private JButton registrarCuentaButton;
    private JButton modificarCuentaButton;
    private JButton eliminarCuentaButton;
    private JButton listarCuentasButton;
    private JButton retiroCuentaButton;
    private JButton pagoCuentaButton;
    private JButton depositoCuentaButton;
    private JButton abonoCuentaButton;


    public GUI() {
        registrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente();
                String id = JOptionPane.showInputDialog("Ingrese el ID del cliente:");
                cliente.setIdCliente(id);
                if (id == null) return;
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                cliente.setNombre(nombre);
                if (nombre == null) return;
                String primerApellido = JOptionPane.showInputDialog("Ingrese el primer apellido del cliente:");
                cliente.setPrimerApellido(primerApellido);
                if (primerApellido == null) return;
                String segundoApellido = JOptionPane.showInputDialog("Ingrese el segundo apellido del cliente:");
                cliente.setSegundoApellido(segundoApellido);
                if (segundoApellido == null) return;
                String cedula = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
                cliente.setCedula(cedula);
                if (cedula == null) return;
                String sexo = JOptionPane.showInputDialog("Ingrese el sexo del cliente:");
                cliente.setSexo(sexo);
                if (sexo == null) return;
                String correoElectronico = JOptionPane.showInputDialog("Ingrese el correo electrónico del cliente:");
                cliente.setCorreoElectronico(correoElectronico);
                if (correoElectronico == null) return;
                String profesion = JOptionPane.showInputDialog("Ingrese la profesión del cliente:");
                cliente.setProfesion(profesion);
                if (profesion == null) return;
                String direccion = JOptionPane.showInputDialog("Ingrese la dirección del cliente:");
                cliente.setDireccion(direccion);
                if (direccion == null) return;
                if (id.isEmpty() || nombre.isEmpty() || primerApellido.isEmpty() || segundoApellido.isEmpty() ||
                        cedula.isEmpty() || sexo.isEmpty() || correoElectronico.isEmpty() || profesion.isEmpty() || direccion.isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean exito = bl.registrarCliente(cliente);
                if (exito) {
                    JOptionPane.showMessageDialog(panel1, "Cliente registrado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(panel1, "Error: Cliente ya existe (ID repetida).");
                }
            }
        });

        modificarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente();
                String id = JOptionPane.showInputDialog("Ingrese el ID del cliente a modificar:");
                if (id == null) return;
                cliente.setIdCliente(id);
                String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente:");
                if (nombre == null) return;
                cliente.setNombre(nombre);
                String primerApellido = JOptionPane.showInputDialog("Ingrese el nuevo primer apellido del cliente:");
                if (primerApellido == null) return;
                cliente.setPrimerApellido(primerApellido);
                String segundoApellido = JOptionPane.showInputDialog("Ingrese el nuevo segundo apellido del cliente:");
                if (segundoApellido == null) return;
                cliente.setSegundoApellido(segundoApellido);
                String cedula = JOptionPane.showInputDialog("Ingrese la nueva cédula del cliente:");
                if (cedula == null) return;
                cliente.setCedula(cedula);
                String sexo = JOptionPane.showInputDialog("Ingrese el nuevo sexo del cliente:");
                if (sexo == null) return;
                cliente.setSexo(sexo);
                String correoElectronico = JOptionPane.showInputDialog("Ingrese el nuevo correo electrónico del cliente:");
                if (correoElectronico == null) return;
                cliente.setCorreoElectronico(correoElectronico);
                String profesion = JOptionPane.showInputDialog("Ingrese la nueva profesión del cliente:");
                if (profesion == null) return;
                cliente.setProfesion(profesion);
                String direccion = JOptionPane.showInputDialog("Ingrese la nueva dirección del cliente:");
                if (direccion == null) return;
                cliente.setDireccion(direccion);
                if (id.isEmpty() || nombre.isEmpty() || primerApellido.isEmpty() || segundoApellido.isEmpty() ||
                        cedula.isEmpty() || sexo.isEmpty() || correoElectronico.isEmpty() || profesion.isEmpty() || direccion.isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean modificado = bl.modificarCliente(cliente);
                if (modificado) {
                    JOptionPane.showMessageDialog(panel1, "Cliente modificado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(panel1, "Error: Cliente no encontrado.");
                }

            }
        });

        listarClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bl.listarClientes().isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "No hay clientes registrados.");
                    return;
                }
                StringBuilder listaClientes = new StringBuilder();
                for (Cliente client : bl.listarClientes()) {
                    listaClientes.append(client.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(panel1, listaClientes.toString(), "Clientes", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        eliminarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bl.listarClientes().isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "No hay clientes registrados.");
                    return;
                }
                String idCliente = JOptionPane.showInputDialog("Ingrese el ID del cliente a eliminar:");
                if (idCliente == null) return;
                boolean eliminado = bl.eliminarCliente(idCliente);
                if (eliminado) {
                    JOptionPane.showMessageDialog(panel1, "Cliente eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(panel1, "Error: Cliente no encontrado.");
                }
            }
        });

        registrarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CuentaBancaria cuenta = new CuentaBancaria();
                String idCuenta = JOptionPane.showInputDialog("Ingrese el ID de la cuenta:");
                String tipoCuenta = JOptionPane.showInputDialog("Tipo de cuenta (Ahorro/Debito/Credito):");
                String idCliente = JOptionPane.showInputDialog("ID del cliente propietario:");
                double saldo = Double.parseDouble(JOptionPane.showInputDialog("Saldo inicial:"));
                if ("Ahorro".equalsIgnoreCase(tipoCuenta) && saldo < 100) {
                JOptionPane.showMessageDialog(panel1, "El saldo inicial de una cuenta de ahorro debe ser al menos $100.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
                }   
                if ("Credito".equalsIgnoreCase(tipoCuenta) && saldo != 0) {
                JOptionPane.showMessageDialog(panel1, "El saldo inicial de una cuenta de crédito debe ser 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
                }
                boolean activa = JOptionPane.showConfirmDialog(panel1, "¿Cuenta activa?", "Estado", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        
                if ("Ahorro".equalsIgnoreCase(tipoCuenta)) {
                    cuenta = new CuentaAhorro();
                    ((CuentaAhorro) cuenta).setTasaInteres(Double.parseDouble(JOptionPane.showInputDialog("Tasa de interés:")));
                } else if ("Debito".equalsIgnoreCase(tipoCuenta)) {
                    cuenta = new CuentaDebito();
                    ((CuentaDebito) cuenta).setTasaInteres(Double.parseDouble(JOptionPane.showInputDialog("Tasa de interés:")));
                } else if ("Credito".equalsIgnoreCase(tipoCuenta)) {
                    cuenta = new CuentaCredito();
                    ((CuentaCredito) cuenta).setLimiteCredito(Double.parseDouble(JOptionPane.showInputDialog("Límite de crédito:")));
                } else {
                    JOptionPane.showMessageDialog(panel1, "Tipo de cuenta inválido.");
                    return;
                }
                cuenta.setIdCuenta(idCuenta);
                cuenta.setTipoCuenta(tipoCuenta);
                cuenta.setSaldo(saldo);
                cuenta.setCuentaActiva(activa);
                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente);
                cuenta.setCliente(cliente);

                boolean exito = bl.registrarCuenta(cuenta);
                if (exito) {
                    JOptionPane.showMessageDialog(panel1, "Cuenta registrada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(panel1, "Error: Cuenta ya existe (ID repetida).");
                }
            }
        });

        modificarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CuentaBancaria cuenta = new CuentaBancaria();
                String idCuenta = JOptionPane.showInputDialog("Ingrese el ID de la cuenta a modificar:");
                if (idCuenta == null) return;
                String tipoCuenta = JOptionPane.showInputDialog("Tipo de cuenta (Ahorro/Debito/Credito):");
                if (tipoCuenta == null || tipoCuenta.isEmpty()) return;
                Double saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo saldo de la cuenta:"));
                if (saldo == null) return;
                if ("Ahorro".equalsIgnoreCase(tipoCuenta) && saldo < 100) {
                JOptionPane.showMessageDialog(panel1, "El saldo de una cuenta de ahorro debe ser al menos $100.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
                }
                if ("Credito".equalsIgnoreCase(tipoCuenta) && saldo != 0) {
                JOptionPane.showMessageDialog(panel1, "El saldo inicial de una cuenta de crédito debe ser 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
                }                
                boolean cuentaActiva = JOptionPane.showConfirmDialog(panel1, "¿Cuenta activa?", "Estado", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                String idCliente = JOptionPane.showInputDialog("Ingrese el nuevo ID del cliente:");
                if (idCliente == null) return;
                if ("Ahorro".equalsIgnoreCase(tipoCuenta)) {
                    cuenta = new CuentaAhorro();
                    ((CuentaAhorro) cuenta).setTasaInteres(Double.parseDouble(JOptionPane.showInputDialog("Tasa de interés:")));
                } else if ("Debito".equalsIgnoreCase(tipoCuenta)) {
                    cuenta = new CuentaDebito();
                    ((CuentaDebito) cuenta).setTasaInteres(Double.parseDouble(JOptionPane.showInputDialog("Tasa de interés:")));
                } else if ("Credito".equalsIgnoreCase(tipoCuenta)) {
                    cuenta = new CuentaCredito();
                    ((CuentaCredito) cuenta).setLimiteCredito(Double.parseDouble(JOptionPane.showInputDialog("Límite de crédito:")));
                } else {
                    JOptionPane.showMessageDialog(panel1, "Tipo de cuenta inválido.");
                    return;
                }

                cuenta.setIdCuenta(idCuenta);
                cuenta.setTipoCuenta(tipoCuenta);
                cuenta.setSaldo(saldo);
                cuenta.setCuentaActiva(cuentaActiva);
                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente);
                cuenta.setCliente(cliente);

                if (idCuenta.isEmpty() || idCliente.isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                boolean modificado = bl.modificarCuenta(cuenta);
                if (modificado) {
                    JOptionPane.showMessageDialog(panel1, "Cuenta modificada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(panel1, "Error: Cuenta no encontrada.");
                }
            }
        });

        listarCuentasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bl.listarCuentas().isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "No hay cuentas registradas.");
                    return;
                }
                StringBuilder listaCuentas = new StringBuilder();
                for (CuentaBancaria cuenta : bl.listarCuentas()) {
                    listaCuentas.append(cuenta.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(panel1, listaCuentas.toString(), "Cuentas", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        eliminarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bl.listarCuentas().isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "No hay cuentas registradas.");
                    return;
                }
                String idCuenta = JOptionPane.showInputDialog("Ingrese el ID de la cuenta a eliminar:");
                if (idCuenta == null) return;
                boolean eliminado = bl.eliminarCuenta(idCuenta);
                if (eliminado) {
                    JOptionPane.showMessageDialog(panel1, "Cuenta eliminada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(panel1, "Error: Cuenta no encontrada.");
                }
            }
        });

        retiroCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transacciones transaccion = new Transacciones();
                String idTransaccion = JOptionPane.showInputDialog("Ingrese el ID de la transacción:");
                if (idTransaccion == null) return;
                String idCuenta = JOptionPane.showInputDialog("Ingrese el ID de la cuenta para retirar:");
                if (idCuenta == null) return;
                double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a retirar:"));
                if (monto <= 0) {
                    JOptionPane.showMessageDialog(panel1, "El monto debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                CuentaBancaria cuenta = bl.buscarCuentaPorId(idCuenta);
                if (cuenta == null) {
                    JOptionPane.showMessageDialog(panel1, "Cuenta no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                transaccion.setIdTransaccion(idTransaccion);
                transaccion.setMonto(monto);
                transaccion.setTipoTransaccion("Retiro");
                transaccion.setFecha(java.time.LocalDate.now());
                transaccion.setCuentaBancaria(cuenta);


                boolean exito = bl.retirarCuenta(transaccion);
                if (exito) {
                    JOptionPane.showMessageDialog(panel1, "Retiro realizado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(panel1, "Error: No se pudo realizar el retiro.");
                }
            }
        });













    }
}


