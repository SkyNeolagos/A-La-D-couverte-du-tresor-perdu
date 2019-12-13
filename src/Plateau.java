import org.jetbrains.annotations.NotNull;

public class Plateau {
    private static int COTE;
    private Case[][] tableauCase;
    private Corsaire[] tableauJoueur;
    private Pirate[] tableauPirate;

    public Plateau(int cote,Case[][] tableauCase) {
        COTE=cote;
        this.tableauCase = tableauCase;
    }

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

    public Case find(int x,int y){
        if((x<0 || y<0) || (x>COTE || y>COTE)){
            return null;
        }
        else{
            for (int i = 0; i < COTE; i++) {
                for (int j = 0; j < COTE ; j++) {
                    Case tmpCase=tableauCase[i][j];
                    if(tmpCase!=null) {
                        if (tmpCase.getX() == x && tmpCase.getY() == y) {
                            return tmpCase;
                        }
                    }
                }
            }
            return null;
        }
    }
    public Case findTop(Case positionActuelle){
        if(positionActuelle!=null){
            int tmpX=positionActuelle.getX()-1;
            int tmpY=positionActuelle.getY();
            if(tmpX<0){
                return null;
            }
            else{
                return find(tmpX,tmpY);
            }
        }
        return null;
    }

    public boolean verificationDeplacement(String evenement,Corsaire joueur){
        return false;
    }
}
