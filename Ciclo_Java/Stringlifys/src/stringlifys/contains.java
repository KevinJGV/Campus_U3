import java.util.Scanner;

// Este ejercicio utiliza el metodo contains para informarle al usuario si el texto ingresado por este es contenido en la letra de la cancion Black Sheep del artista Metric
public class contains {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Cadena a encontrar en 'Black Seep - Metric': ");
        String cadena = "";
        do {
            cadena = scanner.nextLine().toLowerCase().intern();
        } while (cadena.isEmpty());
        String lyrics = "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Black sheep, come home\n" +
                "Hello again, friend of a friend, I knew you when\n" +
                "Our common goal was waiting for the world to end\n" +
                "Now that the truth is just a rule that you can bend\n" +
                "You crack the whip, shape-shift and trick the past again\n" +
                "I'll send you my love on a wire\n" +
                "Lift you up, every time, everyone, ooh, pulls away, ooh\n" +
                "From you\n" +
                "Got balls of steel, got an automobile, for a minimum wage\n" +
                "Got real estate, I'm buying it all up in outer space\n" +
                "Now that the truth is just a rule that you can bend\n" +
                "You crack the whip, shape-shift and trick the past again\n" +
                "I'll send you my love on a wire\n" +
                "Lift you up, every time, everyone, ooh, pulls away, ooh\n" +
                "It's a mechanical bull, the number one\n" +
                "You'll take a ride from anyone\n" +
                "Everyone wants a ride, pulls away, ooh, from you".toLowerCase();
        if (lyrics.contains(cadena)) System.out.println("'" + cadena + "' se encuentra en la letra.");
    }

}
