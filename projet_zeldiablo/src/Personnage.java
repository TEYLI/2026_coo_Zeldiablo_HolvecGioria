import moteurJeu.Commande;

public class Personnage {
    private int x;
    private int y;

    public Personnage() {
        this.x = 0;
        this.y = 0;
    }

    public void deplacer(Commande commande) {
        if (commande.gauche) {
            this.x--;
        }
        if (commande.droite) {
            this.x++;
        }
        if (commande.haut) {
            this.y++;
        }
        if (commande.bas) {
            this.y--;
        }
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
