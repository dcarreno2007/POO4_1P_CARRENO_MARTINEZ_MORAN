package com.example.SistemaJuegos;

public class Organizador extends Usuario{
    private String empresa;
    private String cargo;

    public Organizador(String codigoUnico,String cedula, String nombres,String apellidos, String usuario,String contra, String correo, TipoUsuario rol, String empresa, String cargo){
        super(codigoUnico, cedula, nombres, apellidos, usuario, contra, correo, rol);
        this.empresa = empresa;
        this.cargo = cargo;
    }
    
    @Override
    public void consultarEntradas(){
        System.out.println("Compras registradas en el sistema");
    }

    public String getEmpresa(){
        return empresa;
    }
    public String getCargo(){
        return cargo;
    }

    public void setEmpresa(String empresa){
        this.empresa = empresa;
    }
    public void setCargo(String cargo){
        this.cargo = cargo;
    }



    

    

}
