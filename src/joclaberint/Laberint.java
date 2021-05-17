/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joclaberint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JPanel;

/**
 *
 * @author clara
 */
public class Laberint extends JPanel {

    public int files = 15;
    public int columnes = 10;

    public final int DIMENSIO = files;
    private final int COSTAT = 50;
    private final int MAXIMF = files * COSTAT;
    private final int MAXIMC = columnes * COSTAT;
    private Casella t[][];

    private int[] posicions = new int[4];
    String fitxerLaberint;

    private FileReader f;
    private BufferedReader br;
/*
    public Laberint(String fitxer) {
        try {
            f = new FileReader(fitxer);
            br = new BufferedReader(f);

            files = Integer.parseInt(br.readLine());
            columnes = Integer.parseInt(br.readLine());

            t = new Casella[files][columnes];
            
            //llegeix de 4 en 4 les files del fitxer
            for (int i = 0; i < 10; i++) {                
                for(int j=0; j<4;j++){
                    posicions[j] = br.read();
                } 
                
                
            }

        } catch (Exception e) {
        }

    }*/

    public Laberint() {
        t = new Casella[files][columnes];
        int y = 0;
        for (int i = 0; i < files; i++) {
            int x = 0;
            for (int j = 0; j < columnes; j++) {
                Rectangle2D.Float r = new Rectangle2D.Float(x, y, COSTAT, COSTAT);               
                Color col;                
                
                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    col = Color.CYAN;
                } else {
                    col = Color.ORANGE;
                }               

                t[i][j] = new Casella(r, col);
                x += COSTAT;
            }

            y += COSTAT;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                t[i][j].paintComponent(g);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MAXIMC, MAXIMF);
    }

}
