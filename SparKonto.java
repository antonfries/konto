package antonfries.konto;

public class SparKonto extends Konto {
    private static double sparZins = 1.0;
    private static int nextSparKtoNr = 5000;
    public final String TYP = "Spar";

    public SparKonto(String inhaber, double betrag) {
        super(inhaber, betrag);
    }

    @Override
    protected int erzeugeNummer() {
        return nextSparKtoNr++; // Postfix-Technik
    }

    @Override
    public void abrechnen() {
        betrag *= sparZins;
    }

    public static void setSparZins(double sparZins) {
        SparKonto.sparZins = sparZins;
    }

    public static double getSparZins() {
        return sparZins;
    }

    @Override
    public String getKontoTyp() {
        return TYP;
    }

    @Override
    public void print() {
        System.out.println(getKontoTyp() + "Konto{" +
                "betrag=" + betrag +
                ", nummer=" + nummer +
                '}');
    }
}
