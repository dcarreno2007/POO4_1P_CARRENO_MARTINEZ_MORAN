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

    public boolean validarStock(Zona zona, int cantidad){
        return true;
    }
    public void actualizarDisponibilidad (Zona zona, int cantidad){}
    //@Override
    //public String toString(){}
    


}
