import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EingabeFeld extends JFrame{

	EingabeFeld eingabeFeld = this;
	JTextField name;
	JTextField kontoStand;
	JLabel benutzer;
	JButton bestätigen;
	JPanel center, north;
	StartReiter startReiter;
	String bBenutzer;
	double k;
	
	private class Bestätigung implements ActionListener {
		public void actionPerformed(ActionEvent E) {
			bBenutzer = name.getText();
			try {
				k = Double.parseDouble(kontoStand.getText());
				Spieler s = new Spieler(bBenutzer);
				SpielerListe spielerliste = startReiter.getSpielerListe();
				spielerliste.add(s);
				startReiter.addAuswahlArray(bBenutzer);
				eingabeFeld.setVisible(false);
			} catch (NumberFormatException e) {}

			/*return(true);*/
		}
	}
			
		
	
	EingabeFeld(StartReiter startReiter){
		
		super("Benutzer Editor");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.startReiter = startReiter;
	 
		center = new JPanel();
		north = new JPanel();
		north.setLayout(new FlowLayout());
		center.setLayout(new GridLayout(2,2));
		add(center, BorderLayout.CENTER);
		add(north, BorderLayout.NORTH);
	 	
	 	bBenutzer = "Benutzer: "+startReiter.getBenutzerAnzahl();
		benutzer = new JLabel(bBenutzer);
		north.add(benutzer);
		

		JLabel nName = new JLabel("Name: ");
		center.add(nName);
		name = new JTextField();
		center.add(name);

		JLabel kKontoStand = new JLabel("Kontostand: ");
		center.add(kKontoStand);
		kontoStand = new JTextField();
		center.add(kontoStand);
		
		bestätigen = new JButton("Bestätigen");
		bestätigen.addActionListener(new Bestätigung());
		add(bestätigen, BorderLayout.SOUTH);

	}
}

		
		
		
		

		
		
	 	 
	 
	 
	 
	 
	 