public class JR5 {
	String[] daten;
	
	//Konstruktor
	JR5(String[] args){
		daten = args;	
		int l = daten.length;
		quickSort(0, l-1);
		for(String s:daten){
			System.out.println(s);		
		}
	}	
	
	//Quicksort
	void quickSort(int links, int rechts){
		int teiler = 0;
		if(links < rechts){
			teiler = teile(links, rechts);
			quickSort(links, teiler - 1);
         quickSort(teiler + 1, rechts);
		}	
	}
	
	//Teiler
	int teile(int links, int rechts){
		int i = links;
		// Starte mit j links vom Pivotelement
     	int j = rechts - 1;
     	String pivot = daten[rechts];
     	
     	while(i < j){
			while(i<j && daten[i].compareToIgnoreCase(pivot) <= 0){
				i = i+1;
			}
			
			while(j>i && daten[j].compareToIgnoreCase(pivot) > 0){
				j = j-1;			
			}
			
			if(daten[i].compareToIgnoreCase(daten[j]) > 0){
				String k = daten[i];
				daten[i] = daten[j];
				daten[j] = k;			
			}		     	
     	}
     	if(daten[i].compareToIgnoreCase(pivot) > 0){
			String m = daten[i];
			daten[i] = daten[rechts];
			daten[rechts] = m;  	
     	}else{ i = rechts;}	
     	return(i);
	}
	
	
	//Main
	public static void main(String[] args){
		new JR5(args);	
	}
}