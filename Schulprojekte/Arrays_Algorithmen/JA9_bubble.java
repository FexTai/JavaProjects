import java.util.Random;
import java.util.Scanner;

public class JA9_bubble{
	public static void main(String[] args){
		//Initialisierung
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int temp, zae = 0; boolean vertauscht;
		int vergleiche = 0, vertausch = 0;
		
		//Array anlegen
		System.out.println("Länge des Arrays?");
		final int MAX = scanner.nextInt();		
		int[] arr = new int[MAX];
					
		//Array füllen
		for(int i = 0; i<MAX; i++){
			arr[i] = random.nextInt(1000) + 1;
			System.out.print(arr[i] + ", ");	
		}
		System.out.println();
		
		
		//Array sortieren
		do{
			zae++;
			vertauscht = false;
			for(int j = 0; j<MAX-1; j++){
				if(arr[j] > arr[j+1]){
					vergleiche++;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					vertausch+=3;
					vertauscht = true;	
				}
			}
		}while(vertauscht);
				
				
		//Ausgabe Sortiert
		for(int i = 0; i<MAX; i++){
			System.out.print(arr[i] + ", ");		
		}
	}
}