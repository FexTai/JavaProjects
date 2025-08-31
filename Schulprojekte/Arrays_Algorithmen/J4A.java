import java.util.Scanner;

public class J4A{
	public static void main(String[] args){
		//Initialisierung
		Scanner scanner = new Scanner(System.in);
		int n, zl, an; 
		
		//Eingabe + Array Erstellung
		System.out.println("Wie viele Namen willst du eingeben?: ");
		n = scanner.nextInt();
		scanner.nextLine();
		String[] namen = new String[n];
		
		
		//Listenfüllung		
		for(int i = 0; i<n; i++){
			System.out.println("\nGib den " + (i+1) + ". Namen ein: ");
			namen[i] = scanner.nextLine();
			
		}
		
		//Dopplungen zählen
		for(int i = 0; i<n; i++){
			zl = 1;	//Zähler für jedes weitere Element i wird zurückgesetzt
			for(int j = i+1; j<n; j++){
				if(namen[i].equals(namen[j])){	//jede Dopplung an Stelle j wird gelöscht
					zl++;		//Dopplungen werden gezählt für das jeweilige Element i
					namen[j] = "";		//Löschung der Dopplungen
				}	
			}
			//Einzelne Ausgabe jeder Dopplung
			if(zl>1 && !namen[i].equals("")){
				System.out.println("Der Name " + namen[i] + " kam " + zl + " mal vor");					
			}		
		}
	}
}