import java.util.Scanner;

public class StringStackMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringStack stack = new StringStack();
        StringStack stack2 = new StringStack();
        String eingabe;

        do {
            //Eingabe
            System.out.print("Gib einen Namen an (oder leer zum Beenden): ");
            eingabe = scanner.nextLine();

            //Überprüfung für 1. Durchlauf
            if (!eingabe.equals("")) {
                stack.push(eingabe);
                System.out.println("Aktueller Stack:");
                stack.alleWerte();
            }
        } while (!eingabe.equals(""));
        
        
        // Umgekehrter Stack
        System.out.println("\nUmgekehrter Stack:");
        while(!stack.isEmpty()){
        		stack2.push(stack.pop());
        }
        stack2.alleWerte();
        

		  // Ende
        System.out.println("Programm beendet.");
        scanner.close();

    }
}
