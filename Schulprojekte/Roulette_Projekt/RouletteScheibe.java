import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class RouletteScheibe extends JFrame {
	Graphics2D g2d;	
	Random random = new Random();	
	int zufall = -1, stelleRichtig;
	int[] rouletteZahlen = {0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};
	
	
	public void paint(Graphics g) {
		int x = 10, y = 40, w = 480, h = 480;
		
		super.paint(g); // hier eigentlich nicht notwendig
		g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.drawOval(x, y-10, w+20, h+10);
    	g2d.setColor(Color.decode("#BA8C63"));
    	g2d.fillOval(x+1, y-9, w+18, h+9);
    	g2d.setColor(Color.BLACK);
    	g2d.drawOval(x+50, y+38, w-80, h-80);
		int mitteX = (x + w+20) / 2;
		int mitteY = (y-10 + h+10) / 2;
		g2d.drawLine(mitteX+7, y+38, mitteX+7, h-3);
		g2d.drawLine(x+50, mitteY+15, w-20, mitteY+15);
		g2d.setColor(Color.BLACK);
		for(int i = 0; i<=36; i++) {
			if(Felder.getFarbe(rouletteZahlen[i]).equals("rot")) {
				g2d.setColor(Color.RED);			
			} else if(Felder.getFarbe(rouletteZahlen[i]).equals("schwarz")) {
				g2d.setColor(Color.BLACK);			
			} else if(Felder.getFarbe(rouletteZahlen[i]).equals("grün")) {
				g2d.setColor(Color.GREEN);			
			}
			double winkel = ((((i*360)/37)-90)*Math.PI)/180;
			String zahl = String.valueOf(rouletteZahlen[i]);	//mit html zeichen vergrößern (vllt fett machen)	
			g2d.drawString(zahl, (int)(230*Math.cos(winkel)+mitteX+3), (int)(230*Math.sin(winkel)+mitteY+20));		
		}
		
		if(zufall>0) {
			for(int f = 0; f<37; f++) {
				if(zufall == rouletteZahlen[f]) {
					stelleRichtig = f;
				}
			}
			int i;
			
			//animation zum drehen der Kugel
			for(i=0; i<stelleRichtig+74; i++) {
				g2d.setColor(Color.WHITE);
				double winkel = ((((i*360)/37)-90)*Math.PI)/180;
				double kugelX = (230*Math.cos(winkel)+mitteX), kugelY = (230*Math.sin(winkel)+mitteY);
				g2d.fillOval((int) kugelX+5, (int) kugelY+5, 10, 10);				
				try{ Thread.sleep(2*i);} catch(Exception E){}
				g2d.setColor(Color.decode("#BA8C63"));		
				g2d.fillOval((int) kugelX+5, (int) kugelY+5, 10, 10);
				//wiederherstellen der zahlen, wenn die Kugel auf den zahlen lag
				for(int j = 0; j<37; j++) {
					if(Felder.getFarbe(rouletteZahlen[j]).equals("rot")) {
						g2d.setColor(Color.RED);			
					} else if(Felder.getFarbe(rouletteZahlen[j]).equals("schwarz")) {
						g2d.setColor(Color.BLACK);			
					} else if(Felder.getFarbe(rouletteZahlen[j]).equals("grün")) {
						g2d.setColor(Color.GREEN);			
					}
					double winkelRichtig = ((((j*360)/37)-90)*Math.PI)/180;
					String zahl = String.valueOf(rouletteZahlen[j]);		
					g2d.drawString(zahl, (int)(230*Math.cos(winkelRichtig)+mitteX+3), (int)(230*Math.sin(winkelRichtig)+mitteY+20));
				}		
			}
			//endball setzen
			g2d.setColor(Color.WHITE); 
			double winkel = ((((stelleRichtig*360)/37)-90)*Math.PI)/180;
			double kugelX = (230*Math.cos(winkel)+mitteX), kugelY = (230*Math.sin(winkel)+mitteY);
			g2d.fillOval((int) kugelX+5, (int) kugelY, 10, 10);
			rouletteFeld.updateHistorie();
		}
	}
	
	public void spiel(int zufall) {
		this.zufall = zufall;
		repaint();
	}
	
	RouletteScheibe() {
		super("Rad");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	
		getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.decode("#873e23")));
		getContentPane().setBackground(Color.decode("#26b161"));	
	}
}