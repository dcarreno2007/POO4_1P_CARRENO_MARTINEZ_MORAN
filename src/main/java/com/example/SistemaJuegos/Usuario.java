package com.example.SistemaJuegos;

import java.util.ArrayList;

/**
 * Representa a un usuario general del sistema y contiene
 * la información común de aficionados y organizadores.
 *
 * @author Daniel Carreño
 * @version 1.0
 */

public abstract class Usuario {
    protected String codigoUnico;
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String contrasenia;
    protected String correo;
    protected TipoUsuario rol;

    /**
     * Crea un usuario con sus datos personales y credenciales.
     *
     * @param codigoUnico código único del usuario
     * @param cedula número de cédula del usuario
     * @param nombres nombres del usuario
     * @param apellidos apellidos del usuario
     * @param usuario nombre utilizado para iniciar sesión
     * @param contrasenia contraseña del usuario
     * @param correo dirección de correo electrónico
     * @param rol tipo de usuario dentro del sistema
     */

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

    /**
     * Consulta las compras de entradas relacionadas con el usuario.
     *
     * @param compras lista de compras registradas en el sistema
     */

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
    
    /**
     * Devuelve una representación en texto de los datos del usuario.
     *
     * @return cadena con la información del usuario
     */

    @Override
   public String toString(){
    return "Usuario{" +
        "codigoUnico = " + codigoUnico + " - cedula = " + cedula  + " - nombres = " + nombres + " - apellidos = " + apellidos + " - usuario = " + usuario + " - correo = " + correo + " - rol = " + rol + "}";
   }

}
