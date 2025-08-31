public class StringStack {
    private StackElement oElement;

    //Konstruktor
    public StringStack() {
        this.oElement = null;
    }

    //Push
    public void push(String nameNeu) {
        StackElement neu = new StackElement(nameNeu);
        if (isEmpty()) {
            oElement = neu;
        } else {
            neu.setNaechster(oElement);
            oElement = neu;
        }
    }

    //Peek
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return oElement.getName();
    }

    //Pop
    public String pop() {
    	  String name;
    	  //Fall: Leere Liste
        if (isEmpty()) { return null; }
        //Fall: 1 Element in der Liste
        else if(oElement.getNaechster() == null){
			   name = oElement.getName();
			   oElement = null;     
        }
        else{
        		//Fall: mehr als 1 Element
        		name = oElement.getName();
        		oElement = oElement.getNaechster();
        }
        return name;
    }

    //Empty
    public boolean isEmpty() {
        return oElement == null;
    }

    //Ausgabe oben --> unten
    public void alleWerte() {
        StackElement aktuell = oElement;
        while (aktuell != null) {
            System.out.println(aktuell.getName());
            aktuell = aktuell.getNaechster();
        }
    }

	

	  /*
    //Ausgabe unten --> oben
    public void alleWerteUmgekehrt() {
        StackElement start = oElement;
        //Zum Anfang gehen
        while(aktuell.getNaechster()!=null){
            start = aktuell.getNaechster();
        }

        //Vom Anfang zum Ende gehen
        while(start.getNaechster() != oElement){
            System.out.println(start.getName());
            start = oElement.getNaechster();
        }
    }
    */
}
