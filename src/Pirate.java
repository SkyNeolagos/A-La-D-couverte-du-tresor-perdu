public class Pirate extends Personnage {
    public Pirate(int type, int portee, int pointDeplacement, Case emplacement) {
		super(type, portee, pointDeplacement, emplacement);

	}
	public boolean depAlea() {
        return false;
    }
}
