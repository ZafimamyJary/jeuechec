/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modele;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import src.modele.*;

/**
 *
 * @author zambrano
 */
public class Modele {

    private Joueur j1;
    private Joueur j2;
    private String joueurCourant;
    private ArrayList<Piece> pieces;
    private Piece[][] plateau = new Piece[8][8]; // plateau qui va contenir les pieces
    private Descripteur descripteur;
    private String nomJ1;
    private String nomJ2;
    private int nbTours = 1;

    public Modele() {
    
        this.pieces = new ArrayList<Piece>();
        this.descripteur = new Descripteur();
       /// this.plateau = new Piece[8][8];
        /// ArrayListw
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        descripteur.lireFichierInit(new File(s + "/src/donnees/init.txt")).clone();
        this.pieces = (ArrayList<Piece>) descripteur.lireFichierInit(new File(s + "/src/donnees/init.txt")).clone(); 
        // NE PAS OUBLIER DE DECOMMENTER this.initialiserPartie().
        this.plateau = this.initialiserTableau();
        this.initialiserPartie();

    }
    
    
    public Piece[][] initialiserTableau(){
      // System.out.println(m.pieces);
      // On place les pièces noires 
      // ON PLACE LES AUTRES PIECES
      this.plateau[0][0] = this.getPieces().get(0);
      this.plateau[0][1] = this.getPieces().get(1);
      this.plateau[0][2] = this.getPieces().get(2);
      this.plateau[0][3] = this.getPieces().get(3);
      this.plateau[0][4] = this.getPieces().get(4);
      this.plateau[0][5] = this.getPieces().get(5);
      this.plateau[0][6] = this.getPieces().get(6);
      this.plateau[0][7] = this.getPieces().get(7);
      // ON PLACE LES PIONS 
      this.plateau[1][0] = this.getPieces().get(8);
      this.plateau[1][1] = this.getPieces().get(9);
      this.plateau[1][2] = this.getPieces().get(10);
      this.plateau[1][3] = this.getPieces().get(11);
      this.plateau[1][4] = this.getPieces().get(12);
      this.plateau[1][5] = this.getPieces().get(13);
      this.plateau[1][6] = this.getPieces().get(14);
      this.plateau[1][7] = this.getPieces().get(15);
      //    ON PLACE LES PIECES BLANCHES 
      // ON PLACE LES PIONS 
      this.plateau[6][0] = this.getPieces().get(16);
      this.plateau[6][1] = this.getPieces().get(17);
      this.plateau[6][2] = this.getPieces().get(18);
      this.plateau[6][3] = this.getPieces().get(19);
      this.plateau[6][4] = this.getPieces().get(20);
      this.plateau[6][5] = this.getPieces().get(21);
      this.plateau[6][6] = this.getPieces().get(22);
      this.plateau[6][7] = this.getPieces().get(23);
      // ON PLACE LES AUTRES PIECES
      this.plateau[7][0] = this.getPieces().get(24);
      this.plateau[7][1] = this.getPieces().get(25);
      this.plateau[7][2] = this.getPieces().get(26);
      this.plateau[7][3] = this.getPieces().get(27);
      this.plateau[7][4] = this.getPieces().get(28);
      this.plateau[7][5] = this.getPieces().get(29);
      this.plateau[7][6] = this.getPieces().get(30);
      this.plateau[7][7] = this.getPieces().get(31);
      /// String strPlateau="";   
      /*for (int i=0;i<this.plateau.length;i++){
          for (int j=0;j<this.plateau[i].length;j++){
          System.out.println(this.plateau[i][j]);
          }
      }*/
      return plateau;
    
    }
    
  

