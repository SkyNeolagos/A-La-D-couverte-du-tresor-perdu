import java.util.Random;

public abstract class Personnage {
    private int type;
    private int portee;
    private int pointDeplacement;
    private Case emplacement;


    public Personnage(int type, int portee, int pointDeplacement, Case emplacement) {
		this.type = type;
		this.portee = portee;
		this.pointDeplacement = pointDeplacement;
		this.emplacement = emplacement;
	}
	public Personnage(Case emplacement){
    	this.emplacement=emplacement;
	};


	public boolean combat(Personnage ennemi) {
		if(this instanceof Corsaire){
			int chance=((Corsaire) this).getChance();
			Random random = new Random();
			int resultatCombat=random.nextInt(100);
			if(resultatCombat >=0 && resultatCombat < chance-1) {
				return true;
			}
		}
		else if(this instanceof Pirate){
			int chance=((Corsaire) ennemi).getChance();
			Random random = new Random();
			int resultatCombat=random.nextInt(100);
			if(resultatCombat >=0 && resultatCombat < chance-1) {
				return true;
			}
		}
		return false;
	}

    public boolean deplacement(Case newPosition) {
    	this.emplacement = newPosition;
    	return true;
    }



	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public int getPortee() {
		return portee;
	}


	public void setPortee(int portee) {
		this.portee = portee;
	}


	public int getPointDeplacement() {
		return pointDeplacement;
	}


	public void setPointDeplacement(int pointDeplacement) {
		this.pointDeplacement = pointDeplacement;
	}


	public Case getEmplacement() {
		return emplacement;
	}


	public void setEmplacement(Case emplacement) {
		this.emplacement = emplacement;
	}
    
    
}
