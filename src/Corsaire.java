
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
    
    // --DEPLACEMENT--
	public boolean deplacement(Case newPosition) {
		
		// Changement de position
    	this.setEmplacement(newPosition);
    	
    	// Ramasser object
    	if (newPosition.getItem() != null) {
    		boolean possedeObject = false;
    		// Parcours inventaire
			for (int i = 0; i < inventaire.length; i++) { 
				// Si objet dans inventaire = � objet trouv�e
				if (inventaire[i].getType() == newPosition.getItem().getType()) {
					possedeObject = true;
					break;
				}
			}
			// Si il ne possede pas l'objet
			if (possedeObject == false) { 
				// Ajout de l'objet dans l'inventaire
				inventaire[inventaire.length+1] = newPosition.getItem(); 
			}
		}
    	// Creuser si possible
    	if (!newPosition.isDig()) {
    		for (int y = 0; y < inventaire.length; y++) {
    			//Si il as une pelle
				if (inventaire[y].getType() == 1 ) { 
					dig();// la boucle a mettre dans la fonction dig() si on fais passer un argument a cette derniere
					if(newPosition.isDig() && newPosition.isHaveChest()) {
						// VICTOIRE
					}
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
