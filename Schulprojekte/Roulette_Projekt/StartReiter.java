import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;

public class StartReiter extends JFrame {
	rouletteFeld rouletteFenster;
	StartReiter startReiter = this;
	RouletteScheibe kugelFenster;
	JLabel benutzer, kontostand;
	JComboBox<String> combo;
	String[] combos={"Roulette","coming soon","coming soon"};
	JComboBox<String> benutzerAuswahl;
	String[] auswahl = new String[10];
	Spieler s = new Spieler("Gast");
	private SpielerListe spielerList = new SpielerListe(s, startReiter);
		
	public int getBenutzerAnzahl() {
		int i = 0;
		while (auswahl[i] != null) { 
			i++;
		}
		return i;
	}

	public void addAuswahlArray(String b) {
		auswahl[getBenutzerAnzahl()] = b;
	}

	public SpielerListe getSpielerListe() {
		return spielerList;
	}

	//Roulette Starten
	private class ROpener implements ActionListener {
		public void actionPerformed(ActionEvent E) {
			if(combo.getSelectedIndex()==0) {
				setVisible(false);	
				rouletteFenster.setVisible(true);	
				kugelFenster.setVisible(true);
			}
		}	
	}
	
	//Benutzer wechseln
	private class BWechsler implements ActionListener {
		public void actionPerformed(ActionEvent E) {
			EingabeFeld eingabeFeld = new EingabeFeld(startReiter);
			eingabeFeld.setSize(500, 200);
			eingabeFeld.setVisible(true);			
		}	
	}	
	
	StartReiter(rouletteFeld rouletteFenster, RouletteScheibe kugelFenster) {
		super("Menu");
        this.auswahl = new String[10];
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
		
		//Layouts
		setLayout(new BorderLayout());
		JPanel center = new JPanel();
		JPanel north = new JPanel();
		center.setLayout(new GridLayout(1,2));
		north.setLayout(new GridLayout(1,2));
		add(center, BorderLayout.CENTER);
		add(north, BorderLayout.NORTH);
		
		//auswahl[0] = "Benutzer1";
		benutzerAuswahl = new JComboBox<>(auswahl);
		center.add(benutzerAuswahl);

		/*JComboBox<String>*/combo = new JComboBox<>(combos);
		center.add(combo);
		
		
		//Roulette start button
		JButton start = new JButton("Spiel Starten");
		start.addActionListener(new ROpener());
		add(start, BorderLayout.SOUTH);

	
		
		//Benutzer anzeige
		benutzer = new JLabel("Benutzer: "); //ändern
		north.add(benutzer);	
		kontostand = new JLabel("Kontostand: "); //ändern
		north.add(kontostand);
		
		
		//Benutzer wechseln Button
		JButton benutzerW = new JButton("Benutzer wechseln");
		benutzerW.addActionListener(new BWechsler());
		north.add(benutzerW);
			
		
		this.rouletteFenster=rouletteFenster;
		this.kugelFenster = kugelFenster;
	}
	/*public static void main(String[] args) {
		StartReiter fenster = new StartReiter();
		fenster.setSize(800, 600);	
		fenster.setVisible(true);
	}*/
}