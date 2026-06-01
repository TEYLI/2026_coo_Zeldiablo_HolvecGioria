import moteurJeu.Commande;

public class Heros {
    private int x;
    private int y;

    public Heros(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void deplacer(Commande commande, Labyrinthe labyrinthe) {
        int futurX = this.x;
        int futurY = this.y;

        if (commande.gauche) futurX--;
        if (commande.droite) futurX++;
        if (commande.haut)   futurY--;
        if (commande.bas)    futurY++;

        if (labyrinthe.estTraversable(futurX, futurY)) {
            this.x = futurX;
            this.y = futurY;
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
}