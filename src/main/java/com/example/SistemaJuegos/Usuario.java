package com.example.SistemaJuegos;

import java.util.ArrayList;

public abstract class Usuario {
    protected String codigoUnico;
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String contrasenia;
    protected String correo;
    protected TipoUsuario rol;

    public Usuario(String codigoUnico,String cedula, String nombres,String apellidos, String usuario,String contrasenia, String correo, TipoUsuario rol){
       this.codigoUnico = codigoUnico;
        this.cedula = cedula;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.usuario= usuario;
       this.contrasenia = contrasenia;
       this.correo=correo;
       this.rol = rol;
    }

    // Método abstracto para consultar entradas, que debe ser implementado por las subclases

    public abstract void consultarEntradas(ArrayList<Compra> compras);

    // Getters y setters para los atributos del usuario
    
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
    public String getUsuario() { 
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
    public void setUsuario(String usuario) { 
        this.usuario = usuario; 
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
    
    // Método para mostrar la información del usuario
   @Override
   public String toString(){
    return "Usuario{" +
        "codigoUnico = " + codigoUnico + " - cedula = " + cedula  + " - nombres = " + nombres + " - apellidos = " + apellidos + " - usuario = " + usuario + " - correo = " + correo + " - rol = " + rol + "}";
   }

}
