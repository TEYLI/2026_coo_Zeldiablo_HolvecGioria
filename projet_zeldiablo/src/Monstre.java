import moteurJeu.Commande;

import java.util.List;

/**
 * Classe Monstre permet de représenter un personage de Zeldiablo
 */
public abstract class Monstre extends Personnage {
    //Attributs
    protected int degats;
    protected long tempsDerniereAttaque;
    //Constructeur

    /**
     * Constructeur a 2 paramettres permet d'initialiser le monstre
     *
     * @param x le x possition
     * @param y y position
     */

    public Monstre(int x, int y, int degats) {
        super(x, y);
        this.degats = degats;
        this.tempsDerniereAttaque = 0;
    }

    //Methodes

    public void agir(Labyrinthe labyrinthe, List<Personnage> personnages) {
        Heros heros = null;

        //Trouver Hero
        for (int i = 0; i < personnages.size(); i++) {
            Personnage p = personnages.get(i);
            if (p instanceof Heros) {
                heros = (Heros) p;
                break;
            }
        }

        // 2. Vérifier la distance et le temps
        if (heros != null) {
            int distanceX = Math.abs(this.x - heros.getX());
            int distanceY = Math.abs(this.y - heros.getY());

            // S'ils sont côte à côte
            if (distanceX + distanceY == 1) {

                // On récupère le temps
                long tempsActuel = System.currentTimeMillis();

                if (tempsActuel - this.tempsDerniereAttaque >= 5000) {
                    heros.subirDegats(this.degats);
                    this.tempsDerniereAttaque = tempsActuel;
                }
            }

        }
        this.deplacer(labyrinthe, personnages);
    }


    /**
     * Methode deplacer qui permet de deplacer le Monstre de manière aléatoire
     *
     * @param labyrinthe  le labyrinthe sur lequel le monstre se déplace
     * @param personnages la liste des persos
     */
    public void deplacer(Labyrinthe labyrinthe, List<Personnage> personnages) {
        //Initialisation de la futur position du Monstre
        int futurX = this.x;
        int futurY = this.y;

        //Direction choisi au hasard (4 direction)
        int direction = (int) (Math.random() * 4);

        //diminution du nombre de deplacement 1 chance sur 6 toute les evolution du jeu
        if (Math.floor(Math.random() * 2) == 1) {
            //Deplacement
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

        //Verification que le Monstre ne traverse pas un personnage
        if (futurX >= 0 && futurX < labyrinthe.getLargeur() && futurY >= 0 && futurY < labyrinthe.getHauteur()) {
            boolean caseOccupee = false;

            for (int i = 0; i < personnages.size(); i++) {
                Personnage p = personnages.get(i);
                if (p != this && p.getX() == futurX && p.getY() == futurY) {
                    caseOccupee = true;
                    break;
                }
            }
            if (!caseOccupee && labyrinthe.estTraversable(futurX, futurY)) {
                this.x = futurX;
                this.y = futurY;
            }
        }
    }
}