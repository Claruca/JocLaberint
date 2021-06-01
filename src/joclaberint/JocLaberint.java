package joclaberint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author clara
 */
public class JocLaberint extends JFrame {

    Laberint laberint;
    int filesF;
    int columnesF;

    public JocLaberint() {
        super("Joc del laberint");
        laberint = new Laberint("laberints/maze4.txt");
        this.getContentPane().add(laberint);
        this.setBackground(new Color(0x211F1E));
        this.pack();
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.addKeyListener(new MyKeyAdapter());
        Random rn = new Random();
        filesF = rn.nextInt(15);
        columnesF = rn.nextInt(10);
        laberint.Coloca(Fitxa.FITXA, filesF, columnesF);
        laberint.paintImmediately(laberint.getRectangle(filesF, columnesF));

        //Menú
        JMenuBar mb = new JMenuBar();
        JMenu fitxer = new JMenu("Fitxer");
        JMenuItem nou = new JMenuItem("Nou");
        JMenuItem reinicia = new JMenuItem("Reinicia");
        JMenuItem sortir = new JMenuItem("Sortir");
        setLayout(new BorderLayout());

        mb.add(fitxer);
        fitxer.add(nou);
        fitxer.add(reinicia);
        fitxer.add(sortir);     
        
        laberint.add(mb);
       

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        JocLaberint joc = new JocLaberint();
        joc.setVisible(true);
    }

    //Moviments teclat
    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            int[] parets = laberint.getCasella(filesF, columnesF);
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (parets[1] == 0) {
                    if (columnesF >= (laberint.columnes - 1)) {
                        UIManager UI = new UIManager();
                        UI.put("OptionPane.background", new Color(0x211F1E));
                        UI.put("Panel.background", new Color(0xB55200));
                        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 16));
                        //UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 12));                        
                        JOptionPane.showMessageDialog(null, "HAS GUANYAT!!");

                    } else {
                        laberint.Coloca(Fitxa.FITXA, filesF, columnesF + 1);
                        laberint.repaint();
                        columnesF = columnesF + 1;
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (parets[3] == 0) {
                    laberint.Coloca(Fitxa.FITXA, filesF, columnesF - 1);
                    laberint.repaint();
                    columnesF = columnesF - 1;
                }

            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (parets[0] == 0) {
                    laberint.Coloca(Fitxa.FITXA, filesF - 1, columnesF);

                    laberint.repaint();
                    filesF = filesF - 1;
                }

            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (parets[2] == 0) {
                    laberint.Coloca(Fitxa.FITXA, filesF + 1, columnesF);

                    laberint.repaint();
                    filesF = filesF + 1;
                }

            }

        }
    }

}
