package com.example.SistemaJuegos;

import java.util.Date;

public class Compra {
    private static int contadorCompras = 0;
    private String codigo;
    private TipoCompra tipo;
    private String codigoReferencia;
    private Date fechaCompra;
    private int cantidad;
    private double valorPagado;
    private String codigoAficionado;
    private Zona zona;

    public Compra(TipoCompra tipoCompra, String codigoRef, int cantidad, double valorPagado, String codigoAficionado, Zona zona) {
        contadorCompras++;
        this.codigo = generarCodigo();
        this.tipo = tipoCompra;
        this.codigoReferencia = codigoRef;
        this.fechaCompra = new Date();
        this.cantidad = cantidad;
        this.valorPagado = valorPagado;
        this.codigoAficionado = codigoAficionado;
        this.zona = zona;
    }

    public Compra(TipoCompra tipoCompra, String codigoRef, int cantidad, double valorPagado, String codigoAficionado) {
        this(tipoCompra, codigoRef, cantidad, valorPagado, codigoAficionado, null);
    }

    public static String generarCodigo(){
        return String.format("C%03d", contadorCompras);
    }

    @Override
    public String toString(){
        String zonaTexto;
        if (zona != null) {
            zonaTexto = zona.toString();
        } else {
            zonaTexto = "SIN_ZONA";
        }
        return codigo + "|" + tipo + "|" + codigoReferencia + "|" + fechaCompra + "|" + cantidad + "|" + valorPagado + "|" + codigoAficionado + "|" + zonaTexto;
    }

    public String getCodigo(){
        return codigo;
    }
    public TipoCompra getTipo(){
        return tipo;
    }
    public String getCodigoReferencia(){
        return codigoReferencia;
    }
    public Date getFechaCompra(){
        return fechaCompra;
    }
    public int getCantidad(){
        return cantidad;
    }
    public double getValorPagado(){
        return valorPagado;
    }
    public String getCodigoAficionado(){
        return codigoAficionado;
    }
    public Zona getZona(){
        return zona;
    }

    public void setTipo(TipoCompra tipo){
        this.tipo = tipo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public void setCodigoReferencia(String codigoReferencia){
        this.codigoReferencia = codigoReferencia;
    }
    public void setFechaCompra(Date fechaCompra){
        this.fechaCompra = fechaCompra;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public void setValorPagado(double valorPagado){
        this.valorPagado = valorPagado;
    }
    public void setCodigoAficionado(String codigoAficionado){
        this.codigoAficionado = codigoAficionado;
    }
    public void setZona(Zona zona){
        this.zona = zona;
    }
    public static void setContadorCompras(int valor) {
        contadorCompras = valor;
    }
    public static void actualizarContadorDesdeCodigo(String codigo) {
        int numero = Integer.parseInt(codigo.substring(1));
        if (numero > contadorCompras) {
            contadorCompras = numero;
        }
    }

    
}
