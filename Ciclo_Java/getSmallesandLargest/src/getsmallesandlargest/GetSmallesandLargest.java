package getsmallesandlargest;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Arrays;

public class GetSmallesandLargest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern regexp = Pattern.compile("[a-zA-Z]");
        System.out.print("Cadena a operar:");
        String baseString = "";
        do {
            baseString = scanner.nextLine().toLowerCase().trim().intern();
        } while ((baseString.isEmpty() || baseString.length() > 1000) || !regexp.matcher(baseString).find());

        System.out.print("Longitud de subcadenas (mayor a la longitud de la cadena base):");
        int len_str;
        do {
            len_str = scanner.nextInt();
        } while (baseString.length() <= len_str);


        String substrings = "";
        int i = 0;
        while (i + len_str < baseString.length()) {
            substrings += baseString.substring(i,i + len_str) + ",";
            i++;
        };
        String[] res = substrings.split(",");
        Arrays.sort(res);
        String formatRes = "";
        for (int j = 0; j < res.length ; j++) {
            if (j != res.length - 1) {
                formatRes += "'" + res[j] + "', ";
            } else formatRes += "'" + res[j] + "'";

        }
        System.out.println(formatRes);
    }
}