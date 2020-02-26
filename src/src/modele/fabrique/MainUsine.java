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
 * Classe de test pour notre fabrique 
 * @author zambrano
 */
public class MainUsine {
    public static void main(String [] args){
        UsinePiece usinePiece = new UsinePiece();
        int x=0; int y=0;
        Piece tour = usinePiece.formerPiece(TypePiece.TOUR, Couleur.NOIR,x ,y);
        Piece pion = usinePiece.formerPiece(TypePiece.PION, Couleur.BLANC,x,y);
        Piece cavalier = usinePiece.formerPiece(TypePiece.CAVALIER, Couleur.NOIR,x,y);
        Piece roi = usinePiece.formerPiece(TypePiece.ROI, Couleur.NOIR,x,y);
        Piece dame = usinePiece.formerPiece(TypePiece.DAME, Couleur.NOIR,x,y);
        Piece fou = usinePiece.formerPiece(TypePiece.FOU, Couleur.BLANC,x,y);
        System.out.println("Création de pièces test");
        System.out.println("##### CREATION PION ####");
        System.out.println(pion);
        pion.modifierX(5);
        pion.modifierY(0);
        System.out.println(pion);
        System.out.println("##### CREATION TOUR ####");
        System.out.println(tour);
        tour.modifierX(0);
        tour.modifierY(0);
        System.out.println(tour);
        System.out.println("##### CREATION  CAVALIER ####");
        System.out.println(cavalier);
        cavalier.modifierX(5);
        cavalier.modifierY(0);
        System.out.println(cavalier);
        System.out.println("##### CREATION ROI ####");
        System.out.println(roi);
        roi.modifierX(0);
        roi.modifierY(4);
        System.out.println(roi);
        System.out.println("##### CREATION DAME ####");
        System.out.println(dame);
        pion.modifierX(5);
        pion.modifierY(0);
        System.out.println(dame);
        System.out.println("##### CREATION FOU ####");
        System.out.println(fou);
        pion.modifierX(5);
        pion.modifierY(0);
        System.out.println(fou);
    }
      
}
