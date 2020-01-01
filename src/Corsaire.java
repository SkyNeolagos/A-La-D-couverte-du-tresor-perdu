
public class Corsaire extends Personnage {
    private Item[] inventaire;
    private int chance;
    private int numeroJoueur;
    private boolean haveChest;
    
    
    // --CONSTRUCTEUR--
    public Corsaire(int id, int type, int portee, int pointDeplacement, Case emplacement, Item[] inventaire, int chance,
			int joueur, boolean haveChest) {
		super(id, type, portee, pointDeplacement, emplacement);
		this.inventaire = inventaire;
		this.chance = chance;
		this.numeroJoueur = joueur;
		this.haveChest = haveChest;
	}
	public Corsaire(){}
    
    // COUCOU MIKA, KDO c'est pour toi
    
    public void addItem(Item item) {
		// Faut ajouter l'item a l'inventaire au bon emplacement.
    	// Genre
    	
    	inventaire[item.getType()] = item;
    	
    	// En faite je crois que c'est carrement ca enfaite
	}
    
    // --DEPLACEMENT--
	public boolean deplacement(Case newPosition) {
		
		// Changement de position
    	this.setEmplacement(newPosition);
    	
    	// Ramasser object
    	if (newPosition.getItem() != null) {
    		boolean possedeObject = false;
    		// Parcours inventaire
			for (int i = 0; i < inventaire.length; i++) { 
				// Si objet dans inventaire = objet trouve
				if (inventaire[i].getType() == newPosition.getItem().getType()) {
					possedeObject = true;
					break;
				}
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
