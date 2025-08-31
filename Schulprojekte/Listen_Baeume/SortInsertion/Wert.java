public class Wert {
    private int wert;
    private Wert naechster=null;
    
    public void setWert(int wert) {
        this.wert=wert;
    }
    
    public int getWert() {
        return(wert);
    }
    
    public void add(Wert neuer) {
        naechster=neuer;
    }

    public static Wert get(Wert start,int nr) {
        Wert aktuell=start;
        for(int i=1;i<nr;i++) {
            if(aktuell==null) { break; }
            aktuell=aktuell.naechster;
        }        
        return(aktuell);
    }
    
    public static void alleWerte(Wert start) {
        Wert aktuell=start;
        while(aktuell!=null) {
            System.out.println(aktuell.getWert());
            aktuell=aktuell.naechster;    
        }
    }
    
    //Insert nach Wert
    public void ins(Wert neuer) {
        //aktuell = das aufrufende Objekt der Klasse Wert
        Wert aktuell = this;
        neuer.naechster = aktuell.naechster;
        aktuell.naechster = neuer;
    }

    //Insert an Stelle
    public void ins(Wert neuer, int nr){
        //aktuell = das aufrufende Objekt der Klasse Wert
        Wert aktuell = this;
        //Wenn nr > Anzahl elemente, dann am ende hinzufügen
        for(int i=1; i < nr && aktuell.naechster != null ;i++) {
            //Liste durchgehen
            aktuell=aktuell.naechster;
        }
        //Pfeil vom aktuellen Kopieren
        neuer.naechster = aktuell.naechster;
        //Pfeil vom aktuellen auf den neuen setzen
        aktuell.naechster = neuer;
    }

    public Wert(int wert) {
        setWert(wert);
    }
    
    public Wert() {
        this(0);
    }
    
    
}
