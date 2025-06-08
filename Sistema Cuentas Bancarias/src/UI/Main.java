package UI;

import BL.Administrador;
import BL.Cliente;
import BL.CuentaBancaria;
import BL.Transacciones;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {


        Administrador admin = new Administrador("Pedro", "Araya", "Perez", "110145643", "ejemplo@cenfotec.ac.cr");
        Cliente cliente1 = new Cliente("CL001", "Laura", "Hernández", "Ramírez", "203040506", "Femenino", "laura.hrz@example.com", "Ingeniera Civil", "San José, Costa Rica");
        CuentaBancaria cuenta1 = new CuentaBancaria( "CT001", "Ahorro", 150.00, "Activa");
        Transacciones transacciones1 = new Transacciones( LocalDate.parse("2025-06-08"),200.00, 1001, "Depósito" );


        System.out.println(admin);
        System.out.println(cliente1);
        System.out.println(cuenta1);
        System.out.println(transacciones1);






    }


    }

