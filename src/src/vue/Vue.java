/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.vue;

import java.awt.Color;
import static java.awt.Color.LIGHT_GRAY;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author zambrano
 */
public class Vue extends JPanel {
   public JFrame VueJFrame;
    
    
    public void paint(Graphics g){
        VueJFrame = new JFrame();
        ///int tileSize = 8 / this.getSize();
        int tileSize = 700 /8;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, VueJFrame.getWidth(), VueJFrame.getHeight());
        g.setColor(Color.RED);
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (i%2 == j%2){
                    g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
                }
            }
        }
    }
    
     
 
    
     
    
     
 
    
    
    public static void main(String [] args){
        
    }

   
}
