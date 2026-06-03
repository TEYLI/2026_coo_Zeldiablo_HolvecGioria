/**
 * Classe Labyrinthe permet de représenter le labyrinthe
 */
public class Labyrinthe {
    //Attributs
    private Case[][] grille;
    private int largeur;
    private int hauteur;

    //Constructeur de laby
    /**
     *  Constructeur par default
     */
    public Labyrinthe() {
        //Selection de la taille du laby
        this.largeur = 15;
        this.hauteur = 15;
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


        //Generation de la partie du millieu
        //Recupération des point d'apparition des Perso
        int departHerosX = 10;
        int departHerosY = 10;
        int departMonstre1X = 2;
        int departMonstre1Y = 2;
        int departMonstre2X = 10;
        int departMonstre2Y = 5;
        //La proba d'apparition d'un mur
        double probabiliteMur = 0.2;

        //Boucle principal qui parcour le labyrinthe de largeur et hauteur imbriqué
        for(int i = 0; i < largeur; i++){
            for(int j = 0; j < hauteur; j++){

                //Empeché de bloqué les Perso
                if(i == 0 || i == largeur - 1 || j == 0 || j == hauteur - 1){
                    grille[i][j] = new Case(true); //mur
                } else if (i == departHerosX && j == departHerosY) {
                    grille[i][j] = new Case(false); //vide
                } else if (i == departMonstre1X && j == departMonstre1Y) {
                    grille[i][j] = new Case(false); //vide
                } else if (i == departMonstre2X && j == departMonstre2Y) {
                    grille[i][j] = new Case(false); //vide
                } else {

                    //génération en dehord des point d'apparition des perso
                    if (Math.random() < probabiliteMur) {
                        grille[i][j] = new Case(true);
                    }  else {
                        grille[i][j] = new Case(false);
                    }

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
