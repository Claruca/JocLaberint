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
    private Color col;
    private boolean ocupada;
    private int[] bordes;
    private Fitxa fitxa;

//    private Fitxa fitxa;
    public Casella(Rectangle2D.Float rec, Color col) {
        this.rec = rec;
        this.col = col;
        this.ocupada = false;
        this.fitxa = null;
    }

//       public Casella(Rectangle2D.Float rec, Color col, Line2D.Float l) {
//        this.rec = rec;
//        this.col = col;
//        this.ocupada = false;    
//        this.l = l;
//    }
//    
//  
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.col);
        g2d.fill(this.rec);

        //this.fitxa.paintComponent(g, this.rec.x, this.rec.y);

    }

}
