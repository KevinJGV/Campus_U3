public class Estudiante {
    private String nombre;
    private float n1;
    private float n2;
    private float n3;
    private float definitiva;

    public Estudiante() {
        nombre = "Pepito";
        n1 = 2.3F;
        n2 = 4.7F;
        n3 = 3.5F;
    }

    public Estudiante(String nombre , Float n1 , Float n2, Float n3) {
        this.nombre = nombre == null ? "Pepito" : nombre;
        this.n1 = n1 == null ? 2.3F : n1;
        this.n2 = n2 == null ? 4.7F : n2;
        this.n3 = n3 == null ? 3.5F : n3;
    }

    public float calcularProm() {
        definitiva = (this.n1 + this.n2 + this.n3) / 3;
        return definitiva;
    }

    public static void main(String[] args) {
        Estudiante pepito = new Estudiante();
        pepito.calcularProm();
        System.out.print(pepito.definitiva);
    }
}