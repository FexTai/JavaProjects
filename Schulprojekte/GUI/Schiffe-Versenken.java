import java.awt.*; import java.awt.event.*;
import javax.swing.*; import javax.swing.event.*;
import java.util.Random;

public class schiffe extends JFrame {
	Random random = new Random();
	JPanel grid;
	JLabel label;
	JButton[] arr = new JButton[25];
	int anz = 5, ver = 0, s = 0;
	//Fenster
	schiffe() {
		super("Schiffe versenken");
		label = new JLabel("");
		add(label, BorderLayout.NORTH);
		grid = new JPanel();
		grid.setLayout(new GridLayout(5,5));
		add(grid, BorderLayout.CENTER);
		for(int i = 0; i<25; i++){
			arr[i] = new JButton();
			arr[i].addActionListener(new add());
			grid.add(arr[i]); 		
		}
		while(s < 5){	
			int schiff = random.nextInt(25);
			if(!arr[schiff].getActionCommand().equals("schiff")){
				arr[schiff].setActionCommand("schiff");
				arr[schiff].addActionListener(new schiff());	
				s++;
			}				
		}
	}
	
	//anz
	private class add implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton c = (JButton)e.getSource();
			ver++;
			if(!e.getActionCommand().equals("schiff")){
				c.setText("Wasser!");
				c.setBackground(Color.CYAN);			
			}
		}	
	}
	
	//hörer
	private class schiff implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton b = (JButton)e.getSource();
			b.setText("Schiff versenkt");
			b.setBackground(Color.RED);
			anz--;
			if(anz == 0){
				for(int i = 0; i<25; i++){
					if(!arr[i].getActionCommand().equals("schiff")){
						arr[i].setText("Wasser!");
						arr[i].setBackground(Color.CYAN);		
					}
					arr[i].setEnabled(false);				
				}
				label.setText("\nDu hast gewonnen! " + "Versuche: " + ver);
			}else{
				System.out.println("Noch " + anz + " übrig");
				b.setEnabled(false);	
			}	
		}	
	}
	
	//Main
	public static void main(String[] args){
		schiffe s1 = new schiffe();
		s1.setVisible(true);
		s1.pack();	
	}

}