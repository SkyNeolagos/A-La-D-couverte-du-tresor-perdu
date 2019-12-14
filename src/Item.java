public class Item {
    private int type;
    private String nomItem;
    
    public Item(int type, String nom) {
		this.type = type;
		this.nomItem = nom;
	}
 
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getNomItem() {
		return nomItem;
	}
	protected void setNomItem(String nomIteme) {
		this.nomItem = nomIteme;
	} 
	
	
}
