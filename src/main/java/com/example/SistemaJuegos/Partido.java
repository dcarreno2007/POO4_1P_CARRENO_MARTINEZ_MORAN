package com.example.SistemaJuegos;

public class Partido {
    private String codigo;
    private String seleccionLocal;
    private String seleccionVisitante;
    private String fecha;
    private String estadio;
    private int capacidad;
    private String ciudad;
    private int entradasGeneral;
    private int entradasPreferencial;
    private int entradasVIP;
    private String fase;

    public void consultarPartidos(){
        System.out.println("Código: " + codigo);
        System.out.println("Partido: ");
        System.out.println("Fecha: " + fecha);
        System.out.println("Estadio: " + estadio);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Fase: " + fase);
        System.out.println("");
        System.out.println("Zonas Disponibles:");
    }
    
    public boolean validarStock(Zona zona, int cantidad){
        return true;
    }
    public void actualizarDisponibilidad (Zona zona, int cantidad){}
   
    //@Override
    //public String toString(){}
    


}
