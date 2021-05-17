
package joclaberint;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author clara
 */
public class JocLaberint extends JFrame{

   Laberint laberint;
   
   public JocLaberint(){
       super("Joc del laberint");
       laberint = new Laberint();
       this.getContentPane().add(laberint);
       this.setSize(laberint.getPreferredSize());
       this.setBackground(Color.GRAY);
       this.pack();
       this.setResizable(false);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   
   }
   
   
    public static void main(String[] args) {
        JocLaberint joc = new JocLaberint();
        joc.setVisible(true);
    }
    
}
