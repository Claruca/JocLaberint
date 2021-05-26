/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joclaberint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author clara
 */
public class Laberint extends JPanel {

    String fitxerLaberint;

    public int files;
    public int columnes;
    private final int COSTAT = 50;
    private Casella t[][];
    public static final int GRUIXPARET = 10;
    private int[] posicions = new int[4];
    private int sortidaFila;
    private int sortidaColumna;
    public static final String exit = "exit.png";
    private BufferedImage bi;

    private FileReader f;
    private BufferedReader br;

    public Laberint(String fitxer) {
        try {
            f = new FileReader(fitxer);
            br = new BufferedReader(f);
            files = Integer.parseInt(br.readLine());
            columnes = Integer.parseInt(br.readLine());
            t = new Casella[files][columnes];

            int y = 0;
            for (int i = 0; i < files; i++) {
                int x = 0;
                for (int j = 0; j < columnes; j++) {
                    //llegeix de 4 en 4 les files del fitxer
                    int l = 0;
                    for (l = 0; l < 4; l++) {
                        posicions[l] = br.read();
                        posicions[l] = posicions[l] / 49;
                    }

                    //comprovar lectura
                    for (int aja = 0; aja < posicions.length; aja++) {
                        System.out.print(posicions[aja]);
                    }
                    System.out.println("---------");

                    Rectangle2D.Float r = new Rectangle2D.Float(x, y, COSTAT, COSTAT);
                    Color col = new Color(0x26B300);
                    Rectangle2D.Float nord = new Rectangle2D.Float(x, y, COSTAT, GRUIXPARET);
                    Rectangle2D.Float est = new Rectangle2D.Float(x + COSTAT, y, GRUIXPARET, COSTAT);
                    Rectangle2D.Float sud = new Rectangle2D.Float(x, y + COSTAT, COSTAT, GRUIXPARET);
                    Rectangle2D.Float oest = new Rectangle2D.Float(x, y, GRUIXPARET, COSTAT);

                    t[i][j] = new Casella(r, col, nord, est, sud, oest, posicions[0], posicions[1], posicions[2], posicions[3]);
                    x += COSTAT;
                }
                y += COSTAT;
                br.readLine();
            }
            sortidaFila = Integer.parseInt(br.readLine());
            sortidaColumna = Integer.parseInt(br.readLine());
            System.out.println(sortidaFila + "  " + sortidaColumna);
            try {
                bi = ImageIO.read(new File(exit));
            } catch (IOException e) {
            }

        } catch (IOException | NumberFormatException e) {
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                t[i][j].paintComponent(g);
            }
        }
        g.drawImage(bi, (sortidaColumna - 1) * COSTAT + GRUIXPARET, sortidaFila * COSTAT, COSTAT, COSTAT, null);
    }

    void Coloca(String s, int i, int i0) {
        t[i][i0].setFitxa(new Fitxa(s));
    }

    Rectangle getRectangle(int i, int j) {
        return t[i][j].getRec().getBounds();
    }

    int[] getCasella(int i, int j) {
        int[] parets = t[i][j].getParets();
        t[i][j].borraFitxa();
        return parets;
        
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(columnes * COSTAT, files * COSTAT);
    }
    
    public int getFiles(){
        return files;
    }
    
     public int getColumnes(){
        return columnes;
    }

}
