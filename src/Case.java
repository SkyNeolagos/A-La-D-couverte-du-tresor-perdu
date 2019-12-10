public class Case {
    private int type;
    private boolean isDig;
    private boolean haveChest;
    private Item item;
    private Personnage personnage;
    private int x;
    private int y;

    public void affichage() {
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
