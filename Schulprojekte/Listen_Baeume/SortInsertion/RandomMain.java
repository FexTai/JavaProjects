import java.util.Scanner;
import java.util.Random;

public class RandomMain {
	public static void main(String[] args) {
		//Initialisierung
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		Wert aktuell, start, letzter;
		
		System.out.println("Wie lang soll die Liste werden?: ");
		final int MAX = scanner.nextInt(); scanner.nextLine();
		
		start = new Wert(random.nextInt(1000)+1);
		aktuell = start;
		for(int i = 1; i < MAX; i++){
			//Neuer Wert erstellt
			Wert neu = new Wert(random.nextInt(1000)+1);
			//Verweis auf das neue dem aktuellen übergeben
			aktuell.add(neu);
			//Der neue wird nun der aktuelle/letzte
			aktuell = neu;	
		}		
		
		//Testwert
		Wert test = new Wert(125);
		Wert test2 = new Wert(995);

		Wert.alleWerte(start);
		start.ins(test);
		start.ins(test2, nr);
		System.out.println("");
		Wert.alleWerte(start);

		
				
				
		}
	}
