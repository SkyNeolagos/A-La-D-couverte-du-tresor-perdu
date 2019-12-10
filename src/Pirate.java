public class Pirate extends Personnage {
    public Pirate(int id, int type, int portee, int pointDeplacement, Case emplacement) {
		super(id, type, portee, pointDeplacement, emplacement);
		
	}

	public boolean depAlea() {
        return false;
    }
}
