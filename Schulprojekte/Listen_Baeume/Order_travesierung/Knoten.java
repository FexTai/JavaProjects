import java.util.LinkedList;
public class Knoten {
    Schueler wert;
    Knoten links, rechts;
		
    Knoten(Schueler wert) {
        this.wert = wert;
    }

    //WLR
    public void preOrder(LinkedList<Schueler> liste) {
        liste.add(wert);
        if (links != null) links.preOrder(liste);
        if (rechts != null) rechts.preOrder(liste);
    }

    //LWR
    public void inOrder(LinkedList<Schueler> liste) {
        if (links != null) links.inOrder(liste);
        liste.add(wert);
        if (rechts != null) rechts.inOrder(liste);
    }

    //LRW
    public void postOrder(LinkedList<Schueler> liste) {
        if (links != null) links.postOrder(liste);
        if (rechts != null) rechts.postOrder(liste);
        liste.add(wert);
    }
    
    //LVL
    public int levelOrder(LinkedList<Schueler> liste,Knoten knoten, int level, int hilf){
    	if (knoten == null) return hilf;
      if (level == 1) {
          liste.add(knoten.wert);
          hilf++;
      } else {
          hilf = levelOrder(liste, knoten.links, level - 1, hilf);
          hilf = levelOrder(liste, knoten.rechts, level - 1, hilf);
      }
      return hilf;
    }
    
    //LVL-Hilfe
    public LinkedList<Schueler> levelOrderAusgabe() {
        int level = 1;
        LinkedList<Schueler> liste = new LinkedList<Schueler>();
        while (true) {
            int hilf = 0;                					// Zähler zurücksetzen
            hilf = levelOrder(liste, this, level, hilf);    // aktuelles Level ausgeben
            if (hilf == 0) break;    					 // wenn knoten == null -> hilf == 0 -> fertig
            System.out.println(); 
            level++;
        }
        return liste;
    }
}
