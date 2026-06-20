package com.example.SistemaJuegos;

public class Aficionado extends Usuario{
    private String paisFav;
    private String celular;

    public Aficionado(String codigo_unico,String cedula, String nombre,String apellido,String usuario, String correo, TipoUsuario rol, String paisFav, String celular){
        super(codigo_unico, cedula, nombre, apellido, usuario, correo, rol );
        this.paisFav = paisFav;
        this.celular = celular;
    }
    

    public void consultarPartidos(){
        System.out.println("Código: " + getCodigo());
        System.out.println("Partido: " + getSeleccionLocal() + " vs " + getSeleccionVisitante());
        System.out.println("Fecha: " + getFecha());
        System.out.println("Estadio: " + getCapacidad());
        System.out.println("Ciudad: " + getCiudad());
        System.out.println("Fase: " + getFase());
        System.out.println("");
        System.out.println("Zonas Disponibles:");
        System.out.println("- GENERAL           | DISPONIBLES: " + getEntradasGeneral()      + " | PRECIO: $" );
        System.out.println("- PREFERENCIAL      | DISPONIBLES: " + getEntradasPreferencial() + " | PRECIO: $");
        System.out.println("- VIP               | DISPONIBLES: " + getEntradasVIP()          + " | PRECIO: $");
    }

    
    //Retorna Compra: 
    //Hay que hacer constructor de compra
    // public compra comprar(Partido partido, Zona zona, int Cantidad){}

    //Retorna Compra:
    //Hay que usar constructor sobrecarga de compra:
    // public compra (Kit kit){}

    public void consultarEntradas(){

    }
}
