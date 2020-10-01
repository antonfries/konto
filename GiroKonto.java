package antonfries.konto;

public class GiroKonto extends Konto implements Cloneable {

    private int transaktionen;
    public final String TYP = "Giro";
    public final double KOSTEN_PRO_TRANSAKTION = 0.5;

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
        double abgehobenerBetrag = super.abheben(betrag);
        if (abgehobenerBetrag > 0) {
            transaktionen++;
        }
        return abgehobenerBetrag;
    }

    @Override
    public void abrechnen() {
        double negativBetrag = KOSTEN_PRO_TRANSAKTION * transaktionen;
        if (betrag - negativBetrag < 0) {
            throw new RuntimeException("Bitte überweisen Sie genug Geld, um die Transaktions-Kosten auszugleichen!");
        } else {
            betrag -= negativBetrag;
        }
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

    @Override
    protected GiroKonto clone() throws CloneNotSupportedException {
        return (GiroKonto) super.clone();
    }
}
