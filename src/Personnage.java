public class Personnage {
    private int id;
    private int type;
    private int portee;
    private int pointDeplacement;
    private Case emplacement;

    public boolean combat() {
        return false;
    }

    public boolean depTop() {
        return false;
    }

    public boolean depBot() {
        return false;
    }

    public boolean depLeft() {
        return false;
    }

    public boolean depRight() {
        return false;
    }

    public boolean depTopLeft() {
        return false;
    }

    public boolean depTopRight() {
        return false;
    }

    public boolean depBotLeft() {
        return false;
    }

    public boolean depBotRight() {
        return false;
    }
}
