/**
 * Classe représentant une pièce ramassable dans le labyrinthe
 */
public class Piece {
    //Attributs

    private int x;
    private int y;

    //Constructeur

    /**
     * Constructeur a 2 param pour faire la piece
     * @param x coordonée x
     * @param y coordonné y
     */
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Getteur
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
