package BL;

import java.io.FileInputStream;
import java.util.Properties;


public class Configuracion {
    private String claseJDBC;
    private String stringConexion;

    public String getClaseJDBC() {
        return claseJDBC;
    }

    public void setClaseJDBC(String claseJDBC) {
        this.claseJDBC = claseJDBC;
    }

    public String getStringConexion() {
        return stringConexion;
    }

    public void setStringConexion(String stringConexion) {
        this.stringConexion = stringConexion;
    }   

    public Configuracion(){
        leerConfiguracion();
    }


    public Configuracion(String claseJDBC, String stringConexion) {
        this.claseJDBC = claseJDBC;
        this.stringConexion = stringConexion;
    }

    public void leerConfiguracion() {
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\r3al2\\OneDrive - Universidad de Costa Rica\\Sebas\\Cenfotec\\CII-2025\\BISOFT-07 Programación Orientada a Objetos SCV0\\Entregas\\Practica\\Practica-Programacion-Objetos\\SistemaCuentasBancarias\\src\\BL\\config.properties");
            prop.load(fis);
            this.setClaseJDBC(prop.getProperty("claseJDBC"));
            this.setStringConexion(prop.getProperty("stringConexion"));
            fis.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}