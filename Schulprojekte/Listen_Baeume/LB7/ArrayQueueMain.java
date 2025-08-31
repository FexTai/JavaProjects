import java.util.Scanner;

public class ArrayQueueMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringQueue queue = new StringQueue();
        StringQueue queue2 = new StringQueue();
        String eingabe;

        do {
            //Eingabe
            System.out.print("Gib einen Namen an (oder leer zum Beenden): ");
            eingabe = scanner.nextLine();

            //Überprüfung für 1. Durchlauf
            if (!eingabe.equals("")) {
                queue.add(eingabe);
            }
        } while (!eingabe.equals(""));
        
        // Ausgabe
        System.out.println("Deine Queue: ");

        // Poll
        System.out.println("Poll: " + queue.poll());
        
        // Peek
        System.out.println("Peek: " + queue.peek());
        queue.alleWerte();

		  // Ende
        System.out.println("Programm beendet.");
        scanner.close();

    }
}
