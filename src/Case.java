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
    	String motifCase = "O";
    	
    	if(isDig) {
    		if(type == 0) {
    			System.out.print("X");
    		} else if(type == 2) {
    			System.out.println("T");
    		}
    	} else {
    		if(type == 2) {
        		System.out.println("F");
        	} else if(type == 1) {
        		System.out.println("E");
        	} else {
        		System.out.println("O");
        	}
    	}
    	
    	
    }
    
    
}
