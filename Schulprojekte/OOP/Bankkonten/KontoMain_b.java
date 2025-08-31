import java.util.Scanner;

public class KontoMain_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kunden kundenListe = new Kunden(5); 
        kundenListe.kundenErstellen();
        Kunde kunde;
        int eingabe = 0;
        int eingabeKunde = 0;
        int kundenIndex = 1, kontoIndex;
        Double betrag;

   		do {
            kunde = kundenListe.kunden[kundenIndex - 1]; // Kunde aktualisieren
			//Konten verwalten
            System.out.println("\nAktuell als " + kunde.getName() + " " + "(Kunde: " + (kundenIndex) + ")" + " angemeldet\n");	
            System.out.println("\nWählen Sie eine Option: ");
            System.out.println("1: Kundendaten eingeben");
            System.out.println("2: Kundendaten und Konten anzeigen");
            System.out.println("3: Neues Konto hinzufügen");
            System.out.println("4: Einzahlung auf ein Konto");
            System.out.println("5: Auszahlung von einem Konto");
            System.out.println("6: neuen Kunden erstellen");
   			System.out.println("7: Kunden wechseln?");
            System.out.println("0: Beenden");
            System.out.print("Ihre Wahl: ");

            // Eingabe einlesen
            eingabe = scanner.nextInt();
            scanner.nextLine();

			//Kontoeingabe Verwaltung
            switch (eingabe) {
                case 0:
                    System.out.println("\nProgramm wird beendet...");
                    break;

                case 1:
                    kunde.eingeben(scanner); // Scanner als Parameter übergeben
                    break;

                case 2:
                    System.out.println("\nKundendaten und Konten:");
                    kundenListe.kunden[kundenIndex - 1].ausgeben(); // Kundendaten und alle Konten anzeigen
                    break;

                case 3:
                    kundenListe.kunden[kundenIndex - 1].kontoHinzufügen(scanner); // Scanner als Parameter übergeben
                    break;

                case 4:
                    System.out.println("\nWählen Sie ein Konto für die Einzahlung (Index beginnt bei 1): ");
                    kontoIndex = scanner.nextInt() - 1; // Umwandlung Index
                    scanner.nextLine();

                    if (kunde.kontoAuswählen(kontoIndex) != null) {
                        System.out.print("Betrag für die Einzahlung: ");
                        betrag = scanner.nextDouble();
                        kunde.kontoAuswählen(kontoIndex).einzahlung(betrag);
                        System.out.println("Einzahlung erfolgreich.");
                    }
                    break;

                case 5:
                    System.out.println("\nWählen Sie ein Konto für die Auszahlung (Index beginnt bei 1): ");
                    kontoIndex = scanner.nextInt() - 1; // Umwandlung Index
                    scanner.nextLine();

                    if (kunde.kontoAuswählen(kontoIndex) != null) {
                        System.out.print("Betrag für die Auszahlung: ");
                        betrag = scanner.nextDouble();
                        if (!kunde.kontoAuswählen(kontoIndex).auszahlung(betrag)) {
                            System.out.println("Auszahlung fehlgeschlagen: Nicht ausreichender Kontostand.");
                        } else {
                            System.out.println("Auszahlung erfolgreich.");
                        }
                    }
                    break;

                case 6:
                    kundenListe.kundenErstellen();
                    break;

                case 7:
                    do{
                        System.out.println("Welcher Kunde? (1-" + Kunde.getKundenAnzahl() + "): ");
                        kundenIndex = scanner.nextInt(); scanner.nextLine();
                    }while(kundenIndex <= 0 || kundenIndex > Kunde.getKundenAnzahl());
                    kunde = kundenListe.kunden[eingabeKunde];
                    System.out.println("Du bist nun als Kunde Nummer " + kundenIndex + " gesetzt");
                    break;

                default:
                    System.out.println("\nUngültige Eingabe!");
                    break;
            }
        } while (eingabe != 0);

        scanner.close(); // Scanner schließen
    }
}
