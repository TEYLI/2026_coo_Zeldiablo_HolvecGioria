import moteurJeu.Commande;

import java.util.List;

/**
 * Classe Heros permet de représenter un personage de Zeldiablo
 */
public class Heros extends Personnage {
    //Constructeur
    public Heros(int x, int y) {
        super(x, y);
    }

    //Methodes
    /**
     * Methode deplacer qui permet de deplacer le Hero
     * @param commande commande faite sur clavier
     * @param labyrinthe sur quel labyrinthe ??
     * @param personnages la listes des personnage
     */
    public void deplacer(Commande commande, Labyrinthe labyrinthe , List<Personnage> personnages) {
        int futurX = this.x;
        int futurY = this.y;

        if (commande.gauche) futurX--;
        if (commande.droite) futurX++;
        if (commande.haut) futurY--;
        if (commande.bas) futurY++;

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
}