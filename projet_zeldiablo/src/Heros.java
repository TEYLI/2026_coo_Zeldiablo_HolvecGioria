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
        //Initialisation de la futur position du hero
        int futurX = this.x;
        int futurY = this.y;

        //Direction choisi grace a la commande
        if (commande.gauche) futurX--;
        if (commande.droite) futurX++;
        if (commande.haut) futurY--;
        if (commande.bas) futurY++;

        //vérification que la futur case n'est pas un mur
        if (labyrinthe.estTraversable(futurX, futurY)) {
            boolean caseOccupee = false;
            //Verification que le Hero ne traverse pas un personnage
            for (int i = 0; i < personnages.size(); i++) {
                Personnage p = personnages.get(i);
                if (p != this && p.getX() == futurX && p.getY() == futurY) {
                    caseOccupee = true;
                    break;
                }
            }

            //Deplacement du Hero si la case n'est ni un mur du laby ni un perso
            if (!caseOccupee) {
                this.x = futurX;
                this.y = futurY;
            }
        }
    }
}