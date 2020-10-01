package antonfries.konto;


public class Main {
    public static void main(String[] args) {
        GiroKonto k1 = new GiroKonto("Anton Fries", 1350.50);
        Konto k2 = new GiroKonto("Katharina Fries", 7830.20);
        Konto s1 = new SparKonto("Anton Fries", 2000);
        Konto s2 = new SparKonto("Katharina Fries", 7000);

        System.out.println("Abgehoben von k1: " + k1.abheben(1500)); // 1350.50
        System.out.println("Abgehoben von k1: " + k1.abheben(1200)); // 150.50
        k2.einzahlen(2500); // 10330.20
        k1.einzahlen(900); // 1050.50

        s1.einzahlen(1500);
        s1.einzahlen(500);

        try {
            // Ich will kein Geld durch die Transaktions-Kosten verlieren !!!
            GiroKonto k3 = k1.clone();
            System.out.println("Abgehoben von k1: " + k3.abheben(1050)); // 0.50
            k3.print();
            k3.abrechnen(); // 0.50 - 1 < 0
        } catch (RuntimeException | CloneNotSupportedException e) {
            // Ja, schade aber auch!
            System.out.println("[FEHLER] " + e.getMessage());
        }
        k1.abrechnen(); // 2 Transaktionen und eine misslungene: 1049.5
        k2.abrechnen(); // 1 Transaktion: 10329.70
        s1.abrechnen();
        System.out.println("Aktueller Sparzins: " + SparKonto.getSparZins());
        SparKonto.setSparZins(1.2);
        System.out.println("Neuer Sparzins: " + SparKonto.getSparZins());
        s2.abrechnen();

        k1.print();
        k2.print();
        s1.print();
        s2.print();
    }
}
