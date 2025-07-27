package BL.Clases;

import java.util.Objects;

    /**
     * Clase Administrador que representa a un administrador del sistema de cuentas bancarias.
     * Contiene información básica como nombre, apellidos, cédula y correo electrónico.
     * @version 1.0.0
    */

public class Administrador {
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String cedula;
    private String correoElectronico;

        /**
         * Método getter para obtener el nombre del administrador.
         * @return Nombre del administrador.
         */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método setter para establecer el nombre del administrador.
     * @param nombre Nombre del administrador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método getter para obtener el primer apellido del administrador.
     * @return Primer apellido del administrador.
     */
    public String getPrimerApellido() {
        return primerApellido;
    }
    /**
     * Método setter para establecer el primer apellido del administrador.
     * @param primerApellido Primer apellido del administrador.
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    /**
     * Método getter para obtener el segundo apellido del administrador.
     * @return Segundo apellido del administrador.
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }
    /**
     * Método setter para establecer el segundo apellido del administrador.
     * @param segundoApellido Segundo apellido del administrador.
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    /**
     * Método getter para obtener la cédula del administrador.
     * @return Cédula del administrador.
     */
    public String getCedula() {
        return cedula;
    }
    /**
     * Método setter para establecer la cédula del administrador.
     * @param cedula Cédula del administrador.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    /**
     * Método getter para obtener el correo electrónico del administrador.
     * @return Correo electrónico del administrador.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    /**
     * Método setter para establecer el correo electrónico del administrador.
     * @param correoElectronico Correo electrónico del administrador.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Constructor por defecto de la clase Administrador.
     * Inicializa un objeto Administrador sin parámetros.
     */
    public Administrador() {
    }

    /**
     * Constructor de la clase Administrador que inicializa todos los atributos.
     * @param nombre Nombre del administrador.
     * @param primerApellido Primer apellido del administrador.
     * @param segundoApellido Segundo apellido del administrador.
     * @param cedula Cédula del administrador.
     * @param correoElectronico Correo electrónico del administrador.
     */

    public Administrador(String nombre, String primerApellido, String segundoApellido, String cedula, String correoElectronico) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Método toString que devuelve una representación en cadena del objeto Administrador.
     * @return Cadena con los detalles del administrador.
     */
    @Override
    public String toString() {
        return "Administrador{" +
                "nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }

    /**
     * Método equals que compara dos objetos Administrador para verificar si son iguales.
     * @param o Objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(primerApellido, that.primerApellido) && Objects.equals(segundoApellido, that.segundoApellido) && Objects.equals(cedula, that.cedula) && Objects.equals(correoElectronico, that.correoElectronico);
    }

    /**
     * Método hashCode que genera un código hash para el objeto Administrador.
     * @return Código hash del objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, primerApellido, segundoApellido, cedula, correoElectronico);
    }
}

