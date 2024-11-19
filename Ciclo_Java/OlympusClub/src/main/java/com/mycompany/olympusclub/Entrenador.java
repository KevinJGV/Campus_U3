package com.mycompany.olympusclub;

public class Entrenador {
    private int id;
    private String nombre;
    private String especialidad;
    private int añosExperiencia;

    public Entrenador(int id, String nombre, String especialidad, int añosExperiencia) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public int getAniosExperiencia() { return añosExperiencia; }
    public void setAniosExperiencia(int añosExperiencia) { this.añosExperiencia = añosExperiencia; }

    @Override
    public String toString() {
        return "Entrenador{" + "id=" + id + ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' + ", añosExperiencia=" + añosExperiencia + '}';
    }
}

