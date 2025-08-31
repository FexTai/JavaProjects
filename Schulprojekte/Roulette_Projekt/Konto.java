public class Konto {
    private double kontostand;
    private String name;

    public Konto() {
        this.kontostand = 1000; // Standard-Kontostand von 1000
    }

    public Konto(double kontostand) {
        this.kontostand = kontostand;
    }

    public double getKontostand() {
        return kontostand;
    }
    
    public double auszahlen(double betrag){
        if(betrag <= 0){
            this.kontostand += 0;
            betrag = 0;
        }
        else{
            this.kontostand -= betrag;
        }
        return betrag;
    }
    	
    public void addKontostand(double betrag) {
        if(betrag <= 0){
            this.kontostand += 0;
        }
        else{
            this.kontostand += betrag;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

	public void verrechnung(boolean treffer, double einsatz, int multiplikator) {
        if (treffer) {
			addKontostand(einsatz * multiplikator);
		} else {
			addKontostand(-einsatz);  // Nur den Einsatz abziehen
		}
		rouletteFeld.setKonto(kontostand);
		rouletteFeld.setGewinn((double)einsatz*multiplikator);
    }
}
