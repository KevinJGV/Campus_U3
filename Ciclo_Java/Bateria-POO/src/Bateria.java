public class Bateria {
    private int mAh;
    private String marca;
    public Bateria(int mAh, String marca) {
        this.mAh = mAh;
        this.marca = marca;
    }
    @Override
    public String toString() {
        return "\nCantidad mAh: " + mAh + "\nMarca: " + marca;
    }
}