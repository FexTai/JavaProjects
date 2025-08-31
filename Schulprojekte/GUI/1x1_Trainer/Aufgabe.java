import java.util.Random;

public class Aufgabe {
 private static Random generator=new Random();
 private int faktor1,faktor2;
 
 public void neu() {
  faktor1=generator.nextInt(10)+1;
  faktor2=generator.nextInt(10)+1;
 }
 
 public int ergebnis() {
  return(faktor1*faktor2);
 }
 
 public boolean richtig(int vermutung) {
  return(vermutung==ergebnis());
 }
 
 public boolean richtig(String vermutung) {
  try {
   return(richtig(Integer.parseInt(vermutung)));
  } catch(Exception e) {
   return(false);
  }
 }

 public String toString(boolean loesung) {
  if(loesung) {
   return(faktor1+"*"+faktor2+"="+ergebnis());
  } else {
   return(faktor1+"*"+faktor2+"=?");
  }
 }

 public String toString() {
  return(toString(false));
 }
 
 public Aufgabe() {
  neu();
 }

}
