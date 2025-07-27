package BL;

import BL.Clases.Cliente;
import BL.Clases.CuentaAhorro;
import java.util.ArrayList;
import java.util.List;

public class BL {
    private ArrayList<Cliente> clientes; 
    private ArrayList<CuentaAhorro> cuentasAhorro;

    public boolean registrarCliente(Cliente cliente) {
        boolean clienteAgregado=false;
    if (clientes==null){
        clientes=new ArrayList<>();
    }
    if(!existeCliente(cliente)){
        clientes.add(cliente);
        clienteAgregado=true;
    }
    return clienteAgregado;
    }

    
    public boolean existeCliente(Cliente cliente) {
        if (clientes == null) {
            return false;
        }
        for (Cliente miCliente : clientes) {
            if (miCliente.getIdCliente().equals(cliente.getIdCliente())) {
                return true;
            }
        }
        return false;
    }


    public boolean modificarCliente(Cliente cliente) {
        boolean modificado = false;
        for(Cliente client : clientes)
        {
            if(client.getIdCliente().equals(cliente.getIdCliente()))
            {
                client.setIdCliente(cliente.getCedula());
                client.setNombre(cliente.getNombre());
                client.setPrimerApellido(cliente.getPrimerApellido());
                client.setSegundoApellido(cliente.getSegundoApellido());
                client.setCedula(cliente.getCedula());
                client.setSexo(cliente.getSexo());
                client.setCorreoElectronico(cliente.getCorreoElectronico());
                client.setProfesion(cliente.getProfesion());                
                client.setDireccion(cliente.getDireccion());             
                modificado = true;
            }
        }
        return modificado;
    }




    public ArrayList<Cliente> listarClientes() {
        if (clientes == null) {
            clientes = new ArrayList<>();
        }
        return clientes;
    }

   
    public boolean eliminarCliente(String idCliente) {
        if (clientes == null) return false;
        return clientes.removeIf(cliente -> cliente.getIdCliente().equals(idCliente));
    }


    public boolean registrarCuentaAhorro(CuentaAhorro cuenta) {
        if (cuentasAhorro == null) {
            cuentasAhorro = new ArrayList<>();
        }
        for (CuentaAhorro cuent : cuentasAhorro) {
            if (cuent.getIdCuenta().equals(cuenta.getIdCuenta())) {
                return false;
            }
        }
        cuentasAhorro.add(cuenta);
        return true;
    }

public boolean modificarCuentaAhorro(CuentaAhorro cuenta) {
    if (cuentasAhorro == null) return false;
    for (CuentaAhorro cuent : cuentasAhorro) {
        if (cuent.getIdCuenta().equals(cuenta.getIdCuenta())) {
            cuent.setSaldo(cuenta.getSaldo());
            cuent.setCuentaActiva(cuenta.getCuentaActiva());
            cuent.setCliente(cuenta.getCliente());
       
            return true;
        }
    }
    return false;
}

    public boolean eliminarCuentaAhorro(String idCuenta) {
        if (cuentasAhorro == null) return false;
        return cuentasAhorro.removeIf(c -> c.getIdCuenta().equals(idCuenta));
    }

    public ArrayList<CuentaAhorro> listarCuentasAhorro() {
        if (cuentasAhorro == null) {
            cuentasAhorro = new ArrayList<>();
        }
        return cuentasAhorro;
    }

}
