/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modele.fabrique;

import src.modele.Couleur;
import src.modele.Piece;
import src.modele.*;
import src.modele.TypePiece;

/**
 *
 * @author zambrano
 */
public class UsinePiece extends Usine {

    @Override
    public Piece creerPiece(TypePiece type, Couleur couleur,int x , int y ) {
        Piece piece = null;
        switch (type) {
            case PION:
                piece = new Pion(couleur,x,y);
                break;
            case TOUR:
                piece = new Tour(couleur,x,y);
                break;
            case CAVALIER:
                piece = new Cavalier(couleur,x,y);
                break;
            case FOU:
                piece = new Fou(couleur,x,y);
                break;
            case DAME:
                piece = new Dame(couleur,x,y);
                break;
            case ROI:
                piece = new Roi(couleur,x,y);
                break;
      
        }
        return piece;
    }

}
