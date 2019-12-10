public class Corsaire extends Personnage {
    private Item[] inventaire;
    private int chance;
    private int joueur;
    private boolean haveChest;

    public boolean deplacer() {
        return false;
    }

    public boolean dig() {
        return false;
    }

    public boolean ramasser() {
        return false;
    }
}
