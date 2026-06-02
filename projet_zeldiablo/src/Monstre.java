import moteurJeu.Commande;

import java.util.List;

/**
 * Classe Monstre permet de représenter un personage de Zeldiablo
 */
public abstract class Monstre extends Personnage {

    //Constructeur
    /**
     * Constructeur a 2 paramettres permet d'initialiser le monstre
     * @param x le x possition
     * @param y y position
     */
    //Methodes
    public Monstre(int x, int y) {
        super(x, y);
    }

    /**
     * Methode deplacer qui permet de deplacer le Monstre de manière aléatoire
     * @param labyrinthe le labyrinthe sur lequel le monstre se déplace
     * @param personnages la liste des persos
     */
    public void deplacer(Labyrinthe labyrinthe, List<Personnage> personnages) {
        int futurX = this.x;
        int futurY = this.y;

        int direction = (int) (Math.random() * 4);

        if(Math.floor(Math.random() * 12) == 1) {
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
        }

        if (labyrinthe.estTraversable(futurX, futurY)) {
            boolean caseOccupee = false;
            for (int i = 0; i < personnages.size(); i++) {
                Personnage p = personnages.get(i);
                if (p != this && p.getX() == futurX && p.getY() == futurY) {
                    caseOccupee = true;
                    break;
                }
            }
            if (!caseOccupee) {
                this.x = futurX;
                this.y = futurY;
            }
        }
    }

    //Methode getter
    public int getX() { return x; }
    public int getY() { return y; }
}