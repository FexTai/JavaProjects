package infoLk;

import java.util.Scanner;
import java.util.Random;

public class JA7_b {
    public static void main(String[] args) {
        // Initialisierung
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int LEN = 100;
        int[] zahlen = new int[LEN];
        int zaehler = 0, zufZahl, vorkommen, summe = 0, dl = 0;
        int eingabe;

        do {
            dl++;
            // Einschreibung ohne Dopplungen
            while (zaehler < LEN) {
                zufZahl = random.nextInt(1000) + 1; // Zufallszahl zwischen 1 und 1000
                vorkommen = 0;
                // nach Dopplungen suchen
                for (int i = 0; i < zaehler; i++) {
                    if (zahlen[i] == zufZahl) {
                        vorkommen++;
                        break; // falls die Zahl bereits existiert, Schleife abbrechen
                    }
                }
                // Dopplungen ausschließen
                if (vorkommen == 0) {
                    zahlen[zaehler] = zufZahl;
                    zaehler++;
                }
            }

            // Array-Inhalt ausgeben
            System.out.println("\nDas Array enthält die folgenden Zahlen:");
            for (int i = 0; i < LEN; i++) {
                System.out.print(zahlen[i] + " ");
            }
            System.out.println();

            // Zahl suchen + Position ausgeben
            System.out.println("Welche Zahl suchst du?: ");
            eingabe = scanner.nextInt();

            for (int i = 0; i < LEN; i++) {
                if (zahlen[i] == eingabe) {
                    System.out.println("Die Zahl " + eingabe + " befindet sich an Stelle " + (i + 1) + " im Array.\n");
                    break;
                }
                if(i == LEN-1){
                    summe += i;
                    System.out.println("Die Zahl " + eingabe + " befindet sich nicht im Array!");
                }
            }
        }while(dl < 10);
        System.out.println("Durchscnitt = " + summe/dl);
    }
}
