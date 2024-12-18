import java.util.Scanner;
import java.util.regex.Pattern;
//aaabaasssszxzzzxx
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern regexp = Pattern.compile("[a-zA-Z]");
        System.out.print("Cadena a operar:");
        String baseString = "";
        do {
            baseString = scanner.nextLine().toLowerCase().trim().intern();
        } while (baseString.isEmpty() || !regexp.matcher(baseString).find());

        String finalString = "";
        int i = 0;
        while (i <= baseString.length() - 1) {
            if (i != baseString.length() - 1) {
                if (baseString.charAt(i) == baseString.charAt(i+1)) {
                    baseString =  baseString.substring(2);
                } else {
                    finalString += baseString.charAt(i);
                    i++;
                }
            } else {
                finalString += baseString.charAt(i);
                i++;
            }
        }
        if (finalString.isEmpty()) {
            System.out.println("Cadena reducida: Empty String");
        } else {
            System.out.println("Cadena reducida: " + finalString);
        }
    }
}