package introduccion;

class Tarea2 extends Thread {
    private int numHilo;

    public Tarea2(int numHilo) {
        this.numHilo = numHilo;
        System.out.println("Hilo #: " + numHilo);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hilo [" + numHilo + ", " + "i: " + i + "]");
        }
    }
}

public class Hilos_04 {
    public static void main(String[] args) {
        System.out.println("INICIO");

        for(int i=0; i< 10; i++) {
            Thread hilo = new Thread(new Tarea2(i));
            hilo.start();
        }

        System.out.println("FIN");

    }
}
