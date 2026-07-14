package com.example.SistemaJuegos;

import java.util.ArrayList;

public class Aficionado extends Usuario{
    private String paisFav;
    private String celular;


    public Aficionado(String codigoUnico,String cedula, String nombres,String apellidos, String usuario, String contra, String correo, TipoUsuario rol, String paisFav, String celular){
        super(codigoUnico, cedula, nombres, apellidos, usuario, contra, correo, rol);
        this.paisFav = paisFav;
        this.celular = celular;
    }

    public String getPaisFav(){
        return paisFav;
    }

    public String getCelular(){
        return celular;
    }

    public void setPaisFav(String pais){
        this.paisFav = pais;
    }

    public void setCelular(String celular){
        this.celular = celular;
    }

    @Override
    public String toString() {
        return super.toString() + " - pais favorito = " + this.paisFav + " - celular = " + this.celular;
    }

    public void consultarPartidos(ArrayList<Partido> partidos) {
        int contador = 1;
        System.out.println("Partidos disponibles:");
        for (Partido partido : partidos) {
            System.out.println(contador + ". Código: " + partido.getCodigo());
            System.out.println("   Partido: " + partido.getSeleccionLocal() + " vs " + partido.getSeleccionVisitante());
            System.out.println("   Fecha: " + partido.getFecha());
            System.out.println("   Estadio: " + partido.getEstadio());
            System.out.println("   Ciudad: " + partido.getCiudad());
            System.out.println("   Fase: " + partido.getFase());

            System.out.println();
            System.out.println("   Zonas disponibles:");
            System.out.println("   - GENERAL       | Disponibles: " + partido.getEntradasGeneral() + " | Precio: $" + Partido.getPrecioGeneral());
            System.out.println("   - PREFERENCIAL  | Disponibles: " + partido.getEntradasPreferencial() + " | Precio: $" + Partido.getPrecioPreferencial());
            System.out.println("   - VIP           | Disponibles: " + partido.getEntradasVIP() + " | Precio: $" + Partido.getPrecioVIP());

            System.out.println();
            System.out.println("--------------------------------------------------");
            contador++;
        }
    }

    public Compra comprar(Partido partido, Zona zona, int cantidad) {

        // Validar si el partido existe
        if (partido == null) {
            System.out.println("El partido seleccionado no existe.");
            return null;
        }

        // Validar stock de entradas disponibles para la zona seleccionada
        if (!partido.validarStock(zona, cantidad)) {
            System.out.println("No hay suficientes entradas disponibles para la zona seleccionada.");
            return null;
        }

        // Obtener el precio de la entrada según la zona
        double precioUnitario = partido.obtenerPrecioEntrada(zona.name());

        // Calcular el valor total a pagar
        double valorPagado = precioUnitario * cantidad;
        
        System.out.printf("Valor total a pagar: $%.2f%n", valorPagado);

        // Crear compra
        Compra compra = new Compra(TipoCompra.ENTRADA, partido.getCodigo(), cantidad, valorPagado, this.codigoUnico, zona);


        // Actualizar disponibilidad en memoria
        partido.actualizarDisponibilidad(zona, cantidad);

        // Retornar la compra realizada
        return compra;
    }

    public Compra comprar(Kit kit) {

        // Validar si el kit existe
        if (kit == null) {
            System.out.println("El kit seleccionado no existe.");
            return null;
        }

        // Validar disponibilidad del kit
        if (!kit.validarDisponibilidad()) {
            System.out.println("El kit no está disponible.");
            return null;
        }

        // Calcular el valor total a pagar
        double valorPagado = kit.getPrecio();
        
        // Crear compra
        Compra compra = new Compra(TipoCompra.KIT, kit.getCodigo(), 1, valorPagado, this.codigoUnico);

        kit.actualizarDisponibilidad();
        
        // Retornar la compra realizada
        return compra;
    }

    @Override
    public void consultarEntradas(ArrayList<Compra> compras) {
        boolean tieneCompras = false;

        System.out.println("Entradas compradas por el aficionado " + this.getNombres() + " " + this.getApellidos() + ":");

        for (Compra compra : compras) {
            if (compra.getCodigoAficionado().equals(this.codigoUnico)) {
                System.out.println("Código de compra: " + compra.getCodigo());
                System.out.println("Tipo: " + compra.getTipo());
                System.out.println("Código de referencia: " + compra.getCodigoReferencia());
                System.out.println("Fecha: " + compra.getFechaCompra());
                System.out.println("Cantidad: " + compra.getCantidad());
                System.out.println("Zona: " + (compra.getZona() != null ? compra.getZona() : "No aplica"));
                System.out.println("Valor pagado: $" + compra.getValorPagado());
                tieneCompras = true;
            }
        }
        if (!tieneCompras) {
            System.out.println("No se encontraron compras para este aficionado.");
        }

    }



}
