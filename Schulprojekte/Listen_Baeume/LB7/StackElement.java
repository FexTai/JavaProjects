public class StackElement {
   private String name;
   private StackElement naechster;

   // Konstruktor
   public StackElement() {
       this.name = "";
       this.naechster = null;
   }

   public StackElement(String name) {
       this.name = name;
       this.naechster = null;
   }

   // Getter
   public String getName() {
       return name;
   }

   // Setter
   public void setName(String name) {
       this.name = name;
   }

   //Naechster
   public StackElement getNaechster() {
       return naechster;
   }

   public void setNaechster(StackElement naechster) {
       this.naechster = naechster;
   }
}
