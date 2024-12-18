package introduccion;

class Tarea extends Thread {
    @Override
    public void run() {
        for(int i=1; i<10; i++) {
            System.out.println("Hilo [" + i + "] en ejecución");
        }
    }
}

public class Hilo_03 {
    public static void main(String[] args) {
        Tarea t = new Tarea();
        System.out.println("INICIO");
        t.start();
        System.out.println("FIN");
    }
}
