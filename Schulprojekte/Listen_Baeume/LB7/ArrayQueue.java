public class ArrayQueue {
	 public final int MAX = 256;
    private StackPointer = 0, anfang = 0;
    private String[] queue = new String[MAX];

    //Konstruktor
    public StringQueue() {
        this.anfang = null;
    }

    public StringQueue(StackElement anfang) {
        this.anfang = anfang;
    }

    //add
    public void add(String nameNeu) {
        queue[StackPointer] = nameNeu;
        StackPointer++;
    }

    //Peek
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return queue[anfang];
    }

    //poll
    public String poll() {
    	  String name;
    	  //Fall: Leere Liste
        if (isEmpty()) { return null; }
        name = queue[anfang];
        anfang++;
        return name;
    }

    //Empty
    public boolean isEmpty() {
        return queue[anfang] == 0;
    }

}
