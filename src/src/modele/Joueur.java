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
public class Joueur {
    private int nbDeplacements;
    private String nom;
    private int points;
    private Couleur couleur;
    private ArrayList<Piece> piecePrises = new ArrayList<Piece>();
    
    public Joueur(String nom, Couleur couleur){
        this.nom = nom;
        this.couleur =couleur;
    
    }
    
 
    
    
    /**
     * Fonction qui permet le déplacement des pièces joueur
     */
    public void Deplacement(){
    
    }

    /**
     * @return the nbDeplacements
     */
    public int getNbDeplacements() {
        return nbDeplacements;
    }
    
    public void ajouterPiece( Piece p ) {
        this.piecePrises.add(p);
    }

    /**
     * @param nbDeplacements the nbDeplacements to set
     */
    public void setNbDeplacements(int nbDeplacements) {
        this.nbDeplacements = nbDeplacements;
    }
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return the couleur
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * @return the piecePrises
     */
    public ArrayList<Piece> getPiecePrises() {
        return piecePrises;
    }

    /**
     * @param piecePrises the piecePrises to set
     */
    public void setPiecePrises(ArrayList<Piece> piecePrises) {
        this.piecePrises = piecePrises;
    }
    
}
