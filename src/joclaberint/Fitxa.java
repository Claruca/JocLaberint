/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joclaberint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author clara
 */
public class Fitxa {
    
    public static final String FITXA = "fitxa.png";    
    
    private BufferedImage img;

    public Fitxa(String s) {
        try {
            img = ImageIO.read(new File(s));
        } catch (IOException e) {
        }
    }

    void paintComponent(Graphics g, float x, float y) {
        g.drawImage(img,(int) x + 10, (int) y + 10, null);
    }
}
