public class CasinoMain {
	public static void main(String[] args) {
		RouletteScheibe roulettescheibe = new RouletteScheibe();		
		rouletteFeld rouletteFenster = new rouletteFeld(roulettescheibe);
		StartReiter menuFenster = new StartReiter(rouletteFenster, roulettescheibe);
		
		//rouletteFenster.setSize(800, 500);
		rouletteFenster.pack();
		rouletteFenster.setVisible(false);
		menuFenster.setSize(800, 600);
		menuFenster.setVisible(true); 	 
		roulettescheibe.setSize(520, 540);
		roulettescheibe.setVisible(false);
	}
}