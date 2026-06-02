import moteurJeu.Commande;

/**
 * Classe Monstre permet de représenter un personage de Zeldiablo
 */
public class Monstre implements Personnage {
    //Attributs
    private int x;
    private int y;

    //Constructeur

    /**
     * Constructeur a 2 paramettres permet d'initialiser
     * @param x le x possition
     * @param y y position
     */
    public Monstre(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Methodes

    /**
     * Methode deplacer qui permet de deplacer le Monstre de manière aléatoire (A metre dans l'interface)
     * @param labyrinthe le labyrinthe sur lequel le monstre se déplace
     */
    public void deplacer(Labyrinthe labyrinthe) {
        int futurX = this.x;
        int futurY = this.y;

        int direction = (int) (Math.random()*4);

        switch (direction) {
            case 0:
                futurX--;
                break;
            case 1:
                futurX++;
                break;
            case 2:
                futurY--;
                break;
            case 3:
                futurY++;
                break;
        }


        if (labyrinthe.estTraversable(futurX, futurY)) {
            this.x = futurX;
            this.y = futurY;
        }
    }

    //Methode getter
    public int getX() { return x; }
    public int getY() { return y; }
}