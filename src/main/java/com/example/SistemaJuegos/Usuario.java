package com.example.SistemaJuegos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Usuario {
    protected String codigo_unico;
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String contrasena;
    protected String correo;
    protected TipoUsuario rol;

    public Usuario(String codigo_unico,String cedula, String nombre,String apellido, String usuario, String contrasena, String correo, TipoUsuario rol){
        this.codigo_unico = codigo_unico;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.rol = rol;
    }
    
    public void menuOpciones(){
        System.out.println(" 1. Consultar partidos ");
    }
    
    public void consultarEntradas(){

    }
//    @Override
//    public String toString(){}

    public static ArrayList<Usuario> cargarUsuarios(String ruta) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(ruta))) {
            String line;
            line = bf.readLine();
            while ((line = bf.readLine()) != null) {
                String [] aficionadoL = line.split("|");
                String CodigoUnico = aficionadoL[0];
                String Cedula = aficionadoL[1];
                String Nombres = aficionadoL[2];
                String Apellidos = aficionadoL[3];
                String Contrasena = aficionadoL[4];
                String Usuario = aficionadoL[7];
                String Correo = aficionadoL[8];
                TipoUsuario rol = TipoUsuario.valueOf(aficionadoL[9]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }


}
