package antonfries.konto;

public abstract class Konto {

    private String inhaber;
    protected double betrag;
    protected int nummer;
    private static int nextKtoNr = 1000;

    public Konto(String inhaber) {
        this(inhaber, 0.0);
    }

    public Konto(String inhaber, double betrag) {
        this.inhaber = inhaber;
        this.betrag = betrag;
        nummer = erzeugeNummer();
    }

    protected int erzeugeNummer() {
        return nextKtoNr++; // Postfix-Technik
    }

    public void einzahlen(double betrag) {
        if (betrag > 0) {
            this.betrag += betrag;
        }
    }

    public double abheben(double betrag) {
        if (this.betrag >= betrag) {
            this.betrag -= betrag;
            return betrag;
        }
        return 0.0;
        // Anmerkung: Kontostand 50€ Auszahlung 65€: Leere Auszahlung statt 50€ Auszahlung
    }

    public void print() {
        System.out.println("Konto{" +
                "inhaber='" + inhaber + '\'' +
                ", betrag=" + betrag +
                ", nummer=" + nummer +
                '}');
    }

    public abstract void abrechnen();

    public abstract String getKontoTyp();
}
