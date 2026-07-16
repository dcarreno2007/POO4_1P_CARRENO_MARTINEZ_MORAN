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

    private static final double PRECIOGENERAL = 50.0;
    private static final double PRECIOPREFERENCIAL = 100.0; 
    private static final double PRECIOVIP = 200.0; 

    public Partido(String codigo, String seleccionLocal, String seleccionVisitante,
                   Date fecha, String estadio, int capacidad, String ciudad,
                   int entradasGeneral, int entradasPreferencial, int entradasVIP,
                   String fase) {

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

    
    public String getCodigo() {
        return codigo;
    }

    public String getSeleccionLocal() {
        return seleccionLocal;
    }

    public String getSeleccionVisitante() {
        return seleccionVisitante;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getEstadio() {
        return estadio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getEntradasGeneral() {
        return entradasGeneral;
    }

    public int getEntradasPreferencial() {
        return entradasPreferencial;
    }

    public int getEntradasVIP() {
        return entradasVIP;
    }


    public String getFase() {
        return fase;
    }

    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setSeleccionLocal(String seleccionLocal) {
        this.seleccionLocal = seleccionLocal;
    }

    public void setSeleccionVisitante(String seleccionVisitante) {
        this.seleccionVisitante = seleccionVisitante;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEntradasGeneral(int entradasGeneral) {
        this.entradasGeneral = entradasGeneral;
    }

    public void setEntradasPreferencial(int entradasPreferencial) {
        this.entradasPreferencial = entradasPreferencial;
    }

    public void setEntradasVIP(int entradasVIP) {
        this.entradasVIP = entradasVIP;
    }


    public void setFase(String fase) {
        this.fase = fase;
    }

    
    public static double getPrecioGeneral() {
        return PRECIOGENERAL;
    }

    public static double getPrecioPreferencial() {
        return PRECIOPREFERENCIAL;
    }

    public static double getPrecioVIP() {
        return PRECIOVIP;
    }

  
    public double obtenerPrecioEntrada(String tipoEntrada) {
        switch (tipoEntrada.toLowerCase()) {
            case "general":
                return PRECIOGENERAL;
            case "preferencial":
                return PRECIOPREFERENCIAL;
            case "vip":
                return PRECIOVIP;
            default:
                throw new IllegalArgumentException("Tipo de entrada no válido: " + tipoEntrada);
        }
    }

    
    public int obtenerDisponibilidad(Zona zona) {
        switch (zona) {
            case GENERAL:
                return entradasGeneral;
            case PREFERENCIAL:
                return entradasPreferencial;
            case VIP:
                return entradasVIP;
            default:
                throw new IllegalArgumentException("Zona no válida: " + zona);
        }
    }

    
    public boolean validarStock(Zona zona, int cantidad) {
        return obtenerDisponibilidad(zona) >= cantidad && cantidad > 0;
    }

    
    public void actualizarDisponibilidad(Zona zona, int cantidad) {
        if (!validarStock(zona, cantidad)) {
            System.out.println("No hay suficiente stock");
            return;
        }

        switch (zona) {
            case GENERAL:
                entradasGeneral -= cantidad;
                break;
            case PREFERENCIAL:
                entradasPreferencial -= cantidad;
                break;
            case VIP:
                entradasVIP -= cantidad;
                break;
        }
    }

    @Override
    public String toString() {
        return "Partido{" +
                "codigo='" + codigo + '\'' +
                ", seleccionLocal='" + seleccionLocal + '\'' +
                ", seleccionVisitante='" + seleccionVisitante + '\'' +
                ", fecha='" + fecha + '\'' +
                ", estadio='" + estadio + '\'' +
                ", capacidad=" + capacidad +
                ", ciudad='" + ciudad + '\'' +
                ", entradasGeneral=" + entradasGeneral +
                ", entradasPreferencial=" + entradasPreferencial +
                ", entradasVIP=" + entradasVIP +
                ", fase=" + fase +
                '}';
    }


}