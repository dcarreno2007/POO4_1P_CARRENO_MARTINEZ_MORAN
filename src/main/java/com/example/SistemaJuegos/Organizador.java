package com.example.SistemaJuegos;

import java.util.ArrayList;
import java.util.Date;

public class Organizador extends Usuario {

    private String empresa;
    private String cargo;

    public Organizador(String codigoUnico,String cedula, String nombres,String apellidos, String usuario,String contra, String correo, TipoUsuario rol, String empresa, String cargo){
        super(codigoUnico, cedula, nombres, apellidos, usuario, contra, correo, rol);
        this.empresa = empresa;
        this.cargo = cargo;
    }

    public String getEmpresa(){
        return empresa;
    }
    public String getCargo(){
        return cargo;
    }

    public void setEmpresa(String empresa){
        this.empresa = empresa;
    }
    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return super.toString() 
                + " - empresa = " + this.empresa
                + " - cargo = " + this.cargo;
    }
    
    @Override
    public void consultarEntradas(ArrayList<Compra> compras) {

        // Verificar si hay compras registradas
        boolean hayCompras = false;

        System.out.println("Compras registradas en el sistema");

        for (Compra compra : compras) {

            System.out.println("Código de compra: " + compra.getCodigo());
            System.out.println("Tipo de compra: " + compra.getTipo());
            System.out.println("Código de referencia: " + compra.getCodigoReferencia());
            System.out.println("Fecha: " + compra.getFechaCompra());
            System.out.println("Cantidad: " + compra.getCantidad());
            System.out.println("Valor pagado: $" + compra.getValorPagado());
            System.out.println("Código del aficionado: " + compra.getCodigoAficionado());
            System.out.println("Zona: " + (compra.getZona() != null ? compra.getZona() : "No aplica"));

            System.out.println("-----------------------------------");

            hayCompras = true;
        }

        if (!hayCompras) {
            System.out.println("No se encontraron compras registradas en el sistema.");
        }
    }

    public Reporte generarReporte(ArrayList<Compra> compras) {

        int totalCompras = 0;
        int totalEntradas = 0;
        int totalKits = 0;
        double montoTotal = 0;

        for (Compra compra : compras) {

            totalCompras++;
            
            if (compra.getTipo() == TipoCompra.ENTRADA) {
                totalEntradas++;
            } else if (compra.getTipo() == TipoCompra.KIT) {
                totalKits++;
            }

            montoTotal += compra.getValorPagado();

        }
        return new Reporte(new Date(), totalCompras, totalEntradas, totalKits, montoTotal);
    }  
}
