/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modele;

/**
 *
 * @author zambrano
 */
public abstract class Piece implements Deplacement, Cloneable {
    protected Couleur couleur;
    protected TypePiece type;
    protected int x;
    protected int y;
    
    Piece( Couleur c, int x, int y) {
        this.couleur = c;
        this.x = x;
        this.y = y;
        ///this.type = TypePiece.NONE;
    }
    
    Piece(Couleur c){
        this.couleur=c;
    }
    
    @Override
    public boolean equals(Object o) {
        if( !(o instanceof Piece) )
            return false;
        Piece p = (Piece) o;
        if( p.lireX() != this.x)
            return false;
        
        if( p.lireY() != this.y)
            return false;
        
        if( p.getCouleur() != this.couleur ) {
            return false;
        }
        
        if( p.lireType() != this.type )
            return false;
            
        return true;
    }
    
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch(CloneNotSupportedException cnse) {
            cnse.printStackTrace(System.err);
        }
        return o;
    }

    /**
     * Permet de déplacer la pièce 
     * 
     * @param x
     * @param y
     * @param m
     * @return 
     */
    public abstract boolean seDeplacer(int x, int y, Modele m);
    
    public Couleur getCouleur(){
        return this.couleur;
    }
    
    public void setCouleur(Couleur c){
        this.couleur =c;
    }
    
    public TypePiece lireType() {
        return this.type;
    }
    
    public int lireX() {
        return this.x;
    }
    
    public void modifierX(int newX) {
        this.x = newX;
    }
    
    public int lireY() {
        return this.y;
    }
    
    public void modifierY(int newY) {
        this.y = newY;
    }
    
    public String toString() {
        return this.couleur + "[" + this.x + "," + this.y + "] de type ";
    }
}