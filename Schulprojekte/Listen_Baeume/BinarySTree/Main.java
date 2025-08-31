import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib die Zahlen ein (Ende mit negativer Zahl):");

        Knoten wurzel = null;
        int eingabe = scanner.nextInt();

        // Werte einfügen
        while (eingabe >= 0) {
            if (wurzel == null) {
                wurzel = new Knoten(eingabe);
            } else {
                wurzel.insert(eingabe);
            }
			System.out.println("weiteren Wert eingeben: ");
            eingabe = scanner.nextInt();
        }

        // Ausgabe
        if (wurzel == null) {
            System.out.println("Keine gültige Eingabe. Kein Baum erstellt.");
        } else {
            System.out.println("\nIn-Order Traversierung:");
            wurzel.inOrder();

            System.out.println("\nPre-Order Traversierung:");
            wurzel.preOrder(); //Von Blätter zur Wurzel

            System.out.println("\nPost-Order Traversierung:");
            wurzel.postOrder(); //Ausgabe des Baumes wie er ist?
            System.out.println();

            System.out.println("\nLevel-Order Traversierung:");
            wurzel.levelOrderAusgabe(); //Alle Levels
            System.out.println();
        }
    }
}
