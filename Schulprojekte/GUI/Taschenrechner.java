import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JG3b extends JFrame{
    //Klassenvariablen
    JLabel ergebnis, ausgabe, filler;
    JTextField z1;
    double savedValue = 0;

	//Fenster
	JG3b() {
    //Titel
    super("Taschenrechner");

    //Konfiguration
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    
    //Panels
    JPanel oberflaeche = new JPanel();
    oberflaeche.setLayout(new GridLayout(4,1));
    add(oberflaeche, BorderLayout.NORTH); 
    
    JPanel operatoren = new JPanel();
    operatoren.setLayout(new GridLayout(4,3));
 	 add(operatoren, BorderLayout.SOUTH);

	  //Label
	  ergebnis = new JLabel("Ergebnis der Rechnung:", SwingConstants.CENTER);
     oberflaeche.add(ergebnis);
     
     ausgabe = new JLabel("0", SwingConstants.CENTER);
     oberflaeche.add(ausgabe);
     
     filler = new JLabel("     ");

    //Eingabefeld
    z1 = new JTextField(10);
    oberflaeche.add(z1); oberflaeche.add(filler);


    //Buttons 
    JButton addition = new JButton("➕️");
    addition.addActionListener(new plus());
    operatoren.add(addition);

    JButton subtraktion = new JButton("➖️");
    subtraktion.addActionListener(new minus());
    operatoren.add(subtraktion);

    JButton multiplikation = new JButton("✖️");
    multiplikation.addActionListener(new mal());
    operatoren.add(multiplikation);

    JButton division = new JButton("➗️");
    division.addActionListener(new geteilt());
    operatoren.add(division);

	 JButton AC = new JButton("AC");
    AC.addActionListener(new reset());
    
    JButton ubernahme = new JButton("=");
    ubernahme.addActionListener(new ubernahme());
    
	 JButton wurzel = new JButton("√");
    wurzel.addActionListener(new wurzelZiehen());
    operatoren.add(wurzel); operatoren.add(ubernahme);
    
    //Trigonometrie
    JButton sin = new JButton("sin");
    sin.addActionListener(new sinus());
    operatoren.add(sin);
	
	 JButton cos = new JButton("cos");
    cos.addActionListener(new cosinus());
    operatoren.add(cos);
    
    JButton tan = new JButton("tan");
    tan.addActionListener(new tangens());
    operatoren.add(tan);	
    
    //Speicher/Aufruf
    JButton save = new JButton("save");
    save.addActionListener(new speichern());
     operatoren.add(AC); operatoren.add(save);
    
    JButton ans = new JButton("recall");
    ans.addActionListener(new recall());
    operatoren.add(ans);	
    
    
	//Main	
	}
	public static void main(String[] args) {
    JG3b fenster=new JG3b(); 
    fenster.pack();
    fenster.setVisible(true);
  }
  
  
	 //Einfache Operatoren
	 private class plus implements ActionListener {
			public void actionPerformed(ActionEvent e){
				try{
					double ergebnis = Double.parseDouble(ausgabe.getText()) + Double.parseDouble(z1.getText());
					ausgabe.setText(""+ergebnis);
					filler.setText("");					
				} catch(Exception a){
					filler.setText("Ungültige Eingabe!");
				}
				
			}	 	
	 }	
	 
	 private class minus implements ActionListener {
			public void actionPerformed(ActionEvent e){
				try{
					double ergebnis = Double.parseDouble(ausgabe.getText()) - Double.parseDouble(z1.getText());
					ausgabe.setText(""+ergebnis);
					filler.setText("");					
				} catch(Exception a){
					filler.setText("Ungültige Eingabe!");
				}
				
			}	 	
	 }
	 
	 private class mal implements ActionListener {
			public void actionPerformed(ActionEvent e){
				try{
					double ergebnis = Double.parseDouble(ausgabe.getText()) * Double.parseDouble(z1.getText());
					ausgabe.setText(""+ergebnis);
					filler.setText("");					
				} catch(Exception a){
					filler.setText("Ungültige Eingabe!");
				}
				
			}	 	
	 }
	 
	 private class geteilt implements ActionListener {
			public void actionPerformed(ActionEvent e){
				try{
					double ergebnis = Double.parseDouble(ausgabe.getText()) / Double.parseDouble(z1.getText());
					ausgabe.setText(""+ergebnis);
					filler.setText("");					
				} catch(Exception a){
					filler.setText("Ungültige Eingabe!");
				}
				
			}	 	
	 }
	 
	 
	 //Wurzel
	 private class wurzelZiehen implements ActionListener {
			public void actionPerformed(ActionEvent e){
				try{
					double ergebnis = Math.sqrt(Double.parseDouble(ausgabe.getText()));
					ausgabe.setText(""+ergebnis);
					filler.setText("");					
				} catch(Exception a){
					filler.setText("Ungültige Eingabe!");
				}
				
			}	 	
	 }
	 
	 
	 //Trigonometrie
	 private class sinus implements ActionListener {
			public void actionPerformed(ActionEvent e){
				try{
					double ergebnis = Math.sin(Double.parseDouble(ausgabe.getText()));
					ausgabe.setText(""+ergebnis);
					filler.setText("");					
				} catch(Exception a){
					filler.setText("Ungültige Eingabe!");
				}
				
			}	 	
	 }
	 
	 private class cosinus implements ActionListener {
			public void actionPerformed(ActionEvent e){
				try{
					double ergebnis = Math.cos(Double.parseDouble(ausgabe.getText()));
					ausgabe.setText(""+ergebnis);
					filler.setText("");					
				} catch(Exception a){
					filler.setText("Ungültige Eingabe!");
				}
				
			}	 	
	 }
	 
	 private class tangens implements ActionListener {
			public void actionPerformed(ActionEvent e){
				try{
					double ergebnis = Math.tan(Double.parseDouble(ausgabe.getText()));
					ausgabe.setText(""+ergebnis);
					filler.setText("");					
				} catch(Exception a){
					filler.setText("Ungültige Eingabe!");
				}
				
			}	 	
	 }
	 
	 
	 //Speichern + Aufrufen
	 private class speichern implements ActionListener {
			public void actionPerformed(ActionEvent e){
				try{
					savedValue = Double.parseDouble(ausgabe.getText());
					ausgabe.setText("");
					filler.setText("Zahl wurde gespeichert");					
				} catch(Exception a){
					filler.setText("Ungültige Eingabe!");
				}
				
			}	 	
	 }
	 
	 private class recall implements ActionListener {
			public void actionPerformed(ActionEvent e){
				z1.setText(""+savedValue);
				filler.setText("");						
			}	 	
	 }
	 
	 
	 //Zusatz
	 private class reset implements ActionListener {
			public void actionPerformed(ActionEvent e){
				ausgabe.setText("0");
				filler.setText("");						
			}	 	
	 }
	 
	 private class ubernahme implements ActionListener {
			public void actionPerformed(ActionEvent e){
				ausgabe.setText(z1.getText());
				filler.setText("");						
			}	 	
	 }			
	 
}