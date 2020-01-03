import java.util.ArrayList;
import java.util.Scanner;

public class SystemeDeTour {
    public void tourJoueur(Plateau plateau){
        ArrayList<Corsaire> listeTmpJoueur;
        listeTmpJoueur=plateau.getListeCorsaire();
        for (Corsaire i: listeTmpJoueur) {
            boolean joueurSuivant=true;
            String choix=choixDirectionDeplacement(i);
            joueurSuivant=plateau.verificationDeplacement(choix,i);
            while(!joueurSuivant){
                choix=choixDirectionDeplacement(i);
                joueurSuivant=plateau.verificationDeplacement(choix,i);
            }
        }
        plateau.affichage();
    }
    private String choixDirectionDeplacement(Corsaire joueur){
        Scanner scan=new Scanner(System.in);
        System.out.println("Joueur "+joueur.getNumeroJoueur());
        System.out.println("Veuillez entrer le chiffre correspondant a votre choix de direction:");
        String scanString=scan.nextLine();
        System.out.println("Votre choix est : "+ scanString);
        return scanString;
    }
}
