public class StringQueue {
    private StackElement anfang, letzter;

    //Konstruktor
    public StringQueue() {
        this.anfang = null;
    }

    public StringQueue(StackElement anfang) {
        this.anfang = anfang;
    }

    //add
    public void add(String nameNeu) {
        StackElement neu = new StackElement(nameNeu);
        if (isEmpty()) {
            anfang = neu;
            letzter = neu;
        } else {
            letzter.setNaechster(neu);
            letzter = neu;
        }
    }

    //Peek
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return anfang.getName();
    }

    //poll
    public String poll() {
    	  String name;
    	  //Fall: Leere Liste
        if (isEmpty()) { return null; }
        //Fall: 1 Element in der Liste
        else if(anfang.getNaechster() == null){
			   name = anfang.getName();
			   anfang = null;     
        }
        else{
        		//Fall: mehr als 1 Element
        		name = anfang.getName();
        		anfang = anfang.getNaechster();
        }
        return name;
    }

    //Empty
    public boolean isEmpty() {
        return anfang == null;
    }

    //Ausgabe oben --> unten
    public void alleWerte() {
        StackElement aktuell = anfang;
        while (aktuell != null) {
            System.out.print(" <-- " + aktuell.getName());
            aktuell = aktuell.getNaechster();
        }
        System.out.println("");
    }

}
