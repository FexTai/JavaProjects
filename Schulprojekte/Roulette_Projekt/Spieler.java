

public class Spieler {
	private int multiplikator = 0;
	final int MAX=5;
	String stringfarbe;
	Felder feld;
	Konto konto;
	String name;
	
	public Spieler(String name) {
		this.konto = new Konto(1000);
		this.name = name;
	}

	public Spieler(){
		this.konto = new Konto(1000);
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getMultiplikator(){
		return(multiplikator);
	}
	
	public Konto getKonto(){
		return konto;
	}
	
	public void Start(int gerollt, int gesetzt, double gewettet, Konto casino) {
		if(gerollt == gesetzt){
			multiplikator = 36;
			casino.verrechnung(true, gewettet, multiplikator);  
		} else {multiplikator = -1; }
		casino.verrechnung(false, gewettet, multiplikator);
	}	
}


		

		
		
		
	
	