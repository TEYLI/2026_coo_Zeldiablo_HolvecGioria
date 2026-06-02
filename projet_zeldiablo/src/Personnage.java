/**
 * Interface Personnage permet de représenter un personnage
 */
public abstract class Personnage {
    //Attribut
    protected int x;
    protected int y;

    //Constructeur
    public Personnage(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Methodes Getter
    public int getX(){ return x;}
    public int getY(){ return y;}
}
