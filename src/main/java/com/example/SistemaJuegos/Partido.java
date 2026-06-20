package com.example.SistemaJuegos;
import java.util.Date;

public class Partido {
    private String codigo;
    private String seleccionLocal;
    private String seleccionVisitante;
    private Date fecha;
    private String estadio;
    private int capacidad;
    private String ciudad;
    private int entradasGeneral;
    private int entradasPreferencial;
    private int entradasVIP;
    private String fase;

    public Partido (String codigo,String seleccionLocal, String seleccionVisitante, Date fecha, String estadio, int capacidad, String ciudad, int entradasGeneral, int entradasPreferencial, int entradasVIP, String fase){
        this.codigo = codigo;
        this.seleccionLocal = seleccionLocal;
        this.seleccionVisitante = seleccionVisitante;
        this.fecha = fecha;
        this.estadio = estadio;
        this.capacidad = capacidad;
        this.ciudad = ciudad;
        this.entradasGeneral = entradasGeneral;
        this.entradasPreferencial = entradasPreferencial;
        this.entradasVIP = entradasVIP;
        this.fase = fase;
    }

    public Date getFecha(){
        return this.fecha;
    }
    public String getEstadio(){
        return this.estadio;
    }
    public String getCiudad(){
        return this.ciudad;
    }
    public String getCodigo(){
        return this.codigo;
    }
    public String getSeleccionLocal(){
        return this.seleccionLocal;
    }
    public String getSeleccionVisitante(){
        return this.seleccionVisitante;
    }
    public int getCapacidad(){
        return this.capacidad;
    }
    public int getEntradasGeneral(){
        return this.entradasGeneral;
    }
    public int getEntradasPreferencial(){
        return this.entradasPreferencial;
    }
    public int getEntradasVIP(){
        return this.entradasVIP;
    }
    public String getFase(){
        return this.fase;
    }

    

    public boolean validarStock(Zona zona, int cantidad){
        return true;
    }
    public void actualizarDisponibilidad (Zona zona, int cantidad){}
   
    //@Override
    //public String toString(){}
    


}
