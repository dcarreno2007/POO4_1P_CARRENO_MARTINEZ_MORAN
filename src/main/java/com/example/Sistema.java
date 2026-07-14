package com.example;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.example.SistemaJuegos.Aficionado;
import com.example.SistemaJuegos.Compra;
import com.example.SistemaJuegos.Kit;
import com.example.SistemaJuegos.ManejoArchivos;
import com.example.SistemaJuegos.Organizador;
import com.example.SistemaJuegos.Partido;
import com.example.SistemaJuegos.Reporte;
import com.example.SistemaJuegos.TipoCompra;
import com.example.SistemaJuegos.TipoUsuario;
import com.example.SistemaJuegos.Usuario;


public class Sistema{
    private ArrayList<Partido> partidos = new ArrayList<>();
    private ArrayList<Kit> kits = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Compra> compras = new ArrayList<>();

    public static void main(String[] args) {

        Sistema s = new Sistema();

        s.cargarPartidos("C:\\Users\\USER\\POO4_1P_CARRENO_MARTINEZ_MORAN\\src\\main\\java\\com\\example\\SistemaJuegos\\partidos.txt");
        s.cargarKits("src/main/java/com/example/SistemaJuegos/kits.txt");

    }


    public void cargarUsuarios() {
    cargarAficionados("src/main/java/com/example/SistemaJuegos/aficionados.txt");
    cargarOrganizadores("src/main/java/com/example/SistemaJuegos/organizadores.txt");
}

private void cargarAficionados(String ruta) {

    ArrayList<String> lineas = ManejoArchivos.LeeFichero(ruta);

    for (int i = 1; i < lineas.size(); i++) {

        String[] d = lineas.get(i).split("\\|");

        String codigoUnico = d[0];
        String cedula = d[1];
        String nombres = d[2];
        String apellidos = d[3];
        String usuario = d[4];
        String contrasena = d[5];
        String correo = d[6];
        String celular = d[7];
        String paisFav = d[8];

        Aficionado a = new Aficionado(codigoUnico, cedula, nombres, apellidos, celular, paisFav, usuario, correo);
        usuarios.add(a);
    }
}

private void cargarOrganizadores(String ruta) {

    ArrayList<String> lineas = ManejoArchivos.LeeFichero(ruta);

    for (int i = 1; i < lineas.size(); i++) {

        String[] d = lineas.get(i).split("\\|");

        String codigoUnico = d[0];
        String cedula = d[1];
        String nombres = d[2];
        String apellidos = d[3];
        String usuario = d[4];
        String contrasena = d[5];
        String correo = d[6];
        String empresa = d[7];
        String cargo = d[8];

        Organizador o = new Organizador(codigoUnico, cedula, nombres, apellidos, usuario, contrasena, correo, TipoUsuario.O, empresa, cargo);
        usuarios.add(o);
    }
}
    public void cargarPartidos(String ruta) {

        ArrayList<String> lineas = ManejoArchivos.LeeFichero(ruta);

        for (int i = 1; i < lineas.size(); i++) {

            String[] d = lineas.get(i).split("\\|");

            Partido p = new Partido(
                    d[0], 
                    d[1], 
                    d[2], 
                    d[3], 
                    d[4], 
                    Integer.parseInt(d[6]), 
                    d[5], 
                    Integer.parseInt(d[7]), 
                    Integer.parseInt(d[8]), 
                    Integer.parseInt(d[9]), 
                    d[10] 
            );

            partidos.add(p);
        }
    }

    
    public void cargarKits(String ruta) {

        ArrayList<String> lineas = ManejoArchivos.LeeFichero(ruta);

    for (int i = 1; i < lineas.size(); i++) {

        String[] d = lineas.get(i).split("\\|");

        String codigo = d[0];
        String nombre = d[1];
        String descripcion = d[2];

        String[] codigosPartidos = d[3].split(",");

        double precio = Double.parseDouble(d[4]);
        int disponibles = Integer.parseInt(d[5]);

        ArrayList<Partido> partidosKit = new ArrayList<>();

        for (String cod : codigosPartidos) {
            Partido p = buscarPartido(cod.trim());
            if (p != null) {
                partidosKit.add(p);
            }
        }

        Kit k = new Kit(
                codigo,
                nombre,
                descripcion,
                partidosKit,
                precio,
                disponibles);

        kits.add(k);
    }
}

    public void cargarCompras(String ruta) {

    ArrayList<String> lineas = ManejoArchivos.LeeFichero(ruta);

    for (int i = 1; i < lineas.size(); i++) {

        String[] d = lineas.get(i).split("\\|");

        String codigo = d[0];
        TipoCompra tipo = TipoCompra.valueOf(d[1]);
        String codigoReferencia = d[2];
        Date fecha = parsearFecha(d[3]);
        int cantidad = Integer.parseInt(d[4]);
        double valorPagado = Double.parseDouble(d[5]);
        String codigoAficionado = d[6];

        Compra c = new Compra(codigo, tipo, codigoReferencia, fecha,
                cantidad, valorPagado, codigoAficionado);
        compras.add(c);
        Compra.actualizarContadorDesdeCodigo(codigo);
    }
}

private Date parsearFecha(String fechaTexto) {
    try {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.parse(fechaTexto);
    } catch (ParseException e) {
        System.out.println("Error al leer la fecha: " + fechaTexto);
        return new Date();
    }
}

    public Partido buscarPartido(String codigo) {

        for (Partido p : partidos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }

        return null;
    }


    public Kit buscarKit(String codigo) {

        for (Kit k : kits) {
            if (k.getCodigo().equalsIgnoreCase(codigo)) {
                return k;
            }
        }

        return null;
    }


    public void mostrarPartidos() {
        for (Partido p : partidos) {
            System.out.println(p);
        }
    }


    public void mostrarKits() {
        for (Kit k : kits) {
            System.out.println(k);
        }
    }


    // Sistema de notificaciones

    public void notificar(Aficionado aficionado, Compra compra) {

    System.out.println("Correo: " + aficionado.getCorreo());
    System.out.println("Codigo de compra: " + compra.getCodigo());
    System.out.println("Codigo del partido: " + compra.getCodigoReferencia());
    System.out.println("Cantidad: " + compra.getCantidad());
    System.out.println("Valor pagado: " + compra.getValorPagado());
    System.out.println("Fecha: " + compra.getFechaCompra());
}

public void notificar(Aficionado aficionado, Compra compra, Kit kit) {

    System.out.println("Correo: " + aficionado.getCorreo());
    System.out.println("Codigo de compra: " + compra.getCodigo());
    System.out.println("Nombre del kit: " + kit.getNombre());
    System.out.println("Partidos incluidos: " + kit.getPartidosIncluidos());
    System.out.println("Precio: " + kit.getPrecio());
    System.out.println("Fecha: " + compra.getFechaCompra());
}

public void notificar(Organizador organizador, Reporte reporte) {

    System.out.println("Correo: " + organizador.getCorreo());
    System.out.println("Fecha: " + reporte.getFechaGen());
    System.out.println("Total de compras: " + reporte.getTotalCompras());
    System.out.println("Total de entradas: " + reporte.getTotalEntradas());
    System.out.println("Total de kits: " + reporte.getTotalKits());
    System.out.println("Monto total: " + reporte.getMontoTotal());
}

}