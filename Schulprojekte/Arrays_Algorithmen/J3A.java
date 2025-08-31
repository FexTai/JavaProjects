import java.util.Scanner;
public class J3A {
    public static void main(String[] args) {
        //Initialisierung
        Scanner scanner = new Scanner(System.in);
        double eingabe; double[] arr = new double[1000]; int zae = 0;

        //Einfügen der Zahlen ins array
        for (int i = 0; i<arr.length; i++){
            System.out.println("Gib Wert " + (i+1) + " von " + arr.length + " ein: ");
            eingabe = scanner.nextDouble();
            if(eingabe<0){
                break;
            }
            arr[i] = eingabe;
            zae++;
        }

        //ausgabe der Sterne
        for(int i = 0; i<zae ;i++){
            int sterne = (int)arr[i]/10;
            for(int j = 0; j<sterne; j++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

}
