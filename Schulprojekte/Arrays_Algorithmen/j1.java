import java.util.Scanner;
public class j1 {
	public static void main(String[] args){
			//Initialisierung
			Scanner scanner = new Scanner(System.in);
			double summe = 0; double mittelwert = 0;
			
			//Abfrage Anzahl
			System.out.println("Gib die Anzahl der Zahlen an");
			int n = scanner.nextInt();
			double[] ar = new double[n];
			
			//Eingabe Zahlen
			for(int i=0; i<n; i++){
				System.out.println("Gib die Zahl ein");
				ar[i] = scanner.nextDouble();			
				summe += ar[i];
			}
			
			//Errechnung Mittelwert
			mittelwert = summe/n;
			System.out.println("\n" + mittelwert + "\n");
			
			//Ausgabe Zahlen über Mittelwert
			for(int j = 0; j<n; j++){
				if(ar[j] > mittelwert){
					System.out.println(ar[j]);								
				}
				
			}
			
	}
}