package com.example.SistemaJuegos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
            System.out.println("   - GENERAL       | Disponibles: " + partido.getEntradasGeneral());
            System.out.println("   - PREFERENCIAL  | Disponibles: " + partido.getEntradasPreferencial());
            System.out.println("   - VIP           | Disponibles: " + partido.getEntradasVIP());

            System.out.println("--------------------------------------------------");
            contador++;
        }
    }


    @Override
    public void consultarEntradas(){
        System.out.println("Codigo: " + codigoUnico);
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
