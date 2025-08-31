import java.util.ArrayList;
import java.util.Random;

public class Spielerliste {
 private ArrayList<Spieler> liste=new ArrayList<Spieler>();
 private static Random generator=new Random();

 public int anzahl() {
  return(liste.size());
 }
 
 public void add(Spieler s) {
  liste.add(s);
 }
 
 public Spieler get(int nr) {
  if(nr<anzahl()) {
   return(liste.get(nr));
  } else {
   return(null);
  }
 }

 public Spieler get() {
  if(anzahl()>0) {
   return(get(generator.nextInt(anzahl())));
  } else {
   return(null);
  }
 }

 public String html(int zeilen,boolean statistik) {
  String html="<html>";
  Spieler s;
  
  for(int i=0;i<zeilen;i++) {
   if(i<anzahl()) {
    s=get(i);
    html=html+s.getName();
    if(statistik) {
     html=html+": "+s.getRichtige()+"/"+s.getVersuche()+"="
              +(s.getVersuche()==0?"-":s.quote()*100)+"%";
    }
   } else {
    html=html+"-";
   }
   if(i<zeilen-1) { html=html+"<br>"; }
  }
  return(html+"</html>");
 }
 
 private String html() {
  return(html(anzahl(),false));
 }
 
 public boolean speichern(String name) {
  // Rückgabe true bei Erfolg, false bei Fehler
  // noch einzubauen
  return(false); 
 }
 
 public boolean laden(String name) {
  // Rückgabe true bei Erfolg, false bei Fehler
  // noch einzubauen
  return(false); 
 }

}
