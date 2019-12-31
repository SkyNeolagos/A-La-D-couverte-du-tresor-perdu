import java.util.Random;

public class Generator {
    protected void generatePelleIntoPlateau(int nbJoueur,Plateau plateau){
        int nombrePelleRestante=nbJoueur;
        Random random=new Random();
        while(nombrePelleRestante!=0){
            for (int i = 0; i < plateau.getCote() ; i++) {
                for (int j = 0; j < plateau.getCote(); j++) {
                    int randomNumberItem=random.nextInt(plateau.getCote()*plateau.getCote());
                    if(randomNumberItem >=0 && randomNumberItem<=nbJoueur-1 && nombrePelleRestante !=0 && plateau.getTableauCase()[i][j].getType() !=1){
                        if(plateau.getTableauCase()[i][j].getItem()==null){
                            plateau.getTableauCase()[i][j].setItem(new Pelle());
                            nombrePelleRestante--;
                        }
                    }
                }
            }
        }
    }
    protected void generateMachetteIntoPlateau(int nbJoueur,Plateau plateau){
        int nombreMachetteRestante=2*nbJoueur;
        Random random=new Random();
        while(nombreMachetteRestante !=0){
            for (int i = 0; i < plateau.getCote(); i++) {
                for (int j = 0; j < plateau.getCote(); j++) {
                    int randomNumberItem=random.nextInt(plateau.getCote()*plateau.getCote());
                    if (randomNumberItem >=0 && randomNumberItem<=nbJoueur*2-1 && nombreMachetteRestante !=0 && plateau.getTableauCase()[i][j].getType() !=1 && plateau.getTableauCase()[i][j].getType() != 2){
                        if (plateau.getTableauCase()[i][j].getItem()==null){
                            plateau.getTableauCase()[i][j].setItem(new Machette());
                            nombreMachetteRestante--;
                        }
                    }
                }
            }
        }
    }
    protected void generateMousquetIntoPlateau(int nbJoueur,Plateau plateau){
        int nombreMousquetRestante=2*nbJoueur;
        Random random=new Random();
        while(nombreMousquetRestante !=0){
            for (int i = 0; i < plateau.getCote(); i++) {
                for (int j = 0; j < plateau.getCote(); j++) {
                    int randomNumberItem=random.nextInt(plateau.getCote()*plateau.getCote());
                    if (randomNumberItem >=0 && randomNumberItem<=nbJoueur*2-1 && nombreMousquetRestante !=0 && plateau.getTableauCase()[i][j].getType() !=1){
                        if (plateau.getTableauCase()[i][j].getItem()==null){
                            plateau.getTableauCase()[i][j].setItem(new Mousquet());
                            nombreMousquetRestante--;
                        }
                    }
                }
            }
        }
    }
    protected void generateArmureIntoPlateau(int nbJoueur,Plateau plateau){
        int nombreArmureRestante=2*nbJoueur;
        Random random=new Random();
        while(nombreArmureRestante !=0){
            for (int i = 0; i < plateau.getCote(); i++) {
                for (int j = 0; j < plateau.getCote(); j++) {
                    int randomNumberItem=random.nextInt(plateau.getCote()*plateau.getCote());
                    if (randomNumberItem >=0 && randomNumberItem<=nbJoueur*2-1 && nombreArmureRestante !=0 && plateau.getTableauCase()[i][j].getType() !=1){
                        if (plateau.getTableauCase()[i][j].getItem()==null){
                            plateau.getTableauCase()[i][j].setItem(new Armure());
                            nombreArmureRestante--;
                        }
                    }
                }
            }
        }
    }
    protected void generateJoueurIntoPlateau(int nbJoueur,Plateau plateau){
        int nombreJoueurRestant=nbJoueur;
        Random random=new Random();
        while(nombreJoueurRestant !=0){
            for (int i = 0; i < plateau.getCote(); i++) {
                for (int j = 0; j < plateau.getCote(); j++) {
                    int randomNumberJoueur=random.nextInt(returnNumberCaseNormalWithoutItemOrCorsaire(plateau));
                    if (randomNumberJoueur >=0 && randomNumberJoueur<=nbJoueur-1 && nombreJoueurRestant !=0 && plateau.getTableauCase()[i][j].getType() ==0){
                        if (plateau.getTableauCase()[i][j].getItem()==null){
                            plateau.getTableauCase()[i][j].setPersonnage(new Corsaire());
                            nombreJoueurRestant--;
                        }
                    }
                }
            }
        }
    }
    protected void generateChestIntoPlateau(Plateau plateau){
        int nombreChestRestant=1;
        Random random=new Random();
        while(nombreChestRestant !=0){
            for (int i = 0; i < plateau.getCote(); i++) {
                for (int j = 0; j < plateau.getCote(); j++) {
                    int randomNumberChest=random.nextInt(returnNumberCaseNormalWithoutItemOrCorsaire(plateau));
                    if (randomNumberChest == 1 && nombreChestRestant != 0 && plateau.getTableauCase()[i][j].getType() != 1){
                        if (plateau.getTableauCase()[i][j].getItem()==null && plateau.getTableauCase()[i][j].getPersonnage()==null){
                            plateau.getTableauCase()[i][j].setHaveChest(true);
                            nombreChestRestant--;
                        }
                    }
                }
            }
        }
    }
    protected void generateFlibustierIntoPlateau(int nbJoueur, Plateau plateau){
        int nombreFlibustierRestant=nbJoueur;
        Random random=new Random();
        while(nombreFlibustierRestant!=0){
            for (int i = 0; i < plateau.getCote(); i++) {
                for (int j = 0; j < plateau.getCote(); j++) {
                    int randomNumberPirate=random.nextInt(plateau.getCote()*plateau.getCote());
                    if (randomNumberPirate>=0 && randomNumberPirate<=nbJoueur-1 && nombreFlibustierRestant !=0 && plateau.getTableauCase()[i][j].getType()!=1){
                        if(plateau.getTableauCase()[i][j].getPersonnage()==null){
                            plateau.getTableauCase()[i][j].setPersonnage(new Flibustier());
                            nombreFlibustierRestant--;
                        }
                    }
                }
            }
        }
    }
    protected void generateBoucanierIntoPlateau(int nbJoueur,Plateau plateau){
        int nombreBoucanierRestant=nbJoueur;
        Random random=new Random();
        while(nombreBoucanierRestant!=0){
            for (int i = 0; i < plateau.getCote(); i++) {
                for (int j = 0; j < plateau.getCote(); j++) {
                    int randomNumberPirate=random.nextInt(plateau.getCote()*plateau.getCote());
                    if (randomNumberPirate>=0 && randomNumberPirate<=nbJoueur-1 && nombreBoucanierRestant !=0 && plateau.getTableauCase()[i][j].getType()!=1){
                        if(plateau.getTableauCase()[i][j].getPersonnage()==null){
                            plateau.getTableauCase()[i][j].setPersonnage(new Boucanier());
                            nombreBoucanierRestant--;
                        }
                    }
                }
            }
        }
    }
    private int returnNumberCaseNormalWithoutItemOrCorsaire(Plateau plateau){
        int compteurCaseNormalWithoutItem=0;
        for (int i = 0; i < plateau.getCote(); i++) {
            for (int j = 0; j < plateau.getCote(); j++) {
                if(plateau.getTableauCase()[i][j].getItem()==null && plateau.getTableauCase()[i][j].getType()==0 && plateau.getTableauCase()[i][j].getPersonnage()==null){
                    compteurCaseNormalWithoutItem++;
                }
            }
        }
        return compteurCaseNormalWithoutItem;
    }
}
