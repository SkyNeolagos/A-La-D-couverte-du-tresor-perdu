public class Plateau {
    private static int COTE;
    private Case[][] tableauCase;
    private Corsaire[] tableauJoueur;
    private Pirate[] tableauPirate;

    public void affichage() {
    }

    public boolean sauvegarde() {
        return false;
    }

    public Plateau tourJoueur(Plateau plateau) {
        return plateau;
    }

    public Plateau tourPirate(Plateau plateau) {
        return plateau;
    }

    public Plateau charger(Plateau plateau) {
        return plateau;
    }

    public Plateau initialiser(Plateau plateau) {
        return plateau;
    }

    private Case findTop(Case positionActuelle){
        int tmpX=positionActuelle.getX()-1;
        int tmpY=positionActuelle.getY();
        if(tmpX<0){
            return null;
        }
        else{

        }
        return null;
    }

    public boolean verificationDeplacement(String evenement,Corsaire joueur){
        return false;
    }
}
