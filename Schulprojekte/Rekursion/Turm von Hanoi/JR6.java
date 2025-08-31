import java.util.Scanner;
public class JR6{
    public static void main(String[] args) {
        //Initialisierungen
        int anzahl;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Scheiben hat der Turm? ");
        anzahl = scanner.nextInt();

        //Aufruf
        hanoi(anzahl, 1, 3);
    }

    //rekursive Lösung
    public static void hanoi(int anzahl, int start, int ende){
        //Endbedingung bzw Ausgabe
        if (anzahl == 1){
            ausgabe(start, ende);
        }
        else{
            //freie Stab
            int stab = 6 - (start + ende);
            //Obersten Elemente auf den 2. Stab bringen
            hanoi(anzahl-1, start, stab); //Stab wird  das neue Ende
            ausgabe(start, ende); //Element auf den mittleren Stab bringen

            //Turm von 2 nach 3 bringen
            hanoi(anzahl-1, stab, ende);
        }
    }
    public static void ausgabe(int start, int ende){
        System.out.println("Bewege Scheibe von " + start + " --> " + ende);
    }
}

//Exponentielle Laufzeit?