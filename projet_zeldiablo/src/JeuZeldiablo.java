import moteurJeu.Commande;
import moteurJeu.Jeu;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe JeuZeldiablo permet de cconstruire le jeu
 */
public class JeuZeldiablo implements Jeu {
    //Attributs
    private Labyrinthe labyrinthe;
    private Heros heros;
    private List<Personnage> personnages;

    //Constructeur

    /**
     * Constructeur par defaut du jeu
     */
    public JeuZeldiablo() {
        this.labyrinthe = new Labyrinthe();
        this.personnages = new ArrayList<>();

        // 1. Initialisation et ajout du héros
        this.heros = new Heros(5, 5);
        this.personnages.add(this.heros);

        this.spawnMonstre(2, 2);
        this.spawnMonstre(7, 3);
    }

    //Methodes
    public void spawnMonstre(int x, int y) {
        // Validation : on vérifie que la case existe et n'est pas un mur
        if (this.labyrinthe.estTraversable(x, y)) {
            Monstre monstre = new Monstre(x, y);
            this.personnages.add(monstre);
        }
    }

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
    public List<Personnage> getPersonnages() {
        return this.personnages;
    }
}