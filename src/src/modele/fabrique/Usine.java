/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modele.fabrique;

import src.modele.Couleur;
import src.modele.Piece;
import src.modele.TypePiece;

/**
 *
 * @author zambrano
 */
public abstract class Usine {
    public Piece formerPiece(TypePiece type, Couleur couleur,int x,int y){
        Piece piece= this.creerPiece(type,couleur,x ,y);
        piece.toString();               
        return piece;
    }
    public abstract Piece creerPiece(TypePiece type, Couleur couleur,int x ,int y);
}
