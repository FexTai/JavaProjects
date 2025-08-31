import java.util.Scanner;
import java.util.Random;

public class JA8 {
    public static void main(String[] args) {
        // Initialisierung
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int k = 0;
        final int LEN = 100;
        int[] zahlen = new int[LEN];
        int zaehler = 0, zufZahl, summe = 0, dl = 0, durch;
        int eingabe;

        System.out.println("Wie viele durchläufe?");
        durch = scanner.nextInt();

        do {
            dl++;
            zaehler = 0; // Rücksetzen des Zählers für jeden Durchlauf
            // Einschreibung mit sortiertem Einfügen
            while (zaehler < LEN) {
                zufZahl = random.nextInt(1000) + 1;
                // finde die richtige Position, um die Zahl einzufügen
                int pos = 0;
                while (pos < zaehler && zahlen[pos] < zufZahl) {
                    pos++;
                }
                // verschiebe die Elemente ab der Position "pos", um Platz zu machen
                for (int i = zaehler; i > pos; i--) {
                    zahlen[i] = zahlen[i - 1];
                }
                // füge die neue Zufallszahl an der gefundenen Position ein
                zahlen[pos] = zufZahl;
                zaehler++;
            }

            // Array-Inhalt ausgeben
            System.out.println("\nDas Array enthält die folgenden Zahlen (sortiert):");
            for (int i = 0; i < LEN; i++) {
                System.out.print(zahlen[i] + " ");
            }
            System.out.println();

            // Zufällige Zahl auswählen, die gesucht werden soll
            eingabe = random.nextInt(1000) + 1;
            
            //Suche
            int left = 0, right = LEN - 1, attempts = 0;
            boolean found = false;
            while (left <= right) {
                attempts++;
                int mid = left + (right - left) / 2;
                if (zahlen[mid] == eingabe) {
                    summe += attempts; // Anzahl der Versuche bis zum Finden der Zahl
                    k++;
                    System.out.println("Die Zahl " + eingabe + " befindet sich an Stelle " + (mid + 1) + " im Array.\n");
                    found = true;
                    break;
                } else if (zahlen[mid] < eingabe) {
                    left = mid + 1; // suche im rechten Teil weiter
                } else {
                    right = mid - 1; // suche im linken Teil weiter
                }
            }
            if (!found) {
                System.out.println("Die Zahl " + eingabe + " befindet sich nicht im Array!");
            }
        } while (dl < durch);

        System.out.println("Durchschnitt der Versuche bis zum Finden: " + (double) summe / k);
    }
}
