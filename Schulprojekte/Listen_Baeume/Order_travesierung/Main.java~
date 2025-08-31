import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		  String vorname = "";
		  String nachname = "";
		  int auswahl = 0;
        Baum baum = new Baum();

        	 do {
            System.out.print("(1) Schüler hinzufügen\n(2) Schüler suchen\n(3) Programm beenden/Baum ausgeben \n\n");
            auswahl = scanner.nextInt(); scanner.nextLine();
            //Einfügen
            if(auswahl == 1){
					System.out.print("Vorname: ");
            	vorname = scanner.nextLine();            	
            	
					System.out.print("Nachname: ");
            	nachname = scanner.nextLine();

            	System.out.print("Informatiknote:\n");
            	int note = scanner.nextInt(); scanner.nextLine();

            	Schueler s = new Schueler(vorname, nachname, note);
            	System.out.println("!"+s.vorname);
            	
					if(baum.wurzel == null){
						baum.setWurzel(s);		
						System.out.print("Schüler hinzugefügt\n\n");			
					}            	
            	else{
            		baum.add(baum.wurzel, s);
            		System.out.print("Schüler hinzugefügt\n\n"); 
            	}      
            }
            else if(auswahl == 2){
					//Suchen
					System.out.print("Vorname: ");
            	vorname = scanner.nextLine();            	
            	
					System.out.print("Nachname: ");
            	nachname = scanner.nextLine();
            	
            	System.out.println(baum.suche(vorname, nachname, baum.wurzel));
            	           
            }
        }while(auswahl < 3 && auswahl > 0);

        // Traversierung anzeigen
        System.out.println("\nIn-Order Traversierung:");
        for (Schueler s : baum.inOrder()) {
            System.out.println(s);
        }

        System.out.println("\nPre-Order Traversierung:");
        for (Schueler s : baum.preOrder()) {
            System.out.println(s);
        }

        System.out.println("\nPost-Order Traversierung:");
        for (Schueler s : baum.postOrder()) {
            System.out.println(s);
        }
        
		  System.out.println("\nLevel-Order Traversierung:");
        for (Schueler s : baum.wurzel.levelOrderAusgabe()) {
            System.out.println(s);
        }        
    }
}
