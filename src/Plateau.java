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
        for(int i=0; i<COTE; i++)
        {
            for(int j=0; j<COTE; j++)
            {
                tableauCase[i][j].affichage();
            }
            System.out.println();
        }
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

    private Case find(int x,int y){
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
    private Case findTop(Case positionActuelle){
        if(positionActuelle!=null){
            int tmpX=positionActuelle.getX()-1;
            int tmpY=positionActuelle.getY();
            if(tmpX<0 || tmpX >COTE){
                return null;
            }
            else{
                return find(tmpX,tmpY);
            }
        }
        return null;
    }
    private Case findBot(Case positionActuelle){
        if(positionActuelle!=null){
            int tmpX=positionActuelle.getX()+1;
            int tmpY=positionActuelle.getY();
            if(tmpX<0 || tmpX >COTE){
                return null;
            }
            else{
                return find(tmpX,tmpY);
            }
        }
        return null;
    }
    private Case findRight(Case positionActuelle){
        if(positionActuelle!=null){
            int tmpX=positionActuelle.getX();
            int tmpY=positionActuelle.getY()+1;
            if(tmpY<0 || tmpY >COTE){
                return null;
            }
            else{
                return find(tmpX,tmpY);
            }
        }
        return null;
    }
    private Case findLeft(Case positionActuelle){
        if(positionActuelle!=null){
            int tmpX=positionActuelle.getX();
            int tmpY=positionActuelle.getY()-1;
            if(tmpY<0 || tmpY >COTE){
                return null;
            }
            else{
                return find(tmpX,tmpY);
            }
        }
        return null;
    }
    private Case findTopLeft(Case positionActuelle){
        Case tmpCase=findTop(positionActuelle);
        tmpCase=findLeft(tmpCase);
        return tmpCase;
    }
    private Case findTopRight(Case positionActuelle){
        Case tmpCase=findTop(positionActuelle);
        tmpCase=findRight(tmpCase);
        return tmpCase;
    }
    private Case findBotLeft(Case positionActuelle){
        Case tmpCase=findBot(positionActuelle);
        tmpCase=findLeft(tmpCase);
        return tmpCase;
    }
    private Case findBotRight(Case positionActuelle){
        Case tmpCase=findBot(positionActuelle);
        tmpCase=findRight(tmpCase);
        return tmpCase;
    }

    public boolean verificationDeplacement(String evenement,Corsaire joueur){
        switch(evenement){
            case "top":
                Case tmpCase = findTop(joueur.getEmplacement());
                if(tmpCase==null){
                    return false;
                }
        }
        return false;
    }
}
