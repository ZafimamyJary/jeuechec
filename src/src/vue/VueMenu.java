/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 *
 * @author zambrano
 */
public class VueMenu extends JFrame {
    private JMenuBar menuPrincipal = new JMenuBar();
    private JMenu menuPartie = new JMenu("Partie");
    private JMenuItem nouvellePartie = new JMenuItem("Nouvelle partie");
    private JMenuItem recommencer = new JMenuItem("Recommencer");
    private JMenuItem charger = new JMenuItem("Charger");
    private JMenuItem quitter = new JMenuItem("Quitter");
    public VueJFrame vueJFrame;
    
    public VueMenu(){
        this.menuPrincipal.add(menuPartie);
        this.menuPartie.add(nouvellePartie);
        nouvellePartie.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
               /// System.out.println("coucou");
               JTextField nomJ1 = new JTextField();
               JFrame Joueur1 = new JFrame("Infos Joueur1");
               Joueur1.setSize(200, 200);
               Joueur1.add(nomJ1);
               Joueur1.setVisible(true);
               ///Joueur1.add()
            }
        });
        quitter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                ///throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        
        });
        
        
        
        this.menuPartie.add(recommencer);
        this.menuPartie.add(charger);
        this.menuPartie.add(quitter);
        this.setJMenuBar(menuPrincipal);
    }
    
    
}
