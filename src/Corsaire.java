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
    	if (newPosition.getItem() != null) {
			for (int i = 0; i < inventaire.length; i++) {
				if (inventaire[i].getType() == newPosition.getItem().getType()) {
					// JE ME SUIS ARRETER LA 
				}
			}
		}
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

	public Item[] getInventaire() {
		return inventaire;
	}

	public void setInventaire(Item[] inventaire) {
		this.inventaire = inventaire;
	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	public int getNumeroJoueur() {
		return numeroJoueur;
	}

	public void setNumeroJoueur(int numeroJoueur) {
		this.numeroJoueur = numeroJoueur;
	}

	public boolean isHaveChest() {
		return haveChest;
	}

	public void setHaveChest(boolean haveChest) {
		this.haveChest = haveChest;
	}
    
    
}
