import java.util.Random;

public class Plateau {
    private static int COTE;
    private Case[][] tableauCase;
    private Corsaire[] tableauJoueur;
    private Pirate[] tableauPirate;

    Plateau(int cote, Case[][] tableauCase) {
        COTE=cote;
        this.tableauCase = tableauCase;
    }

    void affichage() {
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

    public Plateau initialiser(Plateau plateau) { return plateau; }

    Case [][] generatePlateauWithoutItem(int cote){
        Case [][] plateauWithoutItem=new Case[cote][cote];
        int nombreCaseTotal=cote*cote;
        int nombreCaseEauRestante=((nombreCaseTotal*5)/100);
        int nombreCaseForetRestante=((nombreCaseTotal*5)/100);
        int nombreCaseNormalRestante=nombreCaseTotal-(nombreCaseEauRestante+nombreCaseForetRestante);
        Random random=new Random();
        for (int i = 0; i < cote; i++) {
            for (int j = 0; j < cote; j++) {
                if(nombreCaseEauRestante==0 && nombreCaseForetRestante==0){
                    plateauWithoutItem[i][j]=new Case(0,false,null,i,j);
                    nombreCaseNormalRestante--;
                }
                else if(nombreCaseNormalRestante==0){
                    boolean loop=true;
                    while(loop){
                        int randomNumberType=random.nextInt(2);
                        if(randomNumberType==0 && nombreCaseEauRestante != 0){
                            plateauWithoutItem[i][j]=new Case(1,false,null,i,j);
                            nombreCaseEauRestante--;
                            loop=false;
                        }
                        else if(randomNumberType==1 && nombreCaseForetRestante != 0){
                            plateauWithoutItem[i][j]=new Case(2,false,null,i,j);
                            nombreCaseForetRestante--;
                            loop=false;
                        }
                    }

                }
                else if(nombreCaseNormalRestante !=0){
                    boolean loop=true;
                    while(loop){
                        int randomNumberType=random.nextInt(20);
                        if(randomNumberType==1 && nombreCaseEauRestante != 0){
                            plateauWithoutItem[i][j]=new Case(1,false,null,i,j);
                            nombreCaseEauRestante--;
                            loop=false;
                        }
                        else if(randomNumberType==2 && nombreCaseForetRestante !=0){
                            plateauWithoutItem[i][j]=new Case(2,false,null,i,j);
                            nombreCaseForetRestante--;
                            loop=false;
                        }
                        else if(randomNumberType!=1 && randomNumberType !=2) {
                            plateauWithoutItem[i][j] = new Case(0,false,null,i,j);
                            nombreCaseNormalRestante--;
                            loop = false;
                        }
                    }

                }

            }
        }
        return plateauWithoutItem;
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

    public static int getCOTE() {
        return COTE;
    }

    public static void setCOTE(int COTE) {
        Plateau.COTE = COTE;
    }

    public Case[][] getTableauCase() {
        return tableauCase;
    }

    public void setTableauCase(Case[][] tableauCase) {
        this.tableauCase = tableauCase;
    }

    public Corsaire[] getTableauJoueur() {
        return tableauJoueur;
    }

    public void setTableauJoueur(Corsaire[] tableauJoueur) {
        this.tableauJoueur = tableauJoueur;
    }

    public Pirate[] getTableauPirate() {
        return tableauPirate;
    }

    public void setTableauPirate(Pirate[] tableauPirate) {
        this.tableauPirate = tableauPirate;
    }
}
