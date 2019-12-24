import java.util.Random;

public class Plateau {
    private int cote;
    private Case[][] tableauCase;
    private Corsaire[] tableauJoueur;
    private Pirate[] tableauPirate;

    Plateau(int cote) {
        this.cote=cote;
    }

    void affichage() {
        for(int i=0; i<cote; i++)
        {
            for(int j=0; j<cote; j++)
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

    Case [][] generatePlateauWithoutItem(){
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
    public void generateItemIntoPlateau(int nbJoueur){
        int nombreItemPelleRestante=nbJoueur;
        int nombreItemMachetteRestante=2*nbJoueur;
        int nombreItemMousquetRestante=2*nbJoueur;
        int nombreItemArmureRestante=2*nbJoueur;
        Random random=new Random();
        int nombreItemTotal=nombreItemArmureRestante+nombreItemMachetteRestante+nombreItemMousquetRestante+nombreItemPelleRestante;
        while(nombreItemTotal !=0){
            for (int i = 0; i < cote ; i++) {
                for (int j = 0; j < cote; j++) {
                    int randomNumberItem=random.nextInt(10);
                    if(randomNumberItem==0 && nombreItemPelleRestante !=0 && tableauCase[i][j].getType() !=1){
                        if(tableauCase[i][j].getItem()==null){
                            tableauCase[i][j].setItem(new Pelle());
                            nombreItemPelleRestante--;
                            nombreItemTotal--;
                        }
                    }
                    else if(randomNumberItem==1 && nombreItemMachetteRestante !=0 && tableauCase[i][j].getType() !=1 && tableauCase[i][j].getType() !=2){
                        if(tableauCase[i][j].getItem()==null){
                            tableauCase[i][j].setItem(new Machette());
                            nombreItemMachetteRestante--;
                            nombreItemTotal--;
                        }
                    }
                    else if(randomNumberItem==2 && nombreItemMousquetRestante !=0 && tableauCase[i][j].getType()!=1){
                        if (tableauCase[i][j].getItem()==null){
                            tableauCase[i][j].setItem(new Mousquet());
                            nombreItemMousquetRestante--;
                            nombreItemTotal--;
                        }
                    }
                    else if(randomNumberItem==3 && nombreItemArmureRestante !=0 && tableauCase[i][j].getType()!=1){
                        if (tableauCase[i][j].getItem()==null){
                            tableauCase[i][j].setItem(new Armure());
                            nombreItemArmureRestante--;
                            nombreItemTotal--;
                        }
                    }
                }
            }
        }
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
        Recherche recherche=new Recherche();
        switch(evenement){
            case "top":
                tmpCase = recherche.findTop(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "bot":
                tmpCase = recherche.findBot(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "left":
                tmpCase = recherche.findLeft(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "right":
                tmpCase = recherche.findRight(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "topLeft":
                tmpCase = recherche.findTopLeft(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "topRight":
                tmpCase = recherche.findTopRight(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "botLeft":
                tmpCase = recherche.findBotLeft(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "botRight":
                tmpCase = recherche.findBotRight(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            default:
                return false;
        }
    }

    public int getCote() {
        return cote;
    }
    public  void setCote(int cote) {
        this.cote = cote;
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
