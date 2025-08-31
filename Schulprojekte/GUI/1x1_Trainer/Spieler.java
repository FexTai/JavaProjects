public class Spieler {
 private String name;
 private int versuche,richtige;
 
 public String getName() {
  return(name);
 }
 
 public void setName(String name) {
  this.name=name;
 }
 
 public int getVersuche() {
  return(versuche);
 }
 
 public void setVersuche(int versuche) {
  this.versuche=versuche;
 }

 public int getRichtige() {
  return(richtige);
 }
 
 public void setRichtige(int richtige) {
  this.richtige=richtige;
 }
 
 public void zaehle(boolean richtig) {
  versuche++;
  if(richtig) { richtige++; }
 }
 
 public double quote() {
  return((double)richtige/versuche);
 }
 
 public Spieler(String name) {
  this.name=name;
 }

}
