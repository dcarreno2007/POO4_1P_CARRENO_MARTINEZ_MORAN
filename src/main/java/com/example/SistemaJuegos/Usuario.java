package com.example.SistemaJuegos;

import java.util.ArrayList;

public abstract class Usuario {
    protected String codigoUnico;
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
<<<<<<< HEAD
    protected String contrasenia;
    protected String correo;
    protected TipoUsuario rol;

    public Usuario(String codigoUnico,String cedula, String nombres,String apellidos, String usuario,String contra, String correo, TipoUsuario rol){
       this.codigoUnico = codigoUnico;
        this.cedula = cedula;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.usuario= usuario;
       this.contrasenia = contra;
       this.correo=correo;
    }
    public abstract void consultarEntradas();
    
    
    public String getCodigoUnico(){ 
        return codigoUnico;
    }
    public String getCedula() { 
        return cedula; 
    }
    public String getNombres() { 
        return nombres; 
    }
    public String getApellidos() { 
        return apellidos; 
    }
    public String getNombreUsuario() { 
        return usuario; 
    }
    public String getContrasena() { 
        return contrasenia; 
    }
    public String getCorreo() { 
        return correo; 
    }
    public TipoUsuario getRol() { 
        return rol; 
    }


    public void setCodigoUnico(String codigoUnico) { 
        this.codigoUnico = codigoUnico; 
    }
    public void setCedula(String cedula) { 
        this.cedula = cedula; 
    }
    public void setNombres(String nombres) { 
        this.nombres = nombres; 
    }
    public void setApellidos(String apellidos) { 
        this.apellidos = apellidos; 
    }
    public void setNombreUsuario(String nombreUsuario) { 
        this.usuario = nombreUsuario; 
    }
    public void setContrasena(String contrasena) { 
        this.contrasenia = contrasena; 
    }
    public void setCorreo(String correo) { 
        this.correo = correo; 
    }
    public void setRol(TipoUsuario rol) { 
        this.rol = rol; 
    }
    
    
   @Override
   public String toString(){
    return "Usuario{" +
        "codigoUnico = " + codigoUnico + " - cedula = " + cedula  + " - nombres = " + nombres + " - apellidos = " + apellidos + " - nombreUsuario = " + usuario + " - correo = " + correo + " - rol = " + rol.name();
   }
=======
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
>>>>>>> c0c1aa5633d85389bd98fd13e74032bc4e20036b


}
