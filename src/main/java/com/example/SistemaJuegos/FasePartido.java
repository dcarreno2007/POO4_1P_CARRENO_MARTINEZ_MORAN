package com.example.SistemaJuegos;

public enum FasePartido {
    FASE_DE_GRUPOS("Fase de Grupos"), 
    DIECISEISAVOS("Dieciseisavos"), 
    OCTAVOS_DE_FINAL("Octavos de Final"), 
    CUARTOS_DE_FINAL("Cuartos de Final"), 
    SEMIFINAL("Semifinal"), 
    FINAL("Final");

    private String descripcion;

    FasePartido(String descripcion){
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){
        return descripcion;
    }
}
