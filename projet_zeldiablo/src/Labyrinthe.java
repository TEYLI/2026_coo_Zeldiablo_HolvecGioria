/**
 * Classe Labyrinthe permet de représenter le labyrinthe
 */
public class Labyrinthe {
    //Attributs
    private Case[][] grille;
    private int largeur;
    private int hauteur;

    //Constructeur

    /**
     *  Constructeur par default
     */
    public Labyrinthe() {
        this.largeur = 20;
        this.hauteur = 20;
        this.grille = new Case[largeur][hauteur];

        // Initialisation de l'arène
        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < hauteur; j++) {
                // Si on est sur le bord de la grille, on met un mur
                if (i == 0 || i == largeur - 1 || j == 0 || j == hauteur - 1) {
                    grille[i][j] = new Case(true);
                } else {
                    grille[i][j] = new Case(false);
                }
            }
        }
    }

    /**
     * Methode estTraversable qui permet de savoir si une case a une coordonnee est traversable
     * @param x coordonee x
     * @param y coordonnee y
     * @return true si traversable
     */
    public boolean estTraversable(int x, int y) {
        if (x < 0 || x >= largeur || y < 0 || y >= hauteur) {
            return false;
        }
        return grille[x][y].estTraversable();
    }

    //methodes getter
    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }
}
