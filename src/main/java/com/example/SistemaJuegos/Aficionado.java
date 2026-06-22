package com.example.SistemaJuegos;

public class Aficionado extends Usuario{
    private String paisFav;
    private String celular;


    public Aficionado(String codigoUnico,String cedula, String nombres,String apellidos, String usuario, String contra, String correo, TipoUsuario rol, String paisFav, String celular){
        super(codigoUnico, cedula, nombres, apellidos, usuario, contra, correo, rol);
        this.paisFav = paisFav;
        this.celular = celular;
    }

    public String getPaisFav(){
        return paisFav;
    }

    public String getCelular(){
        return celular;
    }

    public void setPaisFav(String pais){
        this.paisFav = pais;
    }

    public void setCelular(String celular){
        this.celular = celular;
    }


    @Override
    public void consultarEntradas(){
        System.out.println("Codigo: " + codigoUnico);
        System.out.println("Partido: ");
        System.out.println("Fecha: " );
    }


    @Override
    public String toString() {
        return super.toString() + " - pais favorito = " + this.paisFav + " - celular = " + this.celular;
    }


}
