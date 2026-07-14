package com.example.SistemaJuegos;

import java.text.SimpleDateFormat;
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

    public Compra(TipoCompra tipoCompra, int codigoRef, int cantidad, double valorPagado, int codigoAficionado) {
        contadorCompras++;
        this.codigo = generarCodigo();
        this.tipo = tipoCompra;
        this.codigoReferencia = String.valueOf(codigoRef);
        this.fechaCompra = new Date(); // fecha actual
        this.cantidad = cantidad;
        this.valorPagado = valorPagado;
        this.codigoAficionado = String.valueOf(codigoAficionado);
    }

    public Compra(String codigo, TipoCompra tipoCompra, String codigoRef, Date fechaCompra,
                  int cantidad, double valorPagado, String codigoAficionado) {

        this.codigo = codigo;
        this.tipo = tipoCompra;
        this.codigoReferencia = codigoRef;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.valorPagado = valorPagado;
        this.codigoAficionado = codigoAficionado;
    }

    public String generarCodigo() {
        return String.format("C%03d", contadorCompras);
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaTexto = formato.format(fechaCompra);

        return codigo + "|" + tipo + "|" + codigoReferencia + "|" +
               fechaTexto + "|" + cantidad + "|" + valorPagado + "|" + codigoAficionado;
    }

    public String getCodigo() {
        return codigo;
    }

    public TipoCompra getTipo() {
        return tipo;
    }

    public String getCodigoReferencia() {
        return codigoReferencia;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public String getCodigoAficionado() {
        return codigoAficionado;
    }

    public void setTipo(TipoCompra tipo) {
        this.tipo = tipo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCodigoReferencia(String codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public void setCodigoAficionado(String codigoAficionado) {
        this.codigoAficionado = codigoAficionado;
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