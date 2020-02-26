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
public class Cavalier extends Piece {

    public Cavalier(Couleur c, int x, int y) {
        super(c,x,y);
        this.type = TypePiece.CAVALIER;
    }
    
    public Cavalier(Couleur c){
           super(c);
    }
    
    public String toString(){
        return super.toString() + "Cavalier";
    
    }

    @Override
    public boolean seDeplacer(int x, int y, Modele m) {
        boolean depPossible =false;
       /// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return depPossible;
    }

   

  
    
    
}
