import moteurJeu.Commande;
import moteurJeu.Jeu;

/**
 * Classe JeuZeldiablo permet de cconstruire le jeu
 */
public class JeuZeldiablo implements Jeu {
    //Attributs
    private Labyrinthe labyrinthe;
    private Heros heros;

    //Constructeur

    /**
     * Constructeur par defaut du jeu
     */
    public JeuZeldiablo() {
        this.labyrinthe = new Labyrinthe();
        this.heros = new Heros(5, 5);

    }

    //Methodes

    /**
     * Methode evoluer permet de suivre les commande d'utilisateur et actualiser dans le jeu
     * @param c
     *            commande utilisateur
     */
    @Override
    public void evoluer(Commande c) {
        this.heros.deplacer(c, this.labyrinthe);
    }

    /**
     * Methode etre fini : es ce que le jeu est fini ?
     * @return
     */
    @Override
    public boolean etreFini() {
        return false;
    }

    //Methodes getter
    public Labyrinthe getLabyrinthe() { return this.labyrinthe; }
    public Heros getHeros() { return this.heros; }
}