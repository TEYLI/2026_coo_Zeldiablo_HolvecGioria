/**
 * Classe Case qui represente une case et sont "Etat"
 */
public class Case {
    //Attributs
    private boolean estMur;

    //Constructeur
    /**
     * Constructeur a un parametre qui initialise une case, true en pparam si il est mur
     * @param estMur true si mur
     */
    public Case(boolean estMur) {
        this.estMur = estMur;
    }

    //Methodes
    /**
     * Methode est traversable permet d'acceder a son état
     * @return le status d'une case
     */
    public boolean estTraversable() {
        return !this.estMur;
    }
}