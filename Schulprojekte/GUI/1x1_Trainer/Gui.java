import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame {
 private final int MAXSPIELER=3;

 private JLabel laufgabe=new JLabel("-");
 private JLabel lspieler=new JLabel("-");
 private JLabel lergebnis=new JLabel("-");
 private JLabel lliste;
 private JButton bneu=new JButton("Neue Aufgabe");
 private JButton bpruefen=new JButton("Überprüfen");
 private JButton bhinzu=new JButton("Hinzufügen");
 private JTextField tantwort=new JTextField(3);
 private JTextField tspieler=new JTextField(30);
 
 private Spielerliste liste=new Spielerliste();
 private Aufgabe aufgabe=new Aufgabe();
 private Spieler spieler;
 private boolean richtig=true;

 private class Neu implements ActionListener {
  public void actionPerformed(ActionEvent e) {
   aufgabe.neu(); richtig=false;
   laufgabe.setText(aufgabe.toString());
   spieler=liste.get();
   if(spieler==null) {
    lspieler.setText("Kein Spieler");
   } else {
    lspieler.setText(spieler.getName());
   }
  }
 }
 
 private class Pruefen implements ActionListener {
  public void actionPerformed(ActionEvent e) {
   if(!tantwort.getText().equals("") && !richtig) {
    String antwort=tantwort.getText();
    richtig=aufgabe.richtig(antwort);
    lergebnis.setText(antwort+" ist "+(richtig?"richtig":"falsch"));
    if(spieler!=null) {
     spieler.zaehle(richtig);
     lliste.setText(liste.html(MAXSPIELER,true));
    }
   }
  }
 }

 private class Hinzu implements ActionListener {
  public void actionPerformed(ActionEvent e) {
   if(!tspieler.getText().equals("") && liste.anzahl()<MAXSPIELER) {
    liste.add(new Spieler(tspieler.getText()));
    lliste.setText(liste.html(MAXSPIELER,true));
   }
  }
 }
 
 public Gui() {
  super("1x1-Trainer");
  setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  setLayout(new GridLayout(9,1));

  bneu.setMnemonic('n'); bneu.addActionListener(new Neu());
  add(bneu);
  add(laufgabe);
  add(lspieler);
  tantwort.addActionListener(new Pruefen());
  add(tantwort);
  bpruefen.setMnemonic('p'); bpruefen.addActionListener(new Pruefen());
  add(bpruefen);
  add(lergebnis);
  lliste=new JLabel(liste.html(MAXSPIELER,false)); add(lliste);
  tspieler.addActionListener(new Hinzu());
  add(tspieler);   
  bhinzu.setMnemonic('h'); bhinzu.addActionListener(new Hinzu());
  add(bhinzu);

  
  pack();
  setVisible(true);
 }

}
