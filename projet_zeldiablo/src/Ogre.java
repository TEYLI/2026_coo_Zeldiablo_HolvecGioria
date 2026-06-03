/**
 * Classe Ogre qui hérite de la classe Monstre
 * Un ogre est un monstre normal avec des collision
 */
public class Ogre extends Monstre {

    //Constructeur

    /**
     * Constructeur a 2 parametres
     * @param x la coordonnée x
     * @param y la y
     */
    public Ogre(int x, int y) {
        super(x, y,2);
    }
}
