/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modele;

import java.util.ArrayList;
import java.util.Arrays;
import static src.modele.Couleur.NOIR;
import java.util.Objects;
import src.modele.fabrique.UsinePiece;


/**
 *
 * @author zambrano
 */
public class Pion extends Piece{
    Modele m;
    ///String [][] plateau;
    public Pion(Couleur c, int x, int y) {
        super(c, x, y);
        this.type = TypePiece.PION;
        
    }
    
    public Pion(Couleur c){
        super(c);
    }
    
    public boolean premierDeplacement(int xDep, int xAr, Modele m){
        ArrayList<Piece> p = m.getPieces(); // liste de pièces 
        /// boolean premierDep = false;
        for (int i = 0; i < p.size(); i++) {
            /// CAS BLANC
            if (p.get(i).getCouleur().equals(Couleur.BLANC) && p.get(i).lireType().equals(TypePiece.PION)) {
                // AU DEPART TOUS LES PIONS BLANCS SONT SUR LA LIGNE 6
                ///System.out.println(p.get(i));
                if (this.x == xDep && xDep == 6 && xAr == xDep - 2 || xAr == xDep - 1) {
                    ///  System.out.println("this.x == xDep");
                    //System.out.println("this.x = " + this.x);
                    System.out.println("PREMIER DEPLACEMENT BLANC");
                    return true;
                } else {
                    System.out.println("DEPLACEMENT NON AUTORISÉ POUR PION BLANC");
                    return false;
                }

            } /// CAS NOIR 
            else if (p.get(i).getCouleur().equals(Couleur.NOIR) && p.get(i).lireType().equals(TypePiece.PION)) {
                /// System.out.println(p.get(i));

                // AU DEPART TOUS LES PIONS NOIRS SONT SUR LA LIGNE 1
                if (this.x == xDep && xDep == 1 && xAr == xDep + 2 || xAr == xDep + 1) {
                    System.out.println("PREMIER DEPLACEMENT NOIR");
                    return true;
                } else {
                    System.out.println("DEPLACEMENT NON AUTORISÉ POUR PION NOIR");
                    return false;
                }
            }

        }

        return false;

    }
       
    
    /**
     * Méthode permettant de savoir si une prise est possible 
     * @return 
     */
    @Override
    public boolean priseEstPossible(int xAr, int yAr, Modele m) {
          ArrayList<Piece> p = m.getPieces(); // liste de pièces 
        Piece[][] plateau = m.initialiserTableau(); // Plateau contenant les pièces à déplacer 
        int n = plateau.length; // taille plateau
        //typeP = plateau[xAr][yAr].lireType();
//        couleurP = plateau[xAr][yAr].getCouleur();
//           // On fait donc appel à UsinePiece pour créer nos pièces
//       UsinePiece usinePiece = new UsinePiece();
//       piece = usinePiece.formerPiece(typeP, couleurP, xAr, yAr); // On utilise la fabrique pour former la pièce 
      /// System.out.println(piece);
       ///p.remove(piece);
       /// System.out.println(m.lireAffichage());

       /// System.out.println(p.get(plateau[xAr][yAr]));
        ///System.out.println("####### PLATEAU #######");
        ///System.out.println(plateau);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                for (int indice = 0; indice < p.size(); indice++) {
                    if (plateau[xAr][yAr] != null && plateau[i][j]!=null) {
                        
                        //CAS X !=0
                        if (plateau[i][j].lireType().equals(TypePiece.PION) && plateau[i][j].getCouleur().equals(Couleur.NOIR)) {                           
                            if (plateau[i][j].lireX() == this.x && plateau[i][j].lireY()==this.y){
                           if (this.x + 1 == xAr && this.y + 1 == yAr ) {
                                ///  System.out.println("this.x = " + this.x);
                              ///System.out.println("this.y = " + this.y);
                                this.x = xAr;
                                this.y = yAr;
                                p.remove(p.size() - 1);
                                ///plateau[i][j].modifierX(this.x);
                                ///plateau[i][j].modifierY(this.y);
                                plateau[i][j].modifierX(this.x);
                                plateau[i][j].modifierY(this.y);
                               
                                return true;
                            }
                            
                           else if (this.x+1 == xAr && this.y-1 == yAr){
                               ///System.out.println("this.x = " + this.x);
                              ///System.out.println("this.y = " + this.y);
                              this.x =xAr;
                              this.y=yAr;
                              p.remove(p.size()-1);
                               plateau[i][j].modifierX(this.x);
                                plateau[i][j].modifierY(this.y);
                              return true;
                           }
                            
                            } 
                           
                        
                    } /// FIN CAS NOIR 
                }
                //ON REGARDE SI LA CASE EN DIAGONALE EST NON VIDE 

            }

        }
      
         
    }
         return false;
    }
        /**
     * fonction redéfinissant la méthode seDeplacer
     * car pion peut prendre des pièces en diagonales
     * et donc a besoin du tableau de pièces
     * 
     * @param x
     * @param y
     * @param
     * @return 
     */
    public boolean seDeplacer(int x, int y, Modele m) {
        ArrayList<Piece> p = m.getPieces(); // liste de pièces 
        Piece[][] plateau = m.initialiserTableau(); // Plateau contenant les pièces à déplacer 
        int n = plateau.length; // taille plateau
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                // On place la pièce seulement si la case est vide 
                if (plateau[i][j] != null) {
                    /// CAS PION BLANC 
                    if (plateau[i][j].lireType().equals(TypePiece.PION) && plateau[i][j].getCouleur().equals(Couleur.BLANC)) {
                        /// System.out.println(p.get(0));
                        // On compare les coordonnées de la pièce séléctionnée
                        // avec ses coordonnées sur le plateau              
                        if (plateau[i][j].lireX() == this.x && plateau[i][j].lireY() == this.y) {
                            /// System.out.println(plateau[i][j]);
                            if (this.x - 1 == x && this.y == y) {
                                ///plateau[i][j].lireX() =x;
                                this.x = x;
                                this.y = y;
                                // On modifie les coordonnées de la pièce sur la plateau
                                /// ON MET À JOUR LES COORDONNÉES DANS LA LISTE DE PIECES
                                plateau[i][j].modifierX(this.x);
                                plateau[i][j].modifierY(this.y);
                              //  plateau = ArrayUtils.removeElement(plateau[i][j]);
                                /// System.out.println(m.lireAffichage());
                                return true;
                            } else if (this.x - 2 == x && this.y == y && this.premierDeplacement(this.x, this.x-2, m)== true) {
                                this.x = x;
                                this.y = y;
                                plateau[i][j].modifierX(this.x);
                                plateau[i][j].modifierY(this.y);
                                /// System.out.println(plateau[i][j]);
                                //  System.out.println(m.lireAffichage());
                                return true;
                            } 
                          

                        }

                    } // FIN CAS BLANC 
                    /// DEBUT CAS NOIR 
                    else if (plateau[i][j].lireType().equals(TypePiece.PION) && plateau[i][j].getCouleur().equals(Couleur.NOIR)) {
                        if (plateau[i][j].lireX() == this.x && plateau[i][j].lireY() == this.y) {
                            if (this.x + 2 == x && this.y == y && this.premierDeplacement(this.x, this.x+1, m)== true) {
                                this.x = x;
                                this.y = y;
                                // On modifie les coordonnées de la pièce sur la plateau
                                /// ON MET À JOUR LES COORDONNÉES DANS LA LISTE DE PIECES
                                plateau[i][j].modifierX(this.x);
                                plateau[i][j].modifierY(this.y);
                                ///System.out.println(m.lireAffichage());
                                return true;
                            } else if (this.x + 1 == x && this.y == y) {
                                this.x = x;
                                this.y = y;
                                plateau[i][j].modifierX(this.x);
                                plateau[i][j].modifierY(this.y);
                                return true;
                            }
                            /// CAS PRISE 
                          
                          
                    } // FIN CAS NOIR 
                                  
                }   
            }

        }
        
    }
        return false;
    }
    @Override
    public String toString() {
        return super.toString() + "Pion";

    }

    public static void main(String[] args) {
        Pion pB = new Pion(Couleur.BLANC, 6, 0);
        Pion pB2 = new Pion(Couleur.BLANC, 6, 1);
        Pion pB3 = new Pion(Couleur.BLANC,4,0);
        Pion pN = new Pion(Couleur.NOIR, 1, 0);
        Pion pN2 = new Pion(Couleur.NOIR,1,2);
     
        Modele m = new Modele();
        ArrayList<Piece> pieces = m.getPieces();
        Piece[][] plateau = m.initialiserTableau();
        System.out.println(m.lireAffichage());
        Pion pBaj = new Pion(Couleur.BLANC,2,1);
        plateau[2][1] = pBaj;
       
        ///System.out.println(m.lireAffichage());
          System.out.println(pieces.add(pBaj));
          //System.out.println(pieces);
         /// System.out.println(m.lireAffichage());
         /// System.out.println(pieces.remove(pBaj)); 
          System.out.println(m.lireAffichage());
        ///System.out.println(pN.priseEstPossible(2, 1, m));
         System.out.println(pN2.priseEstPossible(2, 1, m));
                 // System.out.println(pN.priseEstPossible(2, 1, m));

        ///System.out.prinln(pB.priseEstPossible(0, 0, m));

        System.out.println(m.lireAffichage());
        
        ///System.out.println(m.getPieces().get(16));
        // Pb de déplacement avec les pions blancs   
        /// System.out.println(pB.seDeplacer(5, 0, m));
        /// System.out.println(pB2.seDeplacer(5, 1, m));
        ///  System.out.println(m.getPieces());
        //////System.out.println(pB2.lireX());
        ///System.out.println(pB.priseEstPossible(5, 1, m));
        //System.out.println(m.getPieces());
        //m.getPieces().remove(0);
                ///System.out.println(m.getPieces());

        ///System.out.println(pB.seDeplacer(2, 0, m));
        //System.out.println(pB.seDeplacer(5, 0, m));
//       System.out.println("Avant déplacement");
//        System.out.println(m.lireAffichage());
//        
//        ///  System.out.println(m.getPieces());
//        System.out.println(pN.seDeplacer(2, 0, m));
//        System.out.println("après déplacement");
//        ///System.out.println(m.getPieces());
//        System.out.println(m.lireAffichage());
       /// System.out.println(pN.priseEstPossible(3, 1, m));
        //System.out.println(pB.seDeplacer(5, 0, m));
        //System.out.println(pB.seDeplacer(4, 0, m));
        //  System.out.println(pB.seDeplacer(4, 0, m));
        ///System.out.println(pB.seDeplacer(7, 0, m));
        /// System.out.println(pN.seDeplacer(2, 0, m));
        ///System.out.println(pN.seDeplacer(4, 0, m));
        ///System.out.println(pN.seDeplacer(3, 0, m));
    }


 

  
    
    
}
