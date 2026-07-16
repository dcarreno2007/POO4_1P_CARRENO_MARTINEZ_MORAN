package com.example.SistemaJuegos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Permite leer información desde archivos de texto
 * y escribir nuevas líneas en ellos.
 *
 * @author Daniel Carreño
 * @version 1.0
 */

public class ManejoArchivos {

    /**
     * Lee todas las líneas de un archivo de texto.
     *
     * @param nombrearchivo nombre o ruta del archivo que será leído
     * @return lista con las líneas encontradas en el archivo
     */

    public static ArrayList<String> LeeFichero(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;
    }

    /**
     * Escribe una nueva línea en el archivo indicado.
     *
     * @param nombreArchivo nombre o ruta del archivo
     * @param linea texto que será agregado al archivo
     */

    public static void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;

        try {
            fichero = new FileWriter(nombreArchivo, /* append: */ true);
            bw = new BufferedWriter(fichero);
            bw.write(linea + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fichero != null) {
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
