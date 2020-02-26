/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.controlleur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import src.modele.Couleur;
import src.modele.Joueur;
import src.modele.Modele;
import src.modele.Piece;
import src.modele.Pion;
import src.modele.TypePiece;
import src.modele.fabrique.UsinePiece;

/**
 *
 * @author zambrano
 */
public class Controlleur {

    private Modele modele;
    private int nbTours = 1;

    public Controlleur() {
        this.modele = new Modele();
    }
    
    public int getNbTours(){
        return this.nbTours;
    }
    
    

    /**
     * *
     * Méthode permettant de lancer la partie
     */
    public void commencerPartie() {
       ArrayList<Piece> pieces = modele.getPieces(); //lire liste pièce
        boolean finPartie = false;
         // On compte le nombre de tours
        Joueur j = modele.getJoueur1();

        while (finPartie == false) {
            TypePiece typeP = null; // type de la pièce 
            Couleur couleurP = null; // couleur de la pièce
            int coordX = 0;
            int coordY = 0;
            // Pas de déplacement possible car la pièce est nulle 

            ///fabrique.Fabriquer(typeP, couleurP);
            // il faut comparer le type de la pièce que le joueur sélectionne et le typeP de la boucle
            // il faut aussi comparer la couleurP avec la couleur que le joueur sélectionne
            System.out.println("B = BLANC , N = NOIR");
            System.out.println("nbTour = " + nbTours);

            int xDep = -1;
            int yDep = -1;
            int xAr = -1;
            int yAr = -1;
            boolean nan = true;
            boolean deplacementEstPossible = true;
            boolean pieceEstOk = true;
            String pieceJ = ""; // Piece que le joueur a séléctionné 

            while (xDep < 0 || yDep > 7 || xAr < 0 || yAr > 7 || nan || !deplacementEstPossible || !pieceEstOk) {
                //System.out.println(this.modele.lireAffichage());
                Piece p = null; // Piece que l'on va déplacer 

                // On fait donc appel à UsinePiece pour créer nos pièces
                UsinePiece usinePiece = new UsinePiece();
                Scanner sc = new Scanner(System.in);
                System.out.println("C'est au tour de : " + j.getNom());
                System.out.println("Vous pions sont de couleur  " + j.getCouleur());
                couleurP = j.getCouleur(); // couleur de la pièce
                TypePiece[] typePieces = TypePiece.values();
                for (TypePiece typepiece: typePieces){
                    ///System.out.println(typepiece);
                    typeP = typepiece;
                }

                System.out.println("Entrez les coordonnées de la pièce à déplacer");
                System.out.println("Numéro de ligne de la pièce : ");
                xDep = sc.nextInt();
                System.out.println("Numéro de colonne de la pièce : ");
                yDep = sc.nextInt();
                System.out.println("Entrez les coordonnées d'arrivée où vous placez votre pièce : X ,Y ");
                System.out.println("Numéro de la ligne d'arrivée : ");
                xAr = sc.nextInt();
                System.out.println("Numéro de la colonne d'arrivée : ");
                yAr = sc.nextInt();
                System.out.println("typeP = " + typeP);
                nan = false;
                p = usinePiece.formerPiece(typeP, couleurP, xDep, yDep); // On utilise la fabrique pour former la pièce 
                ///p.seDeplacer(xAr, yAr, modele);
                ///System.out.println("piece = " + p);
                p.seDeplacer(xAr, yAr, modele);
                System.out.println(this.modele.lireAffichage());
                nbTours++;
                }
            
            //On change de joueur
           if (nbTours % 2 != 0) {
                j = this.modele.getJoueur1();
                this.modele.changerJoueur(j.getNom());

            } else {
                j = this.modele.getJoueur2();
                this.modele.changerJoueur(j.getNom());
                ///nbTours++;

            }

        }
              
            }

        
        


    

    public static void main(String[] args) {
        Controlleur c = new Controlleur();
        c.commencerPartie();

    }

}
