package com.example.SistemaJuegos;
import java.util.ArrayList;


public class Kit {
    private String codigo;
    private String nombre;
    private String descripcion;
    private ArrayList<Partido> partidosIncluidos;
    private double precio;
    private int disponibles;

    public Kit(String codigo, String nombre, String descripcion,
               ArrayList<Partido> partidosIncluidos,
               double precio, int disponibles) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.partidosIncluidos = partidosIncluidos;
        this.precio = precio;
        this.disponibles = disponibles;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Partido> getPartidosIncluidos() {
        return partidosIncluidos;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDisponibles() {
        return disponibles;
    }

    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPartidosIncluidos(ArrayList<Partido> partidosIncluidos) {
        this.partidosIncluidos = partidosIncluidos;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    
    public boolean validarDisponibilidad() {
        return disponibles > 0;
    }

    
    public void actualizarDisponibilidad() {
        if (disponibles > 0) {
            disponibles--;
        
        } else {
            System.out.println("No hay kits disponibles.");
        
        }
    }

    
    public void mostrarPartidosIncluidos() {
        System.out.println("Partidos incluidos en el kit " + nombre + ":");
        for (Partido partido : partidosIncluidos) {
            System.out.println("- " + partido.getSeleccionLocal() +
                    " vs " + partido.getSeleccionVisitante() +
                    " el " + partido.getFecha());
        }
    }

    @Override
    public String toString() {
        return "Kit{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", partidosIncluidos=" + partidosIncluidos +
                ", precio=" + precio +
                ", disponibles=" + disponibles +
                '}';
    }
}