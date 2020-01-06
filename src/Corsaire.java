
public class Corsaire extends Personnage {
    private Item[] inventaire;
    private int chance;
    private int numeroJoueur;
    private boolean haveChest;
    
    
    // --CONSTRUCTEUR--
    public Corsaire(Case emplacement, int numeroJoueur) {
		super(0, 1, 1, emplacement);
		this.inventaire = new Item[4];
		this.chance = 0;
		this.numeroJoueur = numeroJoueur;
		this.haveChest = false;
	}

    public void addItem(Item item) {
    	this.inventaire[item.getType()] = item;
	}

	public boolean deplacement(Case newPosition) {
    	this.setEmplacement(newPosition);
    	
    	// Ramasser object
    	if (newPosition.getItem() != null) {
    		boolean possedeObject = false;
    		if (newPosition.getItem() instanceof Pelle && inventaire[0] != null) {
				possedeObject = true;
			}
    		else if (newPosition.getItem() instanceof Machette && inventaire[1] != null) {
    			possedeObject = true;
			}
    		else if (newPosition.getItem() instanceof Mousquet && inventaire[2] != null) {
    			possedeObject = true;
			}
    		else if (newPosition.getItem() instanceof Armure && inventaire[3] != null) {
    			possedeObject = true;
			}
			// Si il ne possede pas l'objet
			if (possedeObject == false) { 
				// Ajout de l'objet dans l'inventaire
				addItem(newPosition.getItem());
				newPosition.setItem(null);
			}
		}
    	// Creuser si possible
    	if (!newPosition.isDig()) {
    		if (inventaire[0] != null && inventaire[0] instanceof Pelle) {
    			if(newPosition.isDig() && newPosition.isHaveChest()) {
					// VICTOIRE
				}
			}
		}
        return true;
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
