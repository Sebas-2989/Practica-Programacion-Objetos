package UI;

import BL.Carrera;
import BL.Estudiante;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {


        Carrera carrera = new Carrera();
        carrera.setCodigo(5);
        carrera.setNombre("Bisoft");
        carrera.setCredito(4);
        carrera.setEscuela("Cenfotec");
        carrera.setDuración(2.5);
        System.out.println(carrera.toString());

        Estudiante estudiante = new Estudiante("1234","Juan","Perez","Garcia","Moravia","0123456789","<EMAIL>", LocalDate.parse("2000-01-31"),true);
        Estudiante estudiante1 = new Estudiante("12341","Juan1","Perez1","Garcia","Moravia","0123456789","<EMAIL>", LocalDate.parse("2000-01-31"),true);
        Estudiante estudiante2 = new Estudiante("1234","Juan1","Perez","Garcia");

        System.out.println(estudiante.toString());
        System.out.println(estudiante1.toString());
        System.out.println(estudiante2.toString());

        String x = "hola";
        String y = "hola";
        String z = "nuevo";
        System.out.println(estudiante.equals(estudiante1));




    }

    public void miMetodo()
    {
        System.out.println("Hola mundo");
    }

    public void miMetodo(String nombre)
    {
        System.out.println("Hola mundo"+nombre);
    }
    public void miMetodo(String nombre,String apellido)
    {
        System.out.println("Hola mundo"+nombre+apellido);
    }

    public void miMetodo(String nombre,int apellido)
    {
        System.out.println("Hola mundo"+nombre+apellido);
    }

    }

