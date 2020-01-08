import java.util.ArrayList;
import java.util.Scanner;

public class SystemeDeTour {
    public void tourJoueur(Plateau plateau){
        int nbJoueur=plateau.getNbJoueur();
        int i=0;
        while(i<nbJoueur || plateau.getListeCorsaire().isEmpty()){
            System.out.println(i);
            Corsaire verifCorsaire = plateau.getListeCorsaire().get(i);
            Corsaire corsaireTmp =verifCorsaire;
            String choix=choixDirectionDeplacement(corsaireTmp);
            boolean joueurSuivant=plateau.verificationDeplacement(choix,corsaireTmp);
            while(!joueurSuivant){
                if(!plateau.getListeCorsaire().contains(verifCorsaire)){
                    joueurSuivant=true;
                }
                else{
                    choix=choixDirectionDeplacement(corsaireTmp);
                    joueurSuivant=plateau.verificationDeplacement(choix,corsaireTmp);
                }
            }
            if(plateau.getListeCorsaire().contains(verifCorsaire)){
                if(corsaireTmp.isHaveChest()){
                    System.out.println("Victoire du joueur: "+corsaireTmp.getNumeroJoueur());
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
