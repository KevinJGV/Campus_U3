package com.mycompany.olympusclub;

import java.util.List;

public class Equipo {
    private int id;
    private String nombre;
    private String categoria; 
    private Entrenador entrenador;
    private List<Deportista> deportistas; 

    public Equipo(int id, String nombre, String categoria, Entrenador entrenador, List<Deportista> deportistas) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.entrenador = entrenador;
        this.deportistas = deportistas;
    }

       
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public Entrenador getEntrenador() { return entrenador; }
    public void setEntrenador(Entrenador entrenador) { this.entrenador = entrenador; }
    public List<Deportista> getDeportistas() { return deportistas; }
    public void setDeportistas(List<Deportista> deportistas) { this.deportistas = deportistas; }

    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' + ", entrenador=" + entrenador +
                ", deportistas=" + deportistas + '}';
    }
}
