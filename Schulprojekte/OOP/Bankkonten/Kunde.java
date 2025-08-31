import java.util.Scanner;

public class Kunde {
    private String vorname, nachname, strasse, ort, plz;
    private nurKonto[] konten;
    private static int kundenAnzahl = 0;
    private int aktuelleKonten = 0;
    private static final int MAX_KONTEN = 5;

    // Konstruktor
    public Kunde() {
        konten = new nurKonto[MAX_KONTEN];
        kundenAnzahl++;
    }

    // Eingabe
    public void eingeben(Scanner scanner) {
        int eingabe;
        System.out.println("Vorname: ");
        vorname = scanner.nextLine();
        System.out.println("Nachname: ");
        nachname = scanner.nextLine();
        System.out.println("Strasse: ");
        strasse = scanner.nextLine();
        System.out.println("Ort: ");
        ort = scanner.nextLine();
        System.out.println("PLZ: ");
        plz = scanner.nextLine();
        
        // Erstes Konto
        if(aktuelleKonten == 0){
            kontoHinzufügen(scanner);   
        }
        // Weitere Konten
        else{
            do{
                System.out.println("Welches Konto von Kunde " + vorname + " " + nachname + " soll bearbeitet werden?");
                System.out.println("Zur zeit gibt es " + aktuelleKonten + " Konten");
                eingabe = scanner.nextInt(); scanner.nextLine();
            }while(eingabe < 1 || eingabe > aktuelleKonten);
            konten[eingabe - 1].eingabe(scanner); // Scanner als Parameter übergeben
        }
    }

    // Ausgabe
    public void ausgeben() {
        System.out.println("Vorname: " + vorname);
        System.out.println("Nachname: " + nachname);
        System.out.println("Strasse: " + strasse);
        System.out.println("Ort: " + ort);
        System.out.println("PLZ: " + plz);

        System.out.println("Konten:");
        for (int i = 0; i < aktuelleKonten; i++) {
            if (konten[i] != null) {
                System.out.println("\nKonto " + (i + 1) + ":");
                konten[i].ausgabe();
            }
        }
    }

    // Konto hinzufügen
    public void kontoHinzufügen(Scanner scanner) {
        if (aktuelleKonten < MAX_KONTEN) {
            nurKonto neuesKonto = new nurKonto();
            System.out.println("\nDaten für das neue Konto eingeben:");
            neuesKonto.eingabe(scanner); // Scanner als Parameter übergeben
            konten[aktuelleKonten++] = neuesKonto;
            System.out.println("Neues Konto erfolgreich hinzugefügt.");
        } else {
            System.out.println("Maximale Anzahl an Konten erreicht!");
        }
    }

    // Konto auswählen
    public nurKonto kontoAuswählen(int index) {
        if (index >= 0 && index < aktuelleKonten) {
            return konten[index];
        } else {
            System.out.println("Ungültige Kontoauswahl!");
            return null;
        }
    }

    // Getter + Setter
    public int getKonten() {
        return aktuelleKonten;
    }
    public String getName() {
        return vorname + " " + nachname;	
    }

    public static int getKundenAnzahl() {
        return kundenAnzahl;
    }
}