    /**
     * Méthode permettant d'initialiser la partie en demandant aux joueurs leur
     * nom et en affichant le plateau
     */
    public void initialiserPartie() {
       
         this.nomJ1 = "";
         this.nomJ2 = "";

 
     
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nom joueur 1 :");
            this.nomJ1 = sc.nextLine();
            System.out.println("Nom joueur 2 :");
            this.nomJ2 = sc.nextLine();

            if (!(this.nomJ1.matches("^[a-zA-Z]*$")) || nomJ1.isEmpty() || nomJ1 == null) {
                System.out.println("Nom de Joueur 1 incorrect réésaayez");
            } else if (!(this.nomJ2.matches("^[a-zA-Z]*$")) || nomJ2.isEmpty() || nomJ2 == null) {
                System.out.println("Nom de Joueur 2 incorrect réésaayez");

            } else {
                System.out.println("Nom joueur 1 et 2 corrects");
                this.j1 = new Joueur(this.nomJ1, Couleur.BLANC);
                this.j2 = new Joueur(this.nomJ2, Couleur.NOIR);
                System.out.println("N = NOIR , B = BLANC");
                System.out.println(this.j1.getNom() + " a les pièces de couleur " + this.j1.getCouleur() + " et "
                        + this.j2.getNom() + " a les pièces de couleur " + this.j2.getCouleur());
                System.out.println("############ AFFICHAGE PLATEAU #############");

            }
        } while (!(nomJ1.matches("^[a-zA-Z]*$")|| !(nomJ1.isEmpty() || nomJ1 == null)) && !(nomJ1.matches("^[a-zA-Z]*$")) && !(nomJ2.isEmpty() || nomJ2 == null));
        System.out.println(this.lireAffichage());
        ///  System.out.println();

    }

    private String separateur() {
        String res = "  +";
        for (int i = 0; i < 8 ; i++) {
            res += "------+";
        }
        res += "\n";
        return res;
    }

    /**
     *
     * @ Fonction qui permet d'afficher le tableau
     */
    public String lireAffichage() {
        String res = "";
        this.plateau = this.initialiserTableau();

        /// System.out.println(this.pieces.getClass());
        /// res += this.separateur();
        res += "   ";
        for (int i = 0; i < 8 ; i++) {
            res += "  " + i + "    ";
        }
        res += "\n";
        res += this.separateur();

        for (int i = 0; i < this.plateau.length ; i++) {
            res += i + " +";
            for (int j = 0; j < this.plateau[i].length ; j++) {
                boolean bOk = false;
                for (int h = 0; h < this.pieces.size(); h++) {
                    if (i == this.pieces.get(h).lireX() && j == this.pieces.get(h).lireY()) {
                        if (this.pieces.get(h).getCouleur().equals(Couleur.BLANC)) {
                            res += "  B";
                        } else if (this.pieces.get(h).getCouleur().equals(Couleur.NOIR)) {
                            res += "  N";
                        }
                        else {
                             res += "  ";
                        }
                        switch (pieces.get(h).lireType()) {
                            case PION:
                                res += "P  ";
                                bOk = true;
                                break;
                            case TOUR:
                                bOk = true;
                                res += "T  ";
                                break;
                            case CAVALIER:
                                bOk = true;
                                res += "C  ";
                                break;
                            case FOU:
                                bOk = true;
                                res += "F  ";
                                break;
                            case DAME:
                                bOk = true;
                                res += "D  ";
                                break;
                            case ROI:
                                bOk = true;
                                res += "R  ";
                                break;
                            default:
                                break;

                        }
                    }
                }
                if (!bOk) {
                    res += "      ";
                }
                res += "+";
            }
            res += "\n";
            res += this.separateur();
        }
        return res;

    }

    public void prise(int x, int y) {
        for (int i = 0; i < this.pieces.size(); i++) {
            if (this.pieces.get(i).lireX() == x && this.pieces.get(i).lireY() == y) {
                this.j1.ajouterPiece((Piece) this.pieces.get(i).clone());
                this.pieces.remove(i);
            }
        }
    }

    /*public boolean deplacementP(Piece p, int x, int y) {
      ///  p = new Piece();
       
        for (int i = 0; i < this.pieces.size(); i++) {
              if (p.lireType() == this.pieces.get(i).lireType()){
                  return p.seDeplacer(x, y, this);
              }
        }
        return false;
    }*/
    
    public void changerJoueur(String joueurCourant){
       if( this.joueurCourant== this.nomJ1 ){
                this.joueurCourant = this.nomJ1;
    }
        else{
            this.joueurCourant = this.nomJ2;
        }
    }

    public Joueur getJoueur1() {
        return this.j1;
    }

    public Joueur getJoueur2() {
        return this.j2;
    }

    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    public Descripteur getDescripteur() {
        return this.descripteur;
    }

    public void setJoueur1(Joueur j1) {
        this.j1 = j1;

    }

    public void setJoueur2(Joueur j2) {
        this.j2 = j2;

    }

    public void setDescripteur(Descripteur decripteur) {
        this.descripteur = descripteur;
    }
    
     public int getNbTours(){
        return this.nbTours;
    }
     
     public void setNbTours(int nbTours){
         this.nbTours = nbTours++;
     }
    

    public boolean finPartie() {

        boolean finPartie = false;
        //this.pieces.get(longueur)
        // Si la pièce est un Roi et qu'il ne peut plus se déplacer 
        // Alors 
        for (int i = 0; i < this.plateau.length; i++) {
            int x = this.pieces.get(i).lireX();
            int y = this.pieces.get(i).lireY();
            // Dans le cas où la pièce est de couleur noire 
            if (this.pieces.get(i).couleur == Couleur.NOIR) {
                if (this.pieces.get(i).lireType() == TypePiece.ROI && this.pieces.get(i).seDeplacer(x, y,this)) {
                    finPartie = true;
                } else {
                    finPartie = false;
                }
            } // Dans le cas où la pièce est de couleur blanche
            else if (this.pieces.get(i).couleur == Couleur.BLANC) {
                if (this.pieces.get(i).lireType() == TypePiece.ROI && this.pieces.get(i).seDeplacer(x, y,this)) {
                    finPartie = true;
                } else {
                    finPartie = false;
                }
            }
        }
        return finPartie;

    }

    /**
     * Fonction qui déinit quel joueur doit joueur
     */
  

  
    
   public static void main(String [] args){
       Modele m = new Modele();
       System.out.println(m.initialiserTableau());
       
   }

}
