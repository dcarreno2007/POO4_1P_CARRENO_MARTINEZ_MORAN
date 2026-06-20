package com.example.SistemaJuegos;

public abstract class Usuario {
    protected String codigo_unico;
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String correo;
    protected TipoUsuario rol;

    public Usuario(String codigo_unico,String cedula, String nombre,String apellido, String usuario, String correo, TipoUsuario rol){
        this.codigo_unico = codigo_unico;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario= usuario;
        this.correo=correo;
    }

    public TipoUsuario getRol(){
        return this.rol;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public String getCorreo(){
        return this.correo;
    }
    
    public void menuOpciones(){
        System.out.println(" 1. Consultar partidos ");
    }
    
    public void consultarEntradas(){

    }
//    Retorna String:
//    public String toString(){}


}
