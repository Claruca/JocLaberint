package joclaberint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author clara
 */
public class Casella {

    private Rectangle2D.Float rec;
    private Rectangle2D.Float rN;
    private Rectangle2D.Float rE;
    private Rectangle2D.Float rS;
    private Rectangle2D.Float rO;
    private Color col;
    private boolean ocupada;
    private Fitxa fitxa;
    //private int[] posicions;
    private int paretN;
    private int paretE;
    private int paretS;
    private int paretO;

    public Casella(Rectangle2D.Float rec, Color col, Rectangle2D.Float rN, Rectangle2D.Float rE, Rectangle2D.Float rS, Rectangle2D.Float rO, int paretN, int paretE, int paretS, int paretO) {
        this.rec = rec;
        this.col = col;
        this.ocupada = false;
        this.fitxa = null;
        this.rN = rN;
        this.rE = rE;
        this.rS = rS;
        this.rO = rO;
        this.paretN = paretN;
        this.paretE = paretE;
        this.paretS = paretS;
        this.paretO = paretO;
        // this.posicions = posicions;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.col);
        g2d.fill(this.rec);
        g2d.setColor(new Color(0xB55200));
        //g2d.setColor(new Color(0x417909));
        //g2d.setColor(new Color(0xEC3232));

        if (paretN == 1) {
            g2d.fill(rN);
        }
        if (paretE == 1) {
            g2d.fill(rE);
        }
        if (paretS == 1) {
            g2d.fill(rS);
        }
        if (paretO == 1) {
            g2d.fill(rO);
        }
        if (this.ocupada) {
            this.fitxa.paintComponent(g, this.rec.x, this.rec.y);
        }
    }

    public Rectangle2D.Float getRec() {
        return rec;
    }

    public void setFitxa(Fitxa f) {
        this.ocupada = true;
        this.fitxa = f;
    }

    public void borraFitxa() {
        this.ocupada = false;
    }

    public int[] getParets() {
        int[] parets = new int[4];
        parets[0] = this.paretN;
        parets[1] = this.paretE;
        parets[2] = this.paretS;
        parets[3] = this.paretO;
        return parets;
    }

}
