public class Estudiante extends Usuario {
    protected int codigoEstudiante;

    public Estudiante(String nombre, String apellido, int codigoEstudiante) {
        super(nombre, apellido);
        this.codigoEstudiante = codigoEstudiante;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }
}
