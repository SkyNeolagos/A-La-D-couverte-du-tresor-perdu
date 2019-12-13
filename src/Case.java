public class Case {
    private int type;
    private boolean isDig;
    private boolean haveChest;
    private Item item;
    private Personnage personnage;
    private int x;
    private int y;
    
    private Outil outil = new Outil();

    public Case(int type,boolean haveChest,Item i,int x, int y) {
    	this.type = type;
    	this.isDig = haveChest;
    	this.haveChest = haveChest;
    	this.item = i;
    	this.personnage = null;
    	this.x = x;
    	this.y = y;
    }
    
    public void affichage() {
    	String motifCase = "$";
    	
    	if(personnage == null) {
	    	if(isDig) {
	    		if(type == 0) {
	    			motifCase = "X";
	    		} else if(type == 2) {
	    			motifCase = "T";
	    		}
	    	} else {
	    		if(type == 2) {
	    			motifCase = "F";
	        	} else if(type == 1) {
	        		motifCase = "E";
	        	} else {
	        		motifCase = "O";
	        	}
	    	}
    	} else {
    		if(personnage instanceof Corsaire) {
    			motifCase = Integer.toString((((Corsaire) personnage).getNumeroJoueur()));
    		}
    		else if (personnage instanceof Boucanier) {
				motifCase = "B";
			}
    		else if (personnage instanceof Flibustier) {
				motifCase = "P";
			}
    	}
    	
    	System.out.print(motifCase);;
    	
    	
    }

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isDig() {
		return isDig;
	}

	public void setDig(boolean isDig) {
		this.isDig = isDig;
	}

	public boolean isHaveChest() {
		return haveChest;
	}

	public void setHaveChest(boolean haveChest) {
		this.haveChest = haveChest;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
    
    
}
