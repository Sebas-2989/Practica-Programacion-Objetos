package BL.Clases;

import java.util.Objects;

public class Cliente {
    private String idCliente;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String cedula;
    private String sexo;
    private String correoElectronico;
    private String profesion;
    private String direccion;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cliente() {
    }

    public Cliente(String idCliente, String nombre, String primerApellido, String segundoApellido, String cedula, String sexo, String correoElectronico, String profesion, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.sexo = sexo;
        this.correoElectronico = correoElectronico;
        this.profesion = profesion;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente='" + idCliente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", sexo='" + sexo + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", profesion='" + profesion + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(idCliente, cliente.idCliente) && Objects.equals(nombre, cliente.nombre) && Objects.equals(primerApellido, cliente.primerApellido) && Objects.equals(segundoApellido, cliente.segundoApellido) && Objects.equals(cedula, cliente.cedula) && Objects.equals(sexo, cliente.sexo) && Objects.equals(correoElectronico, cliente.correoElectronico) && Objects.equals(profesion, cliente.profesion) && Objects.equals(direccion, cliente.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nombre, primerApellido, segundoApellido, cedula, sexo, correoElectronico, profesion, direccion);
    }


}
