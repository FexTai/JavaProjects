import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class rouletteFeld extends JFrame{
	//Klassenvariablen
	private static final String PLACEHOLDER_TEXT = "Betrag eingeben: ";
	static String history;
	Graphics2D graphic2d;
	JButton reset, f1, f2, start, einzahlen, auszahlen;
	public static JLabel sp, kontoAkt, gewinnSumme, lastFive;
	Random random = new Random();
	JTextField entry;
	RouletteScheibe roulettescheibe;
	int auswahl;
	JButton[] buttons = new JButton[37];
	private ArrayList<Integer> rollsList = new ArrayList<Integer>();
	private ArrayList<JButton> mainButtons = new ArrayList<JButton>();

	
	//SpielerVariablen
	private Konto CasinoKonto = new Konto(1000);
	private Spieler spieler = new Spieler("BMMS");
	

	//Konstruktor
	rouletteFeld(RouletteScheibe roulettescheibe){
		//Fenster
		super("Einsatzfeld");
		this.roulettescheibe = roulettescheibe;
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	setLayout(new FlowLayout());
    	

		//Border Fenster
		setUndecorated(false);
		getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.decode("#873e23")));
		getContentPane().setBackground(Color.decode("#26b161"));
				
		
		//Labels
		sp = new JLabel("Spieler: " + spieler.getName());
		kontoAkt = new JLabel("Guthaben: " + spieler.getKonto().getKontostand() + "€");
		gewinnSumme = new JLabel("gewonnene/verlorene Summe: ");
		lastFive = new JLabel("Historie: ");
		sp.setFont(new Font("Arial", Font.BOLD, 15)); kontoAkt.setFont(new Font("Arial", Font.BOLD, 15));
		gewinnSumme.setFont(new Font("Arial", Font.BOLD, 15)); lastFive.setFont(new Font("Arial", Font.BOLD, 15));

		//Panels
		JPanel section = new JPanel();
    	section.setLayout(new BorderLayout());
    	add(section, SwingConstants.CENTER); 
    	
		JPanel num = new JPanel();
    	num.setLayout(new BorderLayout());
    	section.add(num, BorderLayout.NORTH); 

		JPanel oberflaeche = new JPanel();
    	oberflaeche.setLayout(new GridLayout(3, 13));
    	num.add(oberflaeche, BorderLayout.CENTER); 
    	
    	JPanel num2 = new JPanel();
    	num2.setLayout(new GridLayout(3, 1));
    	num.add(num2, BorderLayout.EAST);
    	
    	//num2 filler
    	f1 = new JButton();
    	num2.add(f1);
    	f2 = new JButton();
    	f2.setBackground(Color.decode("#26b161")); f1.setBackground(Color.decode("#26b161"));
    	f2.setEnabled(false); f1.setEnabled(false);
    	f2.setBorder(null); f1.setBorder(null);; 

		JPanel field = new JPanel();
    	field.setLayout(new GridLayout(4,1));
		field.setBackground(Color.decode("#26b161"));
    	section.add(field, BorderLayout.SOUTH); 
    	
    	JPanel historie = new JPanel();
    	historie.setLayout(new GridLayout(4,1));
		historie.setBackground(Color.decode("#26b161"));

		JPanel grid = new JPanel();
    	grid.setLayout(new GridLayout(1,3));
		grid.setBackground(Color.decode("#26b161"));

		//Zahlen Buttons
		for(int i = 0; i<37; i++){
			buttons[i] = new JButton(""+ (i));
			if(Felder.getFarbe(i).equals("schwarz")){
				buttons[i].setBackground(Color.BLACK);	
			}
			else if(Felder.getFarbe(i).equals("rot")){
				buttons[i].setBackground(Color.RED);
			}
			else{
				buttons[i].setBackground(Color.GREEN);
			}
			//Style
			buttons[i].addActionListener(new auswahl());
			buttons[i].setForeground(Color.WHITE);
			buttons[i].setOpaque(true);
			buttons[i].setFont(new Font("Arial", Font.BOLD, 25));
         	buttons[i].setBorder(BorderFactory.createCompoundBorder(
        	BorderFactory.createLineBorder(Color.ORANGE, 2), 
        	BorderFactory.createEmptyBorder(10, 10, 10, 10)));
			if(Felder.getFarbe(i).equals("grün")){
				num2.add(buttons[i], SwingConstants.NORTH);
				num2.add(f2);
			}
			else{ oberflaeche.add(buttons[i]); }		
		}

		//Main Buttons
		//reset
		reset = new JButton("auswahl zurücknehmen");
		reset.addActionListener(new Reset());
		
		//start
		start = new JButton("Spiel beginnen!");
		start.addActionListener(new Start());
		start.setEnabled(false);

		//Einzahlung
		einzahlen = new JButton("einzahlen");
		einzahlen.addActionListener(new Einzahlen());

		//Auszahlung
		auszahlen = new JButton("auszahlen");
		auszahlen.addActionListener(new Auszahlen());

		//Main Buttons Styles
		Collections.addAll(mainButtons, reset, start, auszahlen, einzahlen);
		for (JButton button : mainButtons) {
         button.setFont(new Font("Arial", Font.BOLD, 20));
			button.setBorder(BorderFactory.createCompoundBorder(
        		BorderFactory.createLineBorder(Color.ORANGE, 2), 
        		BorderFactory.createEmptyBorder(10, 10, 10, 10)));
			button.setForeground(Color.WHITE);
			button.setBackground(Color.RED);
			button.setOpaque(true);
        }
		
		//Eingabe		
		entry = new JTextField();
		entry.setFont(new Font("Arial", Font.BOLD, 20));
		entry.setText("Betrag eingeben: ");
		entry.setBorder(BorderFactory.createCompoundBorder(
        	BorderFactory.createLineBorder(Color.ORANGE, 2), 
        	BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		entry.setForeground(Color.WHITE);
		entry.setBackground(Color.RED);
		entry.setOpaque(true);
		//Platzhalter Text
		entry.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				entry.setText(PLACEHOLDER_TEXT);
				if (entry.getText().equals(PLACEHOLDER_TEXT)) {
					entry.setText("");
				}
			}
		
			@Override
			public void focusLost(FocusEvent e) {
				if (entry.getText().trim().isEmpty()) {
					entry.setText(PLACEHOLDER_TEXT);
				}
			}
		});	
		

		//Elemente Hinzufügen
		field.add(start);
		field.add(reset); 
		grid.add(entry);
		grid.add(einzahlen);
		grid.add(auszahlen);
		field.add(grid);
		field.add(historie);
		historie.add(sp); historie.add(lastFive); historie.add(kontoAkt); historie.add(gewinnSumme);
	}	
	

	//SetterLabel
	public static void setKonto(double betrag){
		kontoAkt.setText("Guthaben: " + betrag + "€");	
	}
	
	public static void setSpieler(String name){
		sp.setText("Spieler: " + name);	
	}
	
	public static void setGewinn(double summe){
		gewinnSumme.setText("gewonnene/verlorene Summe: " + summe + "€");	
	}
	
	public static void updateHistorie(){
		lastFive.setText("Historie: " + history);
	}
	
	//Einzahlen
	private class Einzahlen implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			String input = entry.getText().trim();
			try {
				double betrag = Double.parseDouble(input);
				if(betrag <= spieler.getKonto().getKontostand() && spieler.getKonto().getKontostand() > 0){
					CasinoKonto.addKontostand(spieler.getKonto().auszahlen(betrag));
					setKonto(CasinoKonto.getKontostand());
				}
				else{
					System.out.println("nicht genug Guthaben!");
				}
				System.out.println("Casino Konto: " + CasinoKonto.getKontostand());
				System.out.println("Spieler Konto: " + spieler.getKonto().getKontostand());
			} catch (NumberFormatException fehler) {
				System.out.println("Falsche Eingabe! Bitte eine gültige Zahl eingeben.");
			}
		}	
	}

	//Auszahlen
	private class Auszahlen implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			String input = entry.getText().trim();
			try {
				double betrag = Double.parseDouble(input);
				if(betrag <= CasinoKonto.getKontostand() && CasinoKonto.getKontostand() > 0){
					spieler.getKonto().addKontostand(CasinoKonto.auszahlen(betrag));
					setKonto(CasinoKonto.getKontostand());
				}
				else{
					System.out.println("nicht genug Guthaben!");
				}
				System.out.println();
				System.out.println("Casino Konto: " + CasinoKonto.getKontostand());
				System.out.println("Spieler Konto: " + spieler.getKonto().getKontostand());
				System.out.println();
			} catch (NumberFormatException fehler) {
				System.out.println("Falsche Eingabe! Bitte eine gültige Zahl eingeben.");
			}
		}	
	}
  
	//Auswahl
	private class auswahl implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			for(int i = 0; i<37; i++){
				if(e.getActionCommand().equals(""+i)){
					buttons[i].setEnabled(true);				
				}
				else{buttons[i].setEnabled(false);}			
			}
			auswahl = Integer.parseInt(e.getActionCommand());
			start.setEnabled(true);	
		}	
	}
	
	//Reset
	private class Reset implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			for(int i = 0; i<37; i++){
				buttons[i].setEnabled(true);					
			}
			start.setEnabled(false);		
		}	
	}
	
	//Start
	private class Start implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			String input = entry.getText().trim();	// Entfernt führende und nachfolgende Leerzeichen
			history = ""; 
			try {
				double betrag = Double.parseDouble(input);
				int gerollt = random.nextInt(37);
				if(betrag <= 0){
					entry.setText("ungültiger Betrag!");
				}
				else if(spieler.getKonto().getKontostand() <=0  || betrag > spieler.getKonto().getKontostand()){
					entry.setText("nicht genug Guthaben!");
				}
				else{
					//Historie anpassen
					rollsList.add(gerollt);
					//Die ersten 5 elemente
					if(rollsList.size() < 5){
						for(int i = 0; i<rollsList.size(); i++){
							history += rollsList.get(i) + " | ";				
						}
					}
					//Die letzten 5 rolls
					else{
						for(int i = 0; i < 5; i++){
							history += rollsList.get(rollsList.size()-i-1) + " | ";				
						}	
					}
					roulettescheibe.spiel(gerollt);
					spieler.Start(gerollt, auswahl, betrag, CasinoKonto);
				}
			} catch (NumberFormatException fehler) {
				System.out.println("Falsche Eingabe! Bitte eine gültige Zahl eingeben.");
			}
	
		}	
	}
	
}