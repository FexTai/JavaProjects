public class JR3 {

	//Constructor
	JR3(String eingabe){
		int n;
		try{
			n = Integer.parseInt(eingabe);		
		}	catch(Exception e){n = 1;}	
		System.out.println("Rekursiv: " + folgeR(n));
		System.out.println("Iterativ: " + folgeI(n));	
	}
	
	
	//Rekursiv
	int folgeR(int x){
		if(x <= 0) { return(0); }
		else if(x == 1) { return(1); }
		else if(x == 2) { return(1); }	
		return folgeR(x-2) + folgeR(x-1);
	}	
	
	//Iterativ
	int folgeI(int x){
		if(x <= 0) { return(0); }
		int z1 = 0;
		int z2 = 1;
		int zw = 1;
		for(int i = 0; i<x;i++){
			z2 = zw;
			zw = z1+z2;
			z1 = z2;			
		}
		return(z2);
	}
	
	//Main
	public static void main(String[] args){
		new JR3(args[0]);	
	}	
	
}