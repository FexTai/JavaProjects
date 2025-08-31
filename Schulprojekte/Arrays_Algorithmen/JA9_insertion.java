import java.util.Random;
import java.util.Scanner;

public class JA9_insertion{
	public static void main(String[] args){
		//Initialisierung
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int temp, p = 0, zae, j; boolean vertauscht;
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
		
		
		//Sortieren
		for(int i = 1; i < MAX; i++){
			temp = arr[i];
			vertausch++;
			j = i-1;
			while(j>=0 && arr[j] > temp){
				arr[j+1] = arr[j];
				j--;
				vertausch++;
				vergleiche++;			
			}
			arr[j+1] = temp;
			vertausch++;	
		}
				
				
		//Ausgabe Sortiert
		for(int i = 0; i<MAX; i++){
			System.out.print(arr[i] + ", ");	
			}
		System.out.println("\nAnzahl der Vertauschungen: " + vertausch);
		System.out.println("Anzahl der Vergleiche: " + vergleiche);	
		}
	}