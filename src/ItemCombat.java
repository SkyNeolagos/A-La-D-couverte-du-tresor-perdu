public class ItemCombat extends Item {
	private int statisque;
	
    public ItemCombat(int type, String nom,int statistique) {
		super(type, nom);
		this.statisque = statistique;
	}

	public int getStatisque() {
		return statisque;
	}

	protected void setStatisque(int statisque) {
		this.statisque = statisque;
	}
    
    
}
