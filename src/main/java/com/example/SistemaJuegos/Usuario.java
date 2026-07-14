package com.example.SistemaJuegos;

import java.util.ArrayList;

public abstract class Usuario {
    protected String codigoUnico;
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String contrasena;
    protected String correo;
    protected TipoUsuario rol;

    public Usuario(String codigoUnico, String cedula, String nombre, String apellido, String usuario, String contrasena, String correo, TipoUsuario rol){
        // Constructor para inicializar los atributos del usuario
        this.codigoUnico = codigoUnico;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.rol = rol;
    }

    // Getters y setters para los atributos del usuario

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoUsuario getRol() {
        return rol;
    }

    public void setRol(TipoUsuario rol) {
        this.rol = rol;
    }

    
    // Método abstracto para consultar entradas, que debe ser implementado por las subclases

    public abstract void consultarEntradas(ArrayList<Compra> compras);


    @Override
    public String toString() {
        return "Usuario{" +
                "Código='" + codigoUnico + '\'' +
                ", cédula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", usuario='" + usuario + '\'' +
                ", correo='" + correo + '\'' +
                ", rol=" + rol +
                '}';
    }


}
