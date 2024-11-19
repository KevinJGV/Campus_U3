
// Cree una clase llamada Cuenta DeAhorros. Use una variable static llamada tasaInteresAnual para almacenar la tasa de interés anual para todos los cuentahabientes. Cada objeto de la clase debe contener una variable de instancia private llamada. saldoAhorros, que indique la cantidad que el ahorrador tiene actualmente en depósito. Proporcione el método calcular InteresMensual para calcular el interés mensual, multiplicando el saldoAhorros por la tasalnteresAnual dividida entre 12; este interés debe sumarse al saldoAhorros. Proporcione un método static llamado modificar TasaInteres para establecer la tasaInteresAnual en un nuevo valor. Escriba' un programa para probar la clase CuentaDeAhorros. Cree dos instancias de objetos CuentaDeAhorros, ahorrador1 y ahorrador2, con saldos de $2000.00 y $3000.00 respectivamente. Establezca la tasaInteresAnual en 4%, después calcule el interés mensual para cada uno de los 12 meses e imprima los nuevos saldos para ambos ahorradores. Luego establezca la tasaInteresAnual en 5%, calcule el interés del siguiente mes e imprima los nuevos saldos para ambos ahorradores.

import java.text.DecimalFormat;

public class CuentaDeAhorros {
    private static boolean tasaInteresAnualSetted = false;
    private static float tasaInteresAnual;
    private double saldoAhorros = 0D;

    public CuentaDeAhorros(Float tasaInteresAnual, double saldoAhorros) {
        setTasaInteresAnual(tasaInteresAnual);
        setSaldoAhorros(saldoAhorros);
    }

    public CuentaDeAhorros(double saldoAhorros) {
        setSaldoAhorros(saldoAhorros);
    }

    public static void setTasaInteresAnual(Float tasaInteresAnual) {
        if (!tasaInteresAnualSetted) {
            if (tasaInteresAnual == null) {
                CuentaDeAhorros.tasaInteresAnual = 2F;
            } else CuentaDeAhorros.tasaInteresAnual = tasaInteresAnual;
            CuentaDeAhorros.tasaInteresAnualSetted = true;
        } else System.out.println("No permitido. Utilice el metodo 'modificarTasaInteres()' para establecer la tasaInteresAnual en un nuevo valor.");
    }

    public static void modificarTasaInteres(Float tasaInteresAnual) {
        if (tasaInteresAnual == null) {
            System.out.println("Proporcíone una tasa válida.");
        } else CuentaDeAhorros.tasaInteresAnual = tasaInteresAnual;
    }

    public float getTasaInteresAnual() {
        return CuentaDeAhorros.tasaInteresAnual;
    }

    public Double getSaldoAhorros() {
        return this.saldoAhorros;
    }

    public void setSaldoAhorros(Double saldoAhorros) {
        if (saldoAhorros == null || saldoAhorros <= 0) {
            System.out.println("Ingrese un saldo correcto");
        } else this.saldoAhorros = saldoAhorros;
    }

    public Double calcularInteresMensual () {
        return ((getSaldoAhorros() * getTasaInteresAnual()) / 12);
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.00");
        CuentaDeAhorros ahorrador1 = new CuentaDeAhorros(0.04F, 2000D);
        CuentaDeAhorros ahorrador2 = new CuentaDeAhorros(3000D);
        for (int i = 1; i < 14; i++) {
            if (i != 13) {
                ahorrador1.setSaldoAhorros(ahorrador1.getSaldoAhorros() - ahorrador1.calcularInteresMensual());
                System.out.println("Mes " + i + " al " + ahorrador1.getTasaInteresAnual() + " - Interes Pagado: " + df.format(ahorrador1.calcularInteresMensual())  + " | Saldo: " + df.format(ahorrador1.getSaldoAhorros()));
            } else {
                CuentaDeAhorros.modificarTasaInteres(0.05F);
                ahorrador1.setSaldoAhorros(ahorrador1.getSaldoAhorros() - ahorrador1.calcularInteresMensual());
                System.out.println("Mes " + i + " al " + ahorrador1.getTasaInteresAnual() + " - Interes Pagado: " + df.format(ahorrador1.calcularInteresMensual())  + " | Saldo: " + df.format(ahorrador1.getSaldoAhorros()));
            }
        }
    }
}