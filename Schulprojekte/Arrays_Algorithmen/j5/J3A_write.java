package infoLk;

import java.util.*;
import java.io.*;

public class J3A_write {
    public static void main(String[] args) {
        // Initialisierung der Variablen
        Scanner scanner = new Scanner(System.in);
        Scanner eingabe1 = null;
        double eingabe = 0;
        double[] arr = new double[1000];
        int zae = 0;
        PrintWriter ausgabe = null;
        String dateiname;
        boolean exist, fehler;
        File datei;
        String zeile;

        // Wiederholte Abfrage des Dateinamens bis eine gültige Datei ausgewählt wird
        do {
            System.out.println("Gib den Dateinamen ein: ");
            dateiname = scanner.nextLine();
            datei = new File(dateiname);
            exist = datei.exists();

            // Falls die Datei bereits existiert
            if (exist) {
                System.out.println("\nDatei existiert bereits!\nÜberschreiben?: ");
                if (scanner.nextLine().toLowerCase().equals("nein")) {
                    // Dateiinhalt anzeigen, falls nicht überschrieben werden soll
                    try {
                        System.out.println("\nEingelesener Inhalt: ");
                        eingabe1 = new Scanner(new File(dateiname));
                        while (eingabe1.hasNextLine()) {
                            zeile = eingabe1.nextLine();
                            System.out.println(zeile);

                            // Eingelesene Werte ins Array speichern
                            arr[zae] = Double.parseDouble(zeile);
                            zae++;
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        if (eingabe1 != null) {
                            try { eingabe1.close(); } catch(Exception ignored) {}
                        }
                    }

                    // Balkendiagramm für die eingelesenen Werte zeichnen
                    System.out.println("\nBalkendiagramm für eingelesene Werte:");
                    for (int i = 0; i < zae; i++) {
                        int sterne = (int) arr[i] / 10;
                        for (int j = 0; j < sterne; j++) {
                            System.out.print("*");
                        }
                        System.out.println(" ");
                    }

                    // Programm beenden, falls nicht überschrieben wird
                    System.exit(0);
                } else {
                    // Wenn die Datei überschrieben werden soll, brich die Schleife ab
                    break;
                }
            }
        } while (exist);

        // Zahlenwerte eingeben und in Datei speichern
        try {
            ausgabe = new PrintWriter(dateiname);
            for (int i = zae; i < arr.length; i++) { // Beginne bei zae, falls es bereits eingelesene Werte gibt
                System.out.println("\nGib Wert " + (i + 1) + " von " + arr.length + " ein: ");
                do {
                    try {
                        fehler = false;
                        eingabe = Double.parseDouble(scanner.nextLine());
                    } catch (Exception e) {
                        fehler = true;
                        System.out.println("\nGib eine Zahl ein: ");
                    }
                } while (fehler);

                // Falls negative Zahl eingegeben wird, Eingabe beenden
                if (eingabe < 0) {
                    break;
                }

                arr[i] = eingabe;
                zae++;
                ausgabe.println(eingabe); // In Datei schreiben
                System.out.println("Wert " + eingabe + " in die Datei geschrieben.");
            }
        } catch (Exception e) {
            // Fehlerbehandlung
            System.out.println(e);
        } finally {
            if (ausgabe != null) {
                try { ausgabe.close(); } catch(Exception ignored) {}
            }
        }

        // Ausgabe der Sterne basierend auf den Eingaben (inklusive der eingelesenen Werte)
        System.out.println("\nBalkendiagramm");
        for (int i = 0; i < zae; i++) {
            int sterne = (int) arr[i] / 10;
            for (int j = 0; j < sterne; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
