public class Chip {
    private String empresa;
    private int numero;

    public Chip(String empresa, int numero) {
        this.empresa = empresa;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "\nFabricante: " + empresa + "\nNumero: " + numero;
    }
}
