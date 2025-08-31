public class Felder{
	private static final int[] ROT = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
	
	public static String getFarbe(int zahl){
		if(zahl==0) {return "grün";}
		for(int i = 0; i<ROT.length; i++){
			if(zahl == ROT[i]){
				return "rot";			
			}		
		}
		return "schwarz";	
	}
}