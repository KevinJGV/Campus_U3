
package com.mycompany.olympusclub;


import java.util.Date;
import java.util.List;

public class Entrenamiento {
    private int id;
    private Date fecha;
    private String lugar;
    private int duracion; // En minutos
    private List<Equipo> equipos;

    public Entrenamiento(int id, Date fecha, String lugar, int duracion, List<Equipo> equipos) {
        this.id = id;
        this.fecha = fecha;
        this.lugar = lugar;
        this.duracion = duracion;
        this.equipos = equipos;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }
    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
    public List<Equipo> getEquipos() { return equipos; }
    public void setEquipos(List<Equipo> equipos) { this.equipos = equipos; }

    @Override
    public String toString() {
        return "Entrenamiento{" + "id=" + id + ", fecha=" + fecha +
                ", lugar='" + lugar + '\'' + ", duracion=" + duracion +
                ", equipos=" + equipos + '}';
    }
}


