import java.util.List;

/**
 * Classe Fantome qui hérite de la classe Monstre
 * Un Fantome est un monstre qui traverse les murs.
 */
public class Fantome extends Monstre {
    //Constructeur

    /**
     * Constructeur a 2 parametres
     * @param x le x d'apparition
     * @param y le y d'apparition
     */
    public Fantome(int x, int y) {
        super(x, y);
    }

    /**
     * Methode deplacer qui permet au Fantome de bouger dans les murs
     * @param labyrinthe le labyrinthe sur lequel le monstre se déplace
     * @param personnages la liste des persos
     */
    @Override
    public void deplacer(Labyrinthe labyrinthe, List<Personnage> personnages) {
        //Initialisation de la futur position du fantome
        int futurX = this.x;
        int futurY = this.y;

        //Direction choisi au hasard (4 direction)
        int direction = (int) (Math.random() * 4);

        //diminution du nombre de deplacement 1 chance sur 6 toute les evolution du jeu
        if (Math.floor(Math.random() * 6) == 1) {
            //Deplacement
            switch (direction) {
                case 0: futurX--; break;
                case 1: futurX++; break;
                case 2: futurY--; break;
                case 3: futurY++; break;
            }
        }
        //verification que le Fantome ne depasse pas le terrain
        if (futurX >= 0 && futurX < labyrinthe.getLargeur() && futurY >= 0 && futurY < labyrinthe.getHauteur()) {
            boolean caseOccupee = false;

            //Verification que le Fantome ne traverse pas un personnage
            for (int i = 0; i < personnages.size(); i++) {
                Personnage p = personnages.get(i);
                if (p != this && p.getX() == futurX && p.getY() == futurY) {
                    caseOccupee = true;
                    break;
                }
            }

            //Deplacement du fantome si la case n'est ni le bord du laby ni un perso
            if (!caseOccupee) {
                this.x = futurX;
                this.y = futurY;
            }
        }
    }
}