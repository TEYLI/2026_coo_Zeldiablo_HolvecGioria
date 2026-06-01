public class Case {
    private boolean estMur;

    public Case(boolean estMur) {
        this.estMur = estMur;
    }

    public boolean estTraversable() {
        return !this.estMur;
    }
}