import java.util.ArrayList;
import java.util.Scanner;

public class SystemeDeTour {
    public void tourJoueur(Plateau plateau){
        for (Corsaire i: plateau.getListeCorsaire()) {
            String choix=choixDirectionDeplacement(i);
            boolean joueurSuivant=plateau.verificationDeplacement(choix,i);
            while(!joueurSuivant){
                if(!plateau.getListeCorsaire().contains(i)){
                    joueurSuivant=true;
                }
                else{
                    choix=choixDirectionDeplacement(i);
                    joueurSuivant=plateau.verificationDeplacement(choix,i);
                }
            }
            if(plateau.getListeCorsaire().contains(i)){
                if(i.isHaveChest()){
                    System.out.println("Victoire du joueur: "+i.getNumeroJoueur());
                }
            }
            plateau.affichage();
        }
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
