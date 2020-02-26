/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.vue;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author zambrano
 */
public class VueJFrame extends JFrame{
    public Vue v;
    VueMenu vueM;
    
    public VueJFrame(){
        v = new Vue();
        vueM = new VueMenu();
        this.setSize(700,700);
        this.setTitle("Jeu d'Echecs");
        this.getContentPane().add(v);
        this.setJMenuBar(vueM.getJMenuBar());

        this.setBackground(Color.WHITE);
        this.setResizable(false);
        ///this.setLocation(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    public static void main(String[] args){
        VueJFrame f = new VueJFrame();
    
    }
    
}
