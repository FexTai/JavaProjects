import java.util.ArrayList;

public class SpielerListe {
    private ArrayList<Spieler> liste = new ArrayList<Spieler>();
    StartReiter startReiter;

    public int anzahl() {
        return(liste.size());
    }

    public Spieler get(int nr) {
        return liste.get(nr);
    }

    public void add(Spieler s) {
        startReiter.addAuswahlArray(s.getName());
        liste.add(s);
    }

    public SpielerListe(Spieler s, StartReiter startReiter) {
        this.startReiter = startReiter;
        add(s);
    }
}
