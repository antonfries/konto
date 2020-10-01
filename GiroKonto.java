package antonfries.konto;

public class GiroKonto extends Konto {

    private int transaktionen;
    public final String TYP = "Giro";

    public GiroKonto(String inhaber, double betrag) {
        super(inhaber, betrag);
    }

    @Override
    public void einzahlen(double betrag) {
        transaktionen++;
        super.einzahlen(betrag);
    }

    @Override
    public double abheben(double betrag) {
        transaktionen++;
        return super.abheben(betrag);
    }

    @Override
    public void abrechnen() {
        // Anmerkung: Kontostand kann auch ins negative rutschen
        betrag -= 0.5 * transaktionen; // TODO: In Konstante auslagern
    }

    @Override
    public String getKontoTyp() {
        return TYP;
    }

    @Override
    public void print() {
        System.out.println(getKontoTyp() + "Konto{" +
                "transaktionen=" + transaktionen +
                ", betrag=" + betrag +
                ", nummer=" + nummer +
                '}');
    }
}
