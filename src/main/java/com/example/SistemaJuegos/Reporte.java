package com.example.SistemaJuegos;
import java.util.Date;

public class Reporte {
    Date fechaGen;
    int totalCompras;
    int totalEntradas;
    int totalKits;
    double montoTotal;

    public Reporte(Date fechaGen, int totalCompras, int totalEntradas, int totalKits, double montoTotal) {
        this.fechaGen = fechaGen;
        this.totalCompras = totalCompras;
        this.totalEntradas = totalEntradas;
        this.totalKits = totalKits;
        this.montoTotal = montoTotal;
    }

    public String generarResumen(){
        String r = "===== GENERAR REPORTE DE VENTAS =====\n\n"
                + "Resumen de ventas registradas:\n\n"
                + "Total de compras: " + totalCompras + "\n\n"
                + "Compras por tipo:\n\n"
                + "Entradas: " + totalEntradas + "\n"
                + "Kits: " + totalKits + "\n\n"
                + "Monto total recaudado:\n" + "$" + montoTotal;
                return r;
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