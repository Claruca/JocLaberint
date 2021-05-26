package joclaberint;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;

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
        laberint = new Laberint("laberints/maze1.txt");
        this.getContentPane().add(laberint);
        this.setSize(laberint.getPreferredSize());
        this.setBackground(new Color(0x26B300));
        this.pack();
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.addKeyListener(new MyKeyAdapter());
        Random rn = new Random();
        filesF = rn.nextInt(15);
        columnesF = rn.nextInt(10);
        laberint.Coloca(Fitxa.FITXA, filesF, columnesF);
        laberint.paintImmediately(laberint.getRectangle(filesF, columnesF));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        JocLaberint joc = new JocLaberint();
        joc.setVisible(true);
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            int[] parets = laberint.getCasella(filesF, columnesF);
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (parets[1] == 0) {
                    laberint.Coloca(Fitxa.FITXA, filesF, columnesF + 1);
                    laberint.repaint();
                    columnesF = columnesF + 1;
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
