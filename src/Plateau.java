
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
    private boolean verificationCase(Case caseAVerifier,Corsaire joueur){
        if(caseAVerifier==null){
            return false;
        }
        else{
            if(caseAVerifier.getType()==1){
                return false;
            }
            else if(caseAVerifier.getType()==0){
                joueur.deplacement(caseAVerifier);
                return true;
            }
            else{
                if(caseAVerifier.getType()==2 && joueur.getInventaire()[1]!=null){
                    joueur.deplacement(caseAVerifier);
                    return  true;
                }
                else{
                    return false;
                }
            }
        }
    }
    private boolean verificationDeplacement(String evenement, Corsaire joueur){
        Case tmpCase;
        switch(evenement){
            case "top":
                tmpCase = findTop(joueur.getEmplacement());
                return verificationCase(tmpCase,joueur);
            case "bot":
                tmpCase = findBot(joueur.getEmplacement());
                return verificationCase(tmpCase,joueur);
            case "left":
                tmpCase = findLeft(joueur.getEmplacement());
                return verificationCase(tmpCase,joueur);
            case "right":
                tmpCase = findRight(joueur.getEmplacement());
                return verificationCase(tmpCase,joueur);
            case "topLeft":
                tmpCase = findTopLeft(joueur.getEmplacement());
                return verificationCase(tmpCase,joueur);
            case "topRight":
                tmpCase = findTopRight(joueur.getEmplacement());
                return verificationCase(tmpCase,joueur);
            case "botLeft":
                tmpCase = findBotLeft(joueur.getEmplacement());
                return verificationCase(tmpCase,joueur);
            case "botRight":
                tmpCase = findBotRight(joueur.getEmplacement());
                return verificationCase(tmpCase,joueur);
            default:
                return false;
        }
    }
}
