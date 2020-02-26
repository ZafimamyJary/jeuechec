/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modele;

import java.util.ArrayList;

/**
 *
 * @author zambrano
 */
public class Tour extends Piece {

    public Tour(Couleur c, int x, int y) {
        super(c,x,y);
        this.type = TypePiece.TOUR;
    }
    
    public Tour(Couleur c){
        super(c);
    }
    
    
     @Override
        public String toString(){
        return super.toString() + " Tour";
    
    }

  /**
   * Méthode pour déplacement et prise 
   * @param x
   * @param y
   * @param m
   * @return 
   */
    @Override
    public boolean seDeplacer(int x, int y, Modele m) {
        boolean depPossible = false;
        
        return depPossible;
    }

   

}
