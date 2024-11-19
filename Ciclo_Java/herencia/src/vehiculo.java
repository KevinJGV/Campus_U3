public class vehiculo {
    protected int precioDia;
    protected String marcaModelo;
    protected  int numllantas;

    public vehiculo(String marcaModelo, int precioDia, int numllantas) {
        this.marcaModelo = marcaModelo;
        this.precioDia = precioDia;
        this.numllantas = numllantas;
        System.out.println("Vehiculo construido");
    }

    public int getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(int precioDia) {
        this.precioDia = precioDia;
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public int getNumllantas() {
        return numllantas;
    }

    public void setNumllantas(int numllantas) {
        this.numllantas = numllantas;
    }

    public void mostrarCaracteristicas(){
        System.out.println("Marca: " + marcaModelo + "\nPrecio: " + precioDia + "\nNumero de llantas: " + numllantas);
    }

    public void encenderMotor(){
        System.out.println("Motor encendido.");
    }

    public void apagarMotor(){
        System.out.println("Motor apagado.");
    }

    public void funciona() {
        System.out.println("¡Motor de " + marcaModelo + " funciona correctamente!");
    }

    public static void main(String[] args) {
        vehiculo motorcito = new vehiculo("Honda - XR", 80, 4);
    }
}
