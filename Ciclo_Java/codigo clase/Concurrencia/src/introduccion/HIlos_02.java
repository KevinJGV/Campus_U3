package introduccion;

public class HIlos_02 extends Thread {
    @Override
    public void run() {
        System.out.println("El hilo está en ejecución");
    }

    public static void main(String[] args) {
        HIlos_02 hilo = new HIlos_02();

        System.out.println("Ejecución metodo MAIN");
        hilo.start();
        System.out.println("Ejecución metodo FIN");
    }
}
