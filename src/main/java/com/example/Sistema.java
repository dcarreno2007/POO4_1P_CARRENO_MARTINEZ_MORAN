package com.example;
import java.util.ArrayList;

import com.example.SistemaJuegos.Kit;
import com.example.SistemaJuegos.ManejoArchivos;
import com.example.SistemaJuegos.Partido;


public class Sistema{
    private ArrayList<Partido> partidos = new ArrayList<>();
    private ArrayList<Kit> kits = new ArrayList<>();


    public static void main(String[] args) {

        Sistema s = new Sistema();

        s.cargarPartidos("C:\\Users\\USER\\POO4_1P_CARRENO_MARTINEZ_MORAN\\src\\main\\java\\com\\example\\SistemaJuegos\\partidos.txt");
        s.cargarKits("src/main/java/com/example/SistemaJuegos/kits.txt");

        System.out.println("=== PARTIDOS ===");
        s.mostrarPartidos();

        System.out.println("\n=== KITS ===");
        s.mostrarKits();
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
}

    