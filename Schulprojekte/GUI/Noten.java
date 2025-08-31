import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JG2 extends JFrame {
	JLabel label=new JLabel("                                                          ");
	
  private class Knopfhoerer1 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      label.setText("Sehr gut");
    }
  }
  
  private class Knopfhoerer2 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      label.setText("gut");
    }
  }
  
  private class Knopfhoerer3 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      label.setText("noch gut");
    }
  }
  
  private class Knopfhoerer4 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      label.setText("Ausreichend");
    }
  }
  
private class Knopfhoerer5 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      label.setText("Mangelhaft");
    }
  }
  
  private class Knopfhoerer6 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      label.setText("nicht ausreichend");
    }
  }
 
  JG2() {
    super("JG2");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLayout(new FlowLayout()); 
    add(label);
    
    JButton button1=new JButton("1");
    button1.addActionListener(new Knopfhoerer1());
    add(button1);
    
    JButton button2=new JButton("2");
    button2.addActionListener(new Knopfhoerer2());
    add(button2);
    
    JButton button3=new JButton("3");
    button3.addActionListener(new Knopfhoerer3());
    add(button3);
    
    JButton button4=new JButton("4");
    button4.addActionListener(new Knopfhoerer4());
    add(button4);
    
    JButton button5=new JButton("5");
    button5.addActionListener(new Knopfhoerer5());
    add(button5);
    
    JButton button6=new JButton("6");
    button6.addActionListener(new Knopfhoerer6());
    add(button6);
  }
 
  public static void main(String[] args) {
    JG2 fenster=new JG2(); 
    fenster.pack();
    fenster.setVisible(true);
  }
 
}