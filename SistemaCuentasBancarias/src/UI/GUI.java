package UI;

import BL.BL;
import BL.Clases.Cliente;

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
    }

//     static void listarClientes()
//     {
//         out.println("Lista de Clientes");
//         for(Cliente client : bl.listarClientes())
//         {
//             out.println(client.toString());
//         }
//     }
//     public static void eliminarCliente() throws IOException {
//         out.print("ID Cliente a eliminar: ");
//         String id = in.readLine();
//         if (bl.eliminarCliente(id)) {
//             out.println("Cliente eliminado correctamente.");
//         } else {
//             out.println("Cliente no encontrado.");
//         }
//     }


}
