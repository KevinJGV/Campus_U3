import javax.swing.*;
import java.util.regex.Pattern;

public class Adivinacion {
    private int numero;

    public Adivinacion() {
        numero = (int) Math.ceil(Math.random() * 1000);
         JOptionPane.showMessageDialog(null,"Juego inicializado, bienvenido","Adivinar el numero.exe",1);
    }

    public void reinicialización() {
        this.numero = (int) Math.ceil(Math.random() * 1000);
    }

    public int tryInput() {
        Pattern p = Pattern.compile("[0-9]");
        String res;
        do {
            res = JOptionPane.showInputDialog(null,"Adivine un número entre 1 y 1000.","Adivinar el numero.exe",1);
        } while (res.isEmpty() || !p.matcher(res).find());

        return Integer.parseInt(res);
    }

    public int getNumero() {
        return this.numero;
    }

    public void pista() {
        JOptionPane.showMessageDialog(null,"Juego inicializado, bienvenido","Adivinar el numero.exe",1);
    }

    public int messages(int option,int intentos) {
        switch (option) {
            case 1:
                switch (JOptionPane.showConfirmDialog(null,"Demasiado alto. Intente de nuevo.\n¿Desea reducir a la mitad las opciones disponibles?","Adivinar el numero.exe",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)) {
                    case 0:
                        this.pista();
                    default:
                        break;
                }
                break;
            case 2:
                switch (JOptionPane.showConfirmDialog(null,"Demasiado bajo. Intente de nuevo.\n¿Desea reducir a la mitad las opciones disponibles?","Adivinar el numero.exe",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)) {
                    case 0:
                        this.pista();
                    default:
                        break;
                }
                break;
            case 3:
                int seleccion;
                if (intentos == 10) {
                    seleccion = Integer.parseInt(String.valueOf(JOptionPane.showConfirmDialog(null,"¡Aja! ¡Sabía usted el secreto!\nFelicidades. ¡Adivino el numero!\n¿Desea repetir el juego?","Adivinar el numero.exe",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)));
                } else if (intentos < 10) {
                    seleccion = Integer.parseInt(String.valueOf(JOptionPane.showConfirmDialog(null,"¡O ya sabía usted el secreto, o tuvo suerte!\nFelicidades. ¡Adivino el numero!\n¿Desea repetir el juego?","Adivinar el numero.exe",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)));
                } else {
                    seleccion = Integer.parseInt(String.valueOf(JOptionPane.showConfirmDialog(null,"¡Debería haberlo hecho mejor!\nFelicidades. ¡Adivino el numero!\n¿Desea repetir el juego?","Adivinar el numero.exe",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)));
                }
                return seleccion;
            default:
                JOptionPane.showMessageDialog(null,"Juego finalizado, vuelve pronto :)","Adivinar el numero.exe",1);
        }
        return 0;
    }

    public void jugar() {
        boolean jugando = true;
        int intentos = 1;
        while (jugando) {
            System.out.println(this.getNumero());
            int intento = this.tryInput();
            if (intento == this.getNumero()) {
                intentos = this.messages(3, intentos);
                System.out.println(intentos);
                switch (intentos) {
                    case 0:
                        this.reinicialización();
                        intentos = 0;
                        break;
                    default:
                        jugando = false;
                }
            } else if (intento < this.getNumero()) {
                this.messages(2, intentos);
            } else this.messages(1, intentos);
            intentos++;
        }
        this.messages(0,0);
    }

    public static void main(String[] args) {
        Adivinacion Juego = new Adivinacion();
        Juego.jugar();
    }
}