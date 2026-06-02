import moteurJeu.Commande;

/**
 * Classe Heros permet de représenter un personage de Zeldiablo
 */
public class Heros implements Personnage {
    //Attributs
    private int x;
    private int y;

    //Constructeur

    /**
     * Constructeur a 2 paramettres permet d'initialiser
     * @param x le x possition
     * @param y y position
     */
    public Heros(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Methodes

    /**
     * Methode deplacer qui permet de deplacer le Hero (A metre dans l'interface)
     * @param commande commande faite sur clavier
     * @param labyrinthe sur quel labyrinthe ??
     */
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

    //Methode getter
    public int getX() { return x; }
    public int getY() { return y; }
}