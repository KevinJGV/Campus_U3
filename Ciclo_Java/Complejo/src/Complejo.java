public class Complejo {
    private double real;
    private double imaginaria;

    public Complejo(double real, double imaginaria) {
        this.real = real;
        this.imaginaria = imaginaria;
    }

    public Complejo() {
        this.real = 1.0D;
        this.imaginaria = 1.0D;
    }

    public double setReal(Double real) {
        if (real == null) {
            this.real = 1.0D;
        } else this.real = real;
        return this.real;
    }

    public double setImaginaria(Double imaginaria) {
        if (imaginaria == null) {
            this.imaginaria = 1.0D;
        } else this.imaginaria = imaginaria;
        return this.imaginaria;
    }

    public void sumaComplejo() {
        double real1 = this.real;
        double real2 = setReal(60.D);
        double imaginaria1 = this.imaginaria;
        double imaginaria2 = setImaginaria(35.5D);
        System.out.println("(" + real1 + " + " + real2 + ") + (" + imaginaria1 + " + " + imaginaria2 + ")i = " + (real1 + real2) + " + " + (imaginaria1 + imaginaria2) + "i");
    }

    public void restaComplejo() {
        double real1 = this.real;
        double real2 = setReal(60.D);
        double imaginaria1 = this.imaginaria;
        double imaginaria2 = setImaginaria(35.5D);

        System.out.println("(" + real2 + " - " + real1 + ") + (" + imaginaria2 + " - " + imaginaria1 + ")i = " + (real2 - real1) + " + " + (imaginaria2 - imaginaria1) + "i");
    }
}

class PruebaComplejo {
    public static void main(String[] args) {

        Complejo c = new Complejo();
        c.setReal(27.8D);
        c.setImaginaria(20.0D);
        c.sumaComplejo();
        c.setReal(27.8D);
        c.setImaginaria(20.0D);
        c.restaComplejo();

    }
}

