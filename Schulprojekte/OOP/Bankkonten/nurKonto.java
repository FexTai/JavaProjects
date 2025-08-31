import java.util.Scanner;

public class nurKonto {
    private String iban;
    private double kontostand;

    public void eingabe(Scanner scanner) {
        System.out.println("Gib die IBAN an: ");
        iban = scanner.nextLine();
        System.out.println("Gib deinen Kontostand an: ");
        kontostand = scanner.nextDouble();
        scanner.nextLine(); // Eingabepuffer leeren
    }

    public void ausgabe() {
        System.out.println("IBAN: " + iban);
        System.out.println("Kontostand: " + Math.round(kontostand * 100) / 100.0 + "€");
    }

    public void einzahlung(double betrag) {
        kontostand += betrag;
    }

	//Auszahlung ohne ins negative zu gehen
    public boolean auszahlung(double betrag) {
        if (kontostand >= betrag) {
            kontostand -= betrag;
            return true;
        }
        return false;
    }
}
