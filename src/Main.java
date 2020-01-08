import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
        int cote=6;
		System.out.println("Les touches pour les direction sont celles du pavé numérique,2 vers le bas,6 vers la droit, etc ");
		Plateau plateau=new Plateau(cote);
		plateau.initialiser(4);
		plateau.affichage();
		plateau.tourJoueur();
		
	}
	
}
