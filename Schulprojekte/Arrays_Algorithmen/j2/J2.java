import java.util.Scanner;
import java.util.Random;

public class J2 {
	public static void main(String[] args) {
		//Initialisierung
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		//Eingabe + Erstellung von 2 Arrays
		System.out.println("Gib die Anzahl der generierten Zahlen an: ");
		int n = scanner.nextInt();
		int[] zahlen = new int[n];
		int[] anzahlen = new int[n]; //alles automatisch auf 0 gesetzt
		//später wird jedem n ten Element in "zahlen" parallel in "anzahlen" eine dazugehörige Anzahl zugeordnet


		//Einfügen der Zahlen
		for (int i = 0; i < n; i++) {
			zahlen[i] = random.nextInt(49) + 1;
			System.out.println(zahlen[i]);
		}


		//Überprüfung der Vorkommnisse
		for (int i = 0; i < n; i++) {
			if(zahlen[i] != 0){ 	//Duplikate werden nicht nochmal gezählt
				for (int j = 0; j < n; j++) {	//Der array "zahl" wird in 2 for loops in quasi 2 identische Arrays gespalten
					if (zahlen[i] == zahlen[j]) {
						anzahlen[i]++;			/*das i´te Element von arr1 wird mit jedem Element des arr2 abgeglichen und bei Gleichheit der Elemente
				  								wird an der dazugehörigen Stelle im array "anzahlen" wird die Anzahl um 1 erhöht*/
						if (anzahlen[i] > 1) {
							zahlen[j] = 0;
							//Hiermit wird jedes weitere gleiche Element auf 0 gesetzt (als Duplikat markiert)
						}
					}
				}
			}
		}


		//Ausgabe
		for (int i = 0; i < n; i++) {
			if(zahlen[i] == 0){
				continue;
				//Dopplungen werden übersprungen
			}
			System.out.println("Zahl: " + zahlen[i] + " Vorkommen:" + anzahlen[i]);
		}
	}
}