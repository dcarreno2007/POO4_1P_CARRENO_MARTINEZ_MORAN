package com.example.SistemaJuegos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Aficionado extends Usuario{
    private String paisFav;
    private String celular;

    public Aficionado(String codigo_unico, String cedula, String nombres, String apellidos, String celular, String paisFav, String usuario, String correo) {
        super(codigo_unico, cedula, nombres, apellidos, usuario, correo, TipoUsuario.AFICIONADOS);
        this.celular = celular;
        this.paisFav = paisFav;
    }

    public Aficionado(String codigo_unico, String cedula, String nombres, String apellidos, String celular, String paisFav) {
        super(codigo_unico, cedula, nombres, apellidos, null, null, TipoUsuario.AFICIONADOS);
        this.celular = celular;
        this.paisFav = paisFav;
    }
    
    public void consultarPartidos(){
        System.out.println("Codigo: " + codigo_unico);
        System.out.println("Partido: ");
        System.out.println("Fecha: " );
    }

    public static ArrayList<Aficionado> cargarAficionados(String ruta) {
        ArrayList<Aficionado> aficionados = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(ruta))) {
            String line;
            line = bf.readLine();
            while ((line = bf.readLine()) != null) {
                String [] aficionadoL = line.split("|");
                String CodigoUnico = aficionadoL[0];
                String Cedula = aficionadoL[1];
                String Nombres = aficionadoL[2];
                String Apellidos = aficionadoL[3];
                String Celular = aficionadoL[5];
                String PaisFavorito = aficionadoL[6];
                aficionados.add(new Aficionado(CodigoUnico, Cedula, Nombres, Apellidos, Celular, PaisFavorito));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aficionados;
    }


}
