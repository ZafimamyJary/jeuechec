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
public class Roi extends Piece {

    public Roi(Couleur c, int x, int y) {
        super(c,x,y);
        this.type = TypePiece.ROI;
    }
    
    public Roi(Couleur c){
           super(c);
    }

    
    public String toString(){
        return super.toString() + "Roi";
    
    }

    @Override
    public boolean seDeplacer(int x, int y, Modele m) {
         boolean depPossible = false;
        
        return depPossible;
    }

    

    
    
}
