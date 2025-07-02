
package UI;

import BL.BL;
import BL.Clases.Cliente;
import BL.Clases.CuentaAhorro;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;


public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static BL bl = new BL();

    public static void main(String[] args) throws IOException {
        int opcion = -1;
        do {
            opcion = mostrarMenu();
            procesarOpcion(opcion);
        } while (opcion != 0);
    }


    static int mostrarMenu() throws java.io.IOException {
        int opcion;
        opcion = 0;
        out.println("\n--- Menú Principal ---");
        out.println("1. Registrar cliente");
        out.println("2. Modificar cliente");
        out.println("3. Listar clientes");
        out.println("4. Eliminar cliente");
        out.println("5. Registrar cuenta de ahorro");
        out.println("6. Modificar cuenta de ahorro");
        out.println("7. Listar cuentas de ahorro");
        out.println("8. Eliminar cuenta de ahorro");
        out.println("0. Salir");
        out.print("Seleccione una opción: ");
        opcion = Integer.parseInt(in.readLine());
        return opcion;
    }

        static void procesarOpcion(int pOpcion) throws java.io.IOException {
        switch (pOpcion) {
            case 1:
                registrarCliente();
                break;
            case 2:
                modificarCliente();
                break;
            case 3:
                listarClientes();
                break;
            case 4:
                eliminarCliente();
                break;
//            case 5:
//                registrarCuentaAhorro();
//                break;
//            case 6:
//                modificarCuentaAhorro();
//                break;
//            case 7:
//                listarCuentasAhorro();
//                break;
//            case 8:
//                eliminarCuentaAhorro();
//                break;
            case 0:
                out.println("Programa terminado");
                break;
            default:
                out.println("Opcion inválida");
        }
    }

    static void registrarCliente() throws IOException {
        out.println("-- Registro de Cliente --");
        out.print("ID Cliente: ");
        String id = in.readLine();
        out.print("Nombre: ");
        String nombre = in.readLine();
        out.print("Primer Apellido: ");
        String pApellido = in.readLine();
        out.print("Segundo Apellido: ");
        String sApellido = in.readLine();
        out.print("Cédula: ");
        String cedula = in.readLine();
        out.print("Sexo: ");
        String sexo = in.readLine();
        out.print("Correo: ");
        String correo = in.readLine();
        out.print("Profesión: ");
        String profesion = in.readLine();
        out.print("Dirección: ");
        String direccion = in.readLine();
        
        Cliente cliente = new Cliente(id, nombre, pApellido, sApellido, cedula, sexo, correo, profesion, direccion);
        
        if (bl.registrarCliente(cliente)) {
            out.println("Cliente registrado correctamente.");
        } else {
            out.println("Error: Cliente ya existe (ID repetida).");
        }
    }

    static void listarClientes()
    {
        out.println("Lista de Clientes");
        for(Cliente client : bl.listarClientes())
        {
            out.println(client.toString());
        }
    }


    public static void modificarCliente() throws IOException {
    Cliente cliente = new Cliente();
    out.println("ID Cliente a modificar: ");
    cliente.setIdCliente(in.readLine());
    out.println("Digite el nombre del cliente: ");
    cliente.setNombre(in.readLine());
    out.println("Digite el primer apellido del cliente: ");
    cliente.setPrimerApellido(in.readLine());
    out.println("Digite el segundo apellido del cliente: ");
    cliente.setSegundoApellido(in.readLine());
    out.println("Digite el numero de cedula del cliente: ");
    cliente.setCedula(in.readLine());
    out.println("Digite el sexo del cliente: ");
    cliente.setSexo(in.readLine());
    out.println("Digite el correo del cliente: ");
    cliente.setCorreoElectronico(in.readLine());
    out.println("Digite la profesion del cliente");
    cliente.setProfesion(in.readLine());
    out.println("Digite la direccion del cliente");
    cliente.setDireccion(in.readLine());
        
    if (bl.modificarCliente(cliente))
        out.println("Cliente Modificado");
    else
        out.println("Cliente No Encontrado");
}


    public static void eliminarCliente() throws IOException {
        out.print("ID Cliente a eliminar: ");
        String id = in.readLine();
        if (bl.eliminarCliente(id)) {
            out.println("Cliente eliminado correctamente.");
        } else {
            out.println("Cliente no encontrado.");
        }
    }

  
 
}

