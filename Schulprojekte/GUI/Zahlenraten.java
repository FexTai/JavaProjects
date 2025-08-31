import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class JG4 extends JFrame{
	//Klassenvariablen
	Random random = new Random();
	int versuche = 0;
	int max, min = 1000000000, zahl;
	int runden = 0, verSum = 0;
	JLabel l1, l2, l3, l4, l5, l6, l7;
	JButton raten, reset, stReset;
	JSlider slider;
	JTextField entry;
	
	//Fenster
	JG4(){
		super("Zahlenraten");
		//Konfiguration
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	setLayout(new BorderLayout());
    	
    	//Panels
    	JPanel oberflaeche = new JPanel();
    	oberflaeche.setLayout(new GridLayout(5,1));
    	add(oberflaeche, BorderLayout.NORTH); 
    	
    	JPanel bt = new JPanel();
    	bt.setLayout(new GridLayout(2,1));
		add(bt, BorderLayout.CENTER); 
		
		JPanel statistik = new JPanel();
		statistik.setLayout(new GridLayout(5,1));
		add(statistik, BorderLayout.SOUTH);
		
		
		//Labels    	
    	l1 = new JLabel("Zahlenbereich einstellen:", SwingConstants.CENTER);
    	l2 = new JLabel("0", SwingConstants.CENTER);
    	l3 = new JLabel("", SwingConstants.CENTER);
    	l4 = new JLabel("", SwingConstants.CENTER);
    	l5 = new JLabel("Durchschnittliche Versuche: 0", SwingConstants.CENTER);
    	l6 = new JLabel("Versuche maximal: 0", SwingConstants.CENTER);
    	l7 = new JLabel("Versuche minimal: 0", SwingConstants.CENTER);
    	oberflaeche.add(l1); oberflaeche.add(l2); oberflaeche.add(l3); oberflaeche.add(l4);
    	statistik.add(l5); statistik.add(l6); statistik.add(l7);
    	
		//Slider
		slider = new JSlider(1,100);
		slider.setValue(0);
		slider.addChangeListener(new slider());
    	oberflaeche.add(slider);    	
    	
		//Eingabefeld
		entry = new JTextField("Zahl hier eingeben", 10);
    	statistik.add(entry);    	
    	entry.setVisible(false);
    	
    	//Button
		raten = new JButton("start!");
		raten.addActionListener(new start());
		
		reset = new JButton("reset");
		reset.addActionListener(new reset());
		reset.setVisible(false);
		bt.add(raten); bt.add(reset);
		
		stReset = new JButton("Statistik zurücksetzen");
		stReset.addActionListener(new stReset());
		statistik.add(stReset);
	}

	//Main
	public static void main(String[] args) {
		JG4 fenster=new JG4(); 
		fenster.pack();
		fenster.setVisible(true);
  }
  
  //Methoden
  
  	//Slider
  	private class slider implements ChangeListener {
			public void stateChanged(ChangeEvent e) {
				l2.setText("1 - " + String.valueOf(slider.getValue()));
			}	 	
	 }
	 
	 //Reset
	 private class reset implements ActionListener {
			public void actionPerformed (ActionEvent e) {
				slider.setVisible(true);
				slider.setValue(0);
				raten.setVisible(true);
				entry.setVisible(false);
				reset.setVisible(false);
				if(l3.getText().equals("gewonnen!")){
					l5.setText("Durchschnittliche Versuche: " + (double)(verSum/runden));
					l6.setText("Versuche maximal: " + max);
					l7.setText("Versuche minimal: " + min);				
				}
				l3.setText(""); l4.setText("");
				raten.setText("start!");
				l2.setText("0");		
			}	 
	 }
	 
	 //stReset
	 private class stReset implements ActionListener {
			public void actionPerformed (ActionEvent e) {
				verSum = 0;
				max = 0;
				min = 1000000000;
				l5.setText("Durchschnittliche Versuche: 0");
				l6.setText("Versuche maximal: 0");
				l7.setText("Versuche minimal: 0");			
			}	 
	 }
	 
	 //Starten
	 private class start implements ActionListener {
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand() == "start!" && l2.getText() != "0"){
					slider.setVisible(false);
					entry.setVisible(true);
					reset.setVisible(true);
					l3.setVisible(true); l4.setVisible(true);
					raten.setText("raten");
					zahl = random.nextInt(slider.getValue()) + 1;					
					versuche = 0; 
					runden++;
					System.out.println("Runden: " + runden);
					System.out.println("max.: " + max + " min.: " + min);
				}
				else if(e.getActionCommand() == "raten"){
					versuche++;
					verSum++;
					System.out.println(verSum);
					l4.setText("Versuche: " + versuche);
					try{
						int eingabe = Integer.parseInt(entry.getText());
						if(eingabe < zahl){
							l3.setText("Höher");						
						} else if(eingabe > zahl){
							l3.setText("Niedriger");						
						}
						else{
							l3.setText("gewonnen!");
							raten.setVisible(false);		
							if(versuche >= max){
								max = versuche;
								if (versuche < min){
								min = versuche;											
							}							
							} else if (versuche < min){
								min = versuche;											
							}				
						}
				} catch(Exception a){
						l3.setText("Ungültige Eingabe!");
				}
				}
				
			}	 	
	 }	

}