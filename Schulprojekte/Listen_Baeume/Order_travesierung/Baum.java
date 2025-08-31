import java.util.LinkedList;

public class Baum {
    Knoten wurzel = null;

	 //Hinzufügen
    public void add(Knoten s, Schueler neu) {
    	int cmp = s.wert.compareTo(neu);
      if (cmp > 0) {
      	if (s.links == null) {
         	s.links = new Knoten(neu);
         } else {
         	add(s.links, neu);
            }
        	} else {
         	if (s.rechts == null) {
               s.rechts = new Knoten(neu);
            } else {
            	 add(s.rechts, neu);
            }
        }
    }

	 //preOrder
    public LinkedList<Schueler> preOrder() {
        LinkedList<Schueler> liste = new LinkedList<>();
        if (wurzel != null) {
            wurzel.preOrder(liste);
        }
        return liste;
    }

    //inOrder
    public LinkedList<Schueler> inOrder() {
        LinkedList<Schueler> liste = new LinkedList<>();
        if (wurzel != null) {
            wurzel.inOrder(liste);
        }
        return liste;
    }

    //postOrder
    public LinkedList<Schueler> postOrder() {
        LinkedList<Schueler> liste = new LinkedList<>();
        if (wurzel != null) {
            wurzel.postOrder(liste);
        }
        return liste;
    }
    
    
    //SetWurzel
    public void setWurzel(Schueler s){
	 	wurzel = new Knoten(s);    
    }
    
    //Suche
    public Schueler suche (String v, String n, Knoten startpunkt){
    	Knoten aktuell = wurzel; 
    	//Hilfsobjekt
    	Schueler s = new Schueler(v,n,0);
    	Schueler vs = aktuell.wert;
    	if(aktuell == null){
			System.out.println("Kein Baum vorhanden, Schüler hinzufügen!");
			return null;    	
    	}
      if (vs.compareTo(s) == 0) {
      	return aktuell.wert;
      } else if(vs.compareTo(s) < 0) {
        	suche(v, n, aktuell.links);
         }
        else if (vs.compareTo(s) > 0) {
          suche(v, n, aktuell.rechts);
         }
	 	return aktuell.wert; 
    }
}
