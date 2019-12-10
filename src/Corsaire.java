public class Corsaire extends Personnage {
    private Item[] inventaire;
    private int chance;
    private int numeroJoueur;
    private boolean haveChest;
    
    

    public Corsaire(int id, int type, int portee, int pointDeplacement, Case emplacement, Item[] inventaire, int chance,
			int joueur, boolean haveChest) {
		super(id, type, portee, pointDeplacement, emplacement);
		this.inventaire = inventaire;
		this.chance = chance;
		this.numeroJoueur = joueur;
		this.haveChest = haveChest;
	}

	public boolean deplacement(Case newPosition) {
		//Changement de position Emplacement
    	this.setEmplacement(newPosition);
    	//Ramasser object
    	
    	//creuser si possible
    	//return true si un des 3
        return false;
    }

    public boolean dig() {
        return false;
    }

    public boolean ramasser() {
        return false;
    }
}
