package com.example.SistemaJuegos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Aficionado extends Usuario{
    private String paisFav;
    private String celular;

<<<<<<< HEAD

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
    public void consultarEntradas(){
        System.out.println("Codigo: " + codigoUnico);
=======
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
>>>>>>> c0c1aa5633d85389bd98fd13e74032bc4e20036b
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


    @Override
    public String toString() {
        return super.toString() + " - pais favorito = " + this.paisFav + " - celular = " + this.celular;
    }


}
