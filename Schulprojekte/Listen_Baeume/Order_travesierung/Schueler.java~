public class Schueler {
    String vorname, nachname;
    int infNote;

    // Konstruktor
    Schueler(String v, String n, int iNote) {
       vorname = v;
       nachname = n;
       infNote = iNote;
       System.out.println(vorname+" "+nachname+"|"+infNote);
    }

    public String toString() {
        return nachname + ", " + vorname + " (Note: " + infNote + ")";
    }
    
    public int compareTo(Schueler neu){
	 	int cmp;
	 	cmp = nachname.compareToIgnoreCase(neu.nachname);
	 	if(cmp == 0){
			cmp = vorname.compareToIgnoreCase(neu.vorname);	 	
	 	}
	 	return cmp;    
    }
}
