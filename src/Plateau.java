import java.util.ArrayList;
import java.util.Random;
import java.util.jar.JarEntry;

public class Plateau {
    private int cote;
    private int nombreCaseEau;
    private int nombreCaseForet;
    private Case[][] tableauCase;
    private int nbJoueur;
    private ArrayList<Corsaire> listeCorsaire;
    private ArrayList<Pirate> listePirate;
    private SystemeDeTour systemeDeTour;

    Plateau(int cote) {
        this.cote=cote;
        int nombreCaseTotal=cote*cote;
        this.nombreCaseEau=((5*nombreCaseTotal)/100);
        this.nombreCaseForet=((5*nombreCaseTotal)/100);
        listeCorsaire=new ArrayList<Corsaire>();
        listePirate=new ArrayList<Pirate>();
        systemeDeTour=new SystemeDeTour();
        tableauCase=generatePlateauWithoutItem();
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
    public void tourJoueur() {
        systemeDeTour.tourJoueur(this);
    }
    public Plateau tourPirate(Plateau plateau) {
        return plateau;
    }
    public Plateau charger(Plateau plateau) {
        return plateau;
    }

    public void initialiser(int nbJoueur) {
        this.nbJoueur=nbJoueur;
        Generator generator = new Generator();
        generator.generatePelleIntoPlateau(nbJoueur,this);
        generator.generateArmureIntoPlateau(nbJoueur,this);
        generator.generateMachetteIntoPlateau(nbJoueur,this);
        generator.generateMousquetIntoPlateau(nbJoueur,this);
        generator.generateJoueurIntoPlateau(nbJoueur,this);
        generator.generateChestIntoPlateau(this);
        generator.generateFlibustierIntoPlateau(nbJoueur,this);
        generator.generateBoucanierIntoPlateau(nbJoueur,this);
    }
    Case [][] generatePlateauWithoutItem(){
        Case [][] plateauWithoutItem=new Case[cote][cote];
        int nombreCaseTotal=cote*cote;
        int nombreCaseEauRestante=nombreCaseEau;
        int nombreCaseForetRestante=nombreCaseForet;
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

    private boolean verificationCase(Case caseAVerifier,Corsaire joueur){
        if(caseAVerifier==null){
            return false;
        }
        else if(caseAVerifier.getPersonnage()!=null && caseAVerifier.getPersonnage() instanceof Pirate){
            return false;
            /*if(joueur.combat(caseAVerifier.getPersonnage())){
                joueur.getEmplacement().setPersonnage(null);
                joueur.deplacement(caseAVerifier);
                listePirate.removeIf(i -> i == caseAVerifier.getPersonnage());
                caseAVerifier.setPersonnage(joueur);
                return true;
                }
            else if(!joueur.combat(caseAVerifier.getPersonnage())){
                joueur.getEmplacement().setPersonnage(null);
                listeCorsaire.removeIf(i -> i == joueur);
                System.out.println("You are mort");
                return false;
            }*/
        }
        else if(caseAVerifier.getPersonnage()!=null && caseAVerifier.getPersonnage() instanceof Corsaire){
            return false;
        }
        else if(caseAVerifier.getPersonnage()==null){
            if(caseAVerifier.getType()==1){
                return false;
            }
            else if(caseAVerifier.getType()==0){
                joueur.getEmplacement().setPersonnage(null);
                joueur.deplacement(caseAVerifier);
                caseAVerifier.setPersonnage(joueur);
                return true;
            }
            else{
                if(caseAVerifier.getType()==2 && joueur.getInventaire()[1]!=null){
                    joueur.getEmplacement().setPersonnage(null);
                    joueur.deplacement(caseAVerifier);
                    caseAVerifier.setPersonnage(joueur);
                    return  true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
    protected boolean verificationDeplacement(String evenement, Corsaire joueur){
        Case tmpCase;
        Recherche recherche=new Recherche();
        switch(evenement){
            case "8":
                tmpCase = recherche.findTop(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "2":
                tmpCase = recherche.findBot(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "4":
                tmpCase = recherche.findLeft(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "6":
                tmpCase = recherche.findRight(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "7":
                tmpCase = recherche.findTopLeft(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "9":
                tmpCase = recherche.findTopRight(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "1":
                tmpCase = recherche.findBotLeft(joueur.getEmplacement(),this);
                return verificationCase(tmpCase,joueur);
            case "3":
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
    public ArrayList<Corsaire> getListeCorsaire() {
        return listeCorsaire;
    }
    public void setListeCorsaire(ArrayList<Corsaire> listeCorsaire) {
        this.listeCorsaire = listeCorsaire;
    }
    public ArrayList<Pirate> getListePirate() {
        return listePirate;
    }
    public void setListePirate(ArrayList<Pirate> listePirate) {
        this.listePirate = listePirate;
    }
	public int getNombreCaseEau() {
		return nombreCaseEau;
	}
	public void setNombreCaseEau(int nombreCaseEau) {
		this.nombreCaseEau = nombreCaseEau;
	}
	public int getNombreCaseForet() {
		return nombreCaseForet;
	}
	public void setNombreCaseForet(int nombreCaseForet) {
		this.nombreCaseForet = nombreCaseForet;
	}
	public int getNbJoueur() {
		return this.nbJoueur;
	}
    
}
