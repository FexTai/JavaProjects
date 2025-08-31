import java.util.Scanner;
public class Kunden {
    //Array von Kunden
    private static Scanner scanner = new Scanner(System.in);
    public Kunde[] kunden;
    public final int MAXKUNDEN;

    // Konstruktoren
    Kunden(int anzahlKunden) {
        MAXKUNDEN = anzahlKunden;
        kunden = new Kunde[anzahlKunden];
    }

    Kunden() {
        MAXKUNDEN = 5;
        kunden = new Kunde[MAXKUNDEN];
    }

	public void kundenErstellen(){
	 	if(Kunde.getKundenAnzahl() < MAXKUNDEN){
			kunden[Kunde.getKundenAnzahl()] = new Kunde();
            //Zurück auf erstellten Kunden gehen
			kunden[Kunde.getKundenAnzahl() - 1].eingeben(scanner);	
	 	}
	 	else {
	 		System.out.println("Maximale Anzahl an Kunden erreicht");
	 	}		
	 }

     //get Kunde
    public Kunde[] getKunde(int index){
        return kunden;
    }
    // Methode zur Ausgabe aller Kunden
    public void kundenAusgabe() {
        System.out.println("\nAlle Konten:");
        for (int i = 0; i < kunden.length; i++) {
            System.out.println("\nKunde " + (i + 1) + ":");
            kunden[i].ausgeben();
        }
    }
}
