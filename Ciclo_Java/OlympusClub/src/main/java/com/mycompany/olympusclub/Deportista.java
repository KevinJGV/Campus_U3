
package com.mycompany.olympusclub;


public class Deportista {
    private int id;
    private String nombre;
    private int edad;
    private String deporte;

    public Deportista(int id, String nombre, int edad, String deporte) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.deporte = deporte;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getDeporte() { return deporte; }
    public void setDeporte(String deporte) { this.deporte = deporte; }

    @Override
    public String toString() {
        return "Deportista{" + "id=" + id + ", nombre='" + nombre + '\'' +
                ", edad=" + edad + ", deporte='" + deporte + '\'' + '}';
    }
}

