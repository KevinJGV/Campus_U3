import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Estudiante {
    Scanner scanner = new Scanner(System.in);
    Pattern regexpN = Pattern.compile("[0-9]");
    Pattern regexpA = Pattern.compile("[a-zA-Z]");
    DecimalFormat dFormato =  new DecimalFormat("#.0");
    private int codigo;
    private String nombre;
    private float n1;
    private float n2;
    private float n3;
    private float definitiva;

    public Estudiante() {
        System.out.println("\nREGISTRO NUEVO\n");

        String codigo;
        System.out.print("Ingresar Codigo del estudiante: ");
        do {
            codigo = scanner.nextLine().trim().intern();
        } while (codigo.isEmpty() || !regexpN.matcher(codigo).find());

        setCodigo(Integer.parseInt(codigo));

        String nombre;
        System.out.print("Ingresar Nombre del estudiante: ");
        do {
            nombre = scanner.nextLine().trim().intern();
        } while (nombre.isEmpty() || !regexpA.matcher(nombre).find());

        setNombre(nombre);

        String n1;
        System.out.print("Ingresar Nota 1 (30%) del estudiante: ");
        do {
            n1 = scanner.nextLine().trim().intern();
        } while (n1.isEmpty() || !regexpN.matcher(n1).matches() || Float.parseFloat(n1) < 1.0 || Float.parseFloat(n1) > 5.0);

        setN1(Integer.parseInt(n1));

        String n2;
        System.out.print("Ingresar Nota 2 (30%) del estudiante: ");
        do {
            n2 = scanner.nextLine().trim().intern();
        } while (n2.isEmpty() || !regexpN.matcher(n2).matches() || Float.parseFloat(n2) < 1.0 || Float.parseFloat(n2) > 5.0);

        setN2(Integer.parseInt(n2));

        String n3;
        System.out.print("Ingresar Nota 3 (40%) del estudiante: ");
        do {
            n3 = scanner.nextLine().trim().intern();
        } while (n3.isEmpty() || !regexpN.matcher(n3).matches() || Float.parseFloat(n3) < 1.0 || Float.parseFloat(n3) > 5.0);

        setN3(Integer.parseInt(n3));
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public float getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public float getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    public float getDefinitiva() {
        return definitiva;
    }

    public void setDefinitiva(float definitiva) {
        this.definitiva = definitiva;
    }

    public void calcularDefinitiva() {
        setDefinitiva((float) ((getN1() * 0.3) + (getN2() * 0.3) + (getN3() * 0.4)));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, HashMap<String,String>> estudiantes = new HashMap();
        while (true) {
            Estudiante estudiante = new Estudiante();
            estudiante.calcularDefinitiva();

            HashMap<String, String> datosEstudiante = new HashMap();
            datosEstudiante.put("Nombre Estudiante", estudiante.getNombre());
            datosEstudiante.put("Codigo", String.valueOf(estudiante.getCodigo()));
            datosEstudiante.put("Nota 1", String.valueOf(estudiante.getN1()));
            datosEstudiante.put("Nota 2",String.valueOf(estudiante.getN2()));
            datosEstudiante.put("Nota 3",String.valueOf(estudiante.getN3()));
            datosEstudiante.put("Definitiva",String.valueOf(estudiante.getDefinitiva()));

            estudiantes.put(estudiante.getCodigo() + estudiante.getNombre(), datosEstudiante);

            System.out.println("¿Continuar con otro registro?\n[-1 - Para finalizar el registro y visualizar los resultados ingrese]    [Cualquier tecla - Continuar]");
            if (Objects.equals(scanner.nextLine(), "-1")) {
                break;
            }
        }

        System.out.println("Programa finalizado, mostrando resultados....");
        for (String key : estudiantes.keySet()) {
            boolean aprobo = false;
            System.out.println(("*".repeat(10)));
            for (Object dataKey: estudiantes.get(key).keySet()) {
                System.out.println(dataKey + ": " + estudiantes.get(key).get(dataKey));
                if (dataKey == "Definitiva" && Float.parseFloat(String.valueOf(dataKey)) >= 3F) {
                    aprobo = true;
                }
            }
            if (aprobo) {
                System.out.println("Estado: Estudiante Aprobado :)");
            } else System.out.println("Estado: Estudiante Reprobado");
            System.out.println(("*".repeat(10)));
        }
    }
}