import java.util.Scanner;

public class JR1{

	//Constructor
	JR1(){
		int n;
		n = eingabe();
		while(n <= 0){
			System.out.println("Nur Nummern über der 0: ");
			n = eingabe();
		}

		System.out.println("Rekursiv: " + folgeR(n));
		System.out.println("Iterativ " + folgeI(n));
		System.out.println("Explizit " + folgeZ(n));
	}



	//Rekursive Folge
	double folgeR(int x){
		if(x == 1){
			return(1);		
		}
		else{return(folgeR(x-1) * ((double) 1/3));}
	}

	//Iterative Folge
	double folgeI(int x){
		double a = 1;
		for(int i = 1; i<x; i++){
			a *= 1.0 /3;
		}
		return a;
	}

	//Explizite Folge
	double folgeZ(int x) {
		return Math.pow(1.0/3.0, x-1);
	}


	//Eingabemethode
	int eingabe(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Gib die Stelle an: ");
		return scanner.nextInt();
	}

	//Main
	public static void main(String[] args){
			new JR1();
	}
}