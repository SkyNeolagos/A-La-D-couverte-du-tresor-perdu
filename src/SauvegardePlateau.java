import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class SauvegardePlateau {
	Scanner myScanner = new Scanner(System.in);
    
    public boolean sauvegarderPlateau(Plateau plateau) {
    	System.out.println("Sous quel nom voulez-vous sauvergarder votre partie ?");
    	String nomSauvegarde = myScanner.nextLine();
    	nomSauvegarde = nomSauvegarde+".txt";
    	
    	try {
    		File fichierSauvegarde = new File("sauvegarde/"+nomSauvegarde);
			if (fichierSauvegarde.createNewFile()) {
			    System.out.println("File created: " + fichierSauvegarde.getName());
			} else {
				System.out.println("Fichier déjà existant, voulais vous écraser la sauvegarde ? [Oui/Non]");
				String ecraserResponse = myScanner.nextLine();
				if(!ecraserResponse.equals("Oui")){
					return false;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
    	      FileWriter fichierSauvegarde = new FileWriter("sauvegarde/"+nomSauvegarde);
    	      fichierSauvegarde.write(plateau.getCote());
    	      fichierSauvegarde.write(plateau.getNombreCaseEau());
    	      fichierSauvegarde.write(plateau.getNombreCaseForet());
    	      
    	      // Les cases
    	      for (int i = 0; i < plateau.getCote(); i++) {
    	    	  for (int j = 0; j < plateau.getCote(); j++) {
					Case casePlateau = plateau.getTableauCase()[i][j];
					sauvegarderCase(casePlateau, fichierSauvegarde);
    	    	  }
    	      }
    	      
    	      fichierSauvegarde.write(plateau.getNbJoueur());
    	      
    	      // Les corsaire
    	      for (int i = 0; i < plateau.getNbJoueur(); i++) {
    	    	  ArrayList<Corsaire> listCorsaires = plateau.getListeCorsaire();
    	    	  sauvegarderCorsaire(listCorsaires.get(i), fichierSauvegarde);
    	      }
    	      
    	      // Les pirates
    	      for (int i = 0; i < plateau.getNbJoueur()*2; i++) {
    	    	  ArrayList<Pirate> listPirates = plateau.getListePirate();
    	    	  sauvegarderPirate(listPirates.get(i), fichierSauvegarde);
    	      }
    	      
    	      fichierSauvegarde.close();
    	      
    	      System.out.println("Successfully wrote to the file.");
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    	return false;
	}
    
    public boolean sauvegarderCase(Case casePlateau,FileWriter fichierSauvegarde) {
		return false;
		
	}
    public boolean sauvegarderCorsaire(Corsaire corsaire,FileWriter fichierSauvegarde) {
		return false;
    }
    public boolean sauvegarderPirate(Pirate pirate,FileWriter fichierSauvegarde) {
		return false;
	}
}
