import java.util.*;
import java.io.*;
public class J6_done {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] anzahl = new int[26];
        String dateiname;
        File datei; String zeile;

        do {
            System.out.println("Gib den Dateinamen ein: ");
            dateiname = scanner.nextLine();
            datei = new File(dateiname+".txt");
        }while(!datei.exists());

        try(Scanner lesen = new Scanner(datei)) {
            while(lesen.hasNextLine()){
                zeile = lesen.nextLine().toUpperCase();
                for(int i = 0; i < zeile.length(); i++){
                    if((int) zeile.charAt(i) <65 || (int) zeile.charAt(i) >90){continue;}
                    anzahl[(int) zeile.charAt(i) - 65 ]++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            }
        for(int i = 0; i<anzahl.length;i++){
            System.out.println("Der Buchstabe " + (char) (65 + i) + " kam " + anzahl[i] + " mal vor");
        }
        }

    }

