
public class Knoten {
    int wert;
    Knoten links = null;
    Knoten rechts = null;

    public Knoten(int wert) {
        this.wert = wert;
    }

    // Einfügen
    public void insert(int wert) {
        if (wert < this.wert) {
            if (this.links == null) {
                this.links = new Knoten(wert);
            } else {
                this.links.insert(wert);
            }
        } else if (wert > this.wert) {
            if (this.rechts == null) {
                this.rechts = new Knoten(wert);
            } else {
                this.rechts.insert(wert);
            }
        }
    }

    // In-Order
    public void inOrder() {
        if (this.links != null) this.links.inOrder();
        System.out.print(this.wert + " ");
        if (this.rechts != null) this.rechts.inOrder();
    }

    // Pre-Order
    public void preOrder() {
        System.out.print(this.wert + " ");
        if (this.links != null) this.links.preOrder();
        if (this.rechts != null) this.rechts.preOrder();
    }

    // Post-Order
    public void postOrder() {
        if (this.links != null) this.links.postOrder();
        if (this.rechts != null) this.rechts.postOrder();
        System.out.print(this.wert + " ");
    }

   // Level-order
    public int levelOrder(Knoten knoten, int level, int hilf) {
        if (knoten == null) return hilf;
        if (level == 1) {
            System.out.print(knoten.wert + " ");
            hilf++;
        } else {
            hilf = levelOrder(knoten.links, level - 1, hilf);
            hilf = levelOrder(knoten.rechts, level - 1, hilf);
        }
        return hilf;
    }

    // Traversierung Level für Level
    public void levelOrderAusgabe() {
        int level = 1;
        while (true) {
            int hilf = 0;                // Zähler zurücksetzen
            hilf = levelOrder(this, level, hilf);    // aktuelles Level ausgeben
            if (hilf == 0) break;    // wenn knoten == null -> hilf == 0 -> fertig
            System.out.println(); 
            level++;
        }
    }
}