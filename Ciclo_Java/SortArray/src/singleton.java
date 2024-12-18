import java.util.Arrays;
import java.util.Comparator;

public class singleton {
    public static void main(String[] args) {
        String[] nomes = {"Pedro", "Mano", "bien", "alicia", "vin"};

        Arrays.sort(nomes);

//        for (String nome : nomes) {
//            System.out.println(nome);
//        }

        Arrays.sort(nomes, new Comparator<String>() {
            @Override
            public int compare(String o1,String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}