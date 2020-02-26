/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.modele;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author zambrano
 */
public class Descripteur {
 
    /*
   
    */
    public Descripteur() {
    }
    
    public ArrayList<Piece> lireFichierInit(File fichier) {
        ArrayList<Piece> resultat = new ArrayList<Piece>();
        try {
        Scanner sc = new Scanner(fichier);
        
        while( sc.hasNextLine() ) {
            String[] elements = sc.nextLine().split(" ");
        

            Piece p;
            Couleur c;
            if (elements[0].equals("B")){
                c = Couleur.BLANC;
            }
            else {
                c= Couleur.NOIR;
            }
         
           switch( elements[1] ) {
                case "P":
                    resultat.add( new Pion( c, parseInt(elements[2]), parseInt(elements[3])));
                    break;
                case "C":
                    resultat.add( new Cavalier( c, parseInt(elements[2]), parseInt(elements[3])));
                    break;
                case "F":
                   resultat.add( new Fou( c, parseInt(elements[2]), parseInt(elements[3])));
                    break;
                case "T":
                    resultat.add( new Tour( c, parseInt(elements[2]), parseInt(elements[3])));
                    break;
                case "R":
                    resultat.add( new Roi( c, parseInt(elements[2]), parseInt(elements[3])));
                    break;
                case "D":
                    resultat.add( new Dame( c, parseInt(elements[2]), parseInt(elements[3])));
                    break;
                    
             
               
            }
                       ///System.out.println(Arrays.toString(elements));
                        ///System.out.println(elements[0]);
        }
        
        } catch(IOException ex) {
            System.out.println("Fichier non trouvé");
            ex.printStackTrace();

        }
        return resultat;
    }
    
     public static void main(String [] args) {
         
     
     }
        
}