import java.util.Random;
import java.util.Scanner;

public class JA9_selection{
	public static void main(String[] args){
		//Initialisierung
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int temp, p = 0, zae; boolean vertauscht;
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
		for(int i = 0; i<MAX; i++){
			p = i;
			for(int j = i+1; j<MAX; j++){
				if(arr[p] > arr[j]){
					p = j;
					vergleiche++;				
				}
			}
				temp = arr[i];
				arr[i] = arr[p];
				arr[p] = temp;
				vertausch+=3;
		}
				
				
		//Ausgabe Sortiert
		for(int i = 0; i<MAX; i++){
			System.out.print(arr[i] + ", ");	
			}	
		}
	}