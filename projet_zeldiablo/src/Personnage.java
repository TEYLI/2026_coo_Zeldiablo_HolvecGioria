/**
 * Classe Personnage permet de représenter un personnage
 */
public abstract class Personnage {

    //Attribut

    protected int x;
    protected int y;

    //Constructeur

    /**
     * Constructeur a 2 parametres
     * @param x le x
     * @param y le y
     */
    public Personnage(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Methodes Getter

    public int getX(){ return x;}
    public int getY(){ return y;}
}
