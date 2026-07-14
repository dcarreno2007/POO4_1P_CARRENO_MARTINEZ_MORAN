package com.example.SistemaJuegos;
import java.util.Date;

public class Reporte {
    private Date fechaGen;
    private int totalCompras;
    private int totalEntradas;
    private int totalKits;
    private double montoTotal;

    public Reporte(Date fechaGen, int totalCompras, int totalEntradas, int totalKits, double montoTotal) {
        this.fechaGen = fechaGen;
        this.totalCompras = totalCompras;
        this.totalEntradas = totalEntradas;
        this.totalKits = totalKits;
        this.montoTotal = montoTotal;
    }

    public String generarRessumen(){
        String a = "Fecha de Generación: " + fechaGen + "\n" +
                "Total de Compras: " + totalCompras + "\n" +
                "Total de Entradas: " + totalEntradas + "\n" +
                "Total de Kits: " + totalKits + "\n" +
                "Monto Total: " + montoTotal;
                return a;
    }
    @Override
    public String toString() {
        return "Reporte{" +
                "fechaGen=" + fechaGen +
                ", totalCompras=" + totalCompras +
                ", totalEntradas=" + totalEntradas +
                ", totalKits=" + totalKits +
                ", montoTotal=" + montoTotal +
                '}';
    }

    public Date getFechaGen() {
        return fechaGen;
    }
    public int getTotalCompras() {
        return totalCompras;
    }
    public int getTotalEntradas() {
        return totalEntradas;
    }
    public int getTotalKits() {
        return totalKits;
    }
    public double getMontoTotal() {
        return montoTotal;
    }

    public void setFechaGen(Date fechaGen) {
        this.fechaGen = fechaGen;
    }
    public void setTotalCompras(int totalCompras) {
        this.totalCompras = totalCompras;
    }
    public void setTotalEntradas(int totalEntradas) {
        this.totalEntradas = totalEntradas;
    }
    public void setTotalKits(int totalKits) {
        this.totalKits = totalKits;
    }
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}

