import java.util.Scanner;
import java.util.Random;

public class J2_erwartet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int z; int[] arr = new int[50];


        System.out.println("Wie oft soll generiert werden?: ");
        int n = scanner.nextInt();

        for(int i = 0; i<n; i++){
            z = random.nextInt(49) + 1;
            arr[z]++;
        }

        for(int i = 0; i<49; i++){
            System.out.println(arr[i]);
        }
    }
}
