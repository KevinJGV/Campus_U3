public class Telefono {
    private String modelo;
    private Bateria bateria;
    private int nChips;
    private Chip[] chips;

    public Telefono(String modelo, int cantMAh, String marcaBateria) {
        this.modelo = modelo;
        this.bateria = new Bateria(cantMAh,marcaBateria);
        this.nChips = 0;
        this.chips = new Chip[2];
    }

    @Override
    public String toString() {

        return "Modelo: " + modelo + bateria + "\nN Chips: " + nChips + (for ());
    }
}
