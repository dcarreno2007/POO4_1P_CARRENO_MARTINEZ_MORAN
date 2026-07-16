package com.example.SistemaJuegos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Representa a un aficionado registrado en el sistema.
 * Permite consultar partidos, comprar entradas o kits
 * y revisar las compras realizadas.
 *
 * @author Daniel Carreño
 * @version 1.0
 */

public class Aficionado extends Usuario{
    private String paisFav;
    private String celular;

     /**
      * Crea un aficionado con sus datos personales,
      * credenciales y preferencias.
      *
      * @param codigoUnico código único del aficionado
      * @param cedula número de cédula del aficionado
      * @param nombres nombres del aficionado
      * @param apellidos apellidos del aficionado
      * @param usuario nombre utilizado para iniciar sesión
      * @param contrasenia contraseña del aficionado
      * @param correo dirección de correo electrónico
      * @param rol tipo de usuario dentro del sistema
      * @param paisFav selección o país favorito del aficionado
      * @param celular número de celular del aficionado
     */

    public Aficionado(String codigoUnico,String cedula, String nombres,String apellidos, String usuario, String contrasenia, String correo, TipoUsuario rol, String paisFav, String celular){
        super(codigoUnico, cedula, nombres, apellidos, usuario, contrasenia, correo, rol);
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

    /**
     * Devuelve una representación en texto de los datos
     * del aficionado.
     *
     * @return cadena con la información del aficionado
     */

    @Override
    public String toString() {
        return super.toString() + " - pais favorito = " + this.paisFav + " - celular = " + this.celular;
    }

    /**
     * Muestra los partidos registrados junto con su fecha,
     * estadio, ciudad, fase, zonas, precios y disponibilidad.
     *
     * @param partidos lista de partidos registrados en el sistema
     */

    public void consultarPartidos(ArrayList<Partido> partidos) {

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        int contador = 1;
        System.out.println("\nPartidos encontrados:\n");
        for (Partido partido : partidos) {
            System.out.println(contador + ". Código: " + partido.getCodigo());
            System.out.println("   Partido: " + partido.getSeleccionLocal() + " vs " + partido.getSeleccionVisitante());
            System.out.println("   Fecha: " + formatoFecha.format(partido.getFecha()));
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

    /**
     * Realiza la compra de entradas para un partido
     * en una zona determinada.
     *
     * @param partido partido para el cual se comprarán las entradas
     * @param zona zona seleccionada para la compra
     * @param cantidad cantidad de entradas solicitadas
     * @return compra generada o null si el partido no existe
     *         o no hay suficiente disponibilidad
     */

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

    /**
     * Realiza la compra de un kit de entradas.
     *
     * @param kit kit que será adquirido por el aficionado
     * @return compra generada o null si el kit no existe
     *         o no se encuentra disponible
     */

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

    /**
     * Muestra las compras de entradas y kits realizadas
     * por el aficionado.
     *
     * @param compras lista de compras registradas en el sistema
     */

    @Override
    public void consultarEntradas(ArrayList<Compra> compras) {

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        boolean tieneCompras = false;

        System.out.println();
        System.out.println("Entradas compradas por el aficionado " + this.getNombres() + " " + this.getApellidos() + ":");
        System.out.println();

        for (Compra compra : compras) {
            if (compra.getCodigoAficionado().equals(this.codigoUnico)) {
                System.out.println("Código de compra: " + compra.getCodigo());
                System.out.println("Tipo: " + compra.getTipo());
                System.out.println("Código de referencia: " + compra.getCodigoReferencia());
                System.out.println("Fecha: " + formatoFecha.format(compra.getFechaCompra()));
                System.out.println("Cantidad: " + compra.getCantidad());
                System.out.println("Zona: " + (compra.getZona() != null ? compra.getZona() : "No aplica"));
                System.out.println("Valor pagado: $" + compra.getValorPagado());
                System.out.println();
                System.out.println("--------------------------------------------");
                tieneCompras = true;
            }
        }
        if (!tieneCompras) {
            System.out.println("No se encontraron compras para este aficionado.");
        }

    }



}
