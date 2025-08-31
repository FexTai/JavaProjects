package infoLk;

import java.util.Scanner;
import java.util.Random;

public class JA7_a {
    public static void main(String[] args) {
        // Initialisierung
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int LEN = 100;
        int[] zahlen = new int[LEN];
        int zaehler = 0, zufZahl, vorkommen;
        int eingabe;

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
        System.out.println("Das Array enthält die folgenden Zahlen:");
        for (int i = 0; i < LEN; i++) {
            System.out.print(zahlen[i] + " ");
        }
        System.out.println();

        // Zahl suchen + Position ausgeben
        System.out.println("Welche Zahl suchst du?: ");
        eingabe = scanner.nextInt();

        for (int i = 0; i < LEN; i++) {
            if (zahlen[i] == eingabe) {
                System.out.println("Die Zahl " + eingabe + " befindet sich an Stelle " + (i + 1) + " im Array.");
                System.exit(0); // Programm beenden, da die Zahl gefunden wurde
            }
        }
        System.out.println("Die Zahl " + eingabe + " befindet sich nicht im Array!");
    }
}

//Das Höchste, was er brauchen kann ist 100, da er jedes element durchsuchen muss oder 1, wenn es direkt am anfang ist
//Bei der Suche wird jedes Element des Arrays überprüft und die Wahrscheinlichkeit für die Zahl an jeder beliebigen Stelle
//zu stehen ist gleich.
//Also müssten es theoretisch ca die hälfte vom arrays im Schnitt sein?
