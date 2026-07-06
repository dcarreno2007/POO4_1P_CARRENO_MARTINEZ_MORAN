package com.example.SistemaJuegos;
import java.util.ArrayList;

public class Kit {
    private String codigo;
    private String nombre;
    private String descripcion;
    private ArrayList <Partido> partidosIncluidos;
    private double precio;
    private int disponibles;

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList getPartidosIncluidos() {
        return this.partidosIncluidos;
    }

    public void setPartidosIncluidos(ArrayList partidosIncluidos) {
        this.partidosIncluidos = partidosIncluidos;
    }

    public boolean validarDisponibilidad() {
        return disponibles > 0;
    }

    public void actualizarDisponibilidad() {
    }
}
