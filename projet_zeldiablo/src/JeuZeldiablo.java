import moteurJeu.Commande;
import moteurJeu.Jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        // 1. Initialisation et ajout du héros au centre
        this.heros = new Heros(10, 10);
        this.personnages.add(this.heros);

        // 2. Ajout des monstres à des positions fixes
        this.personnages.add(new Ogre(2, 2));
        this.personnages.add(new Ogre(10, 5));

        // On place des Fantômes
        this.personnages.add(new Fantome(7, 3));
        this.personnages.add(new Fantome(12, 14));
    }

    //Methodes
    /**
     * Methode evoluer permet de suivre les commande d'utilisateur et actualiser dans le jeu
     * @param c
     *            commande utilisateur
     */
    @Override
    public void evoluer(Commande c) {
        //Heros
        this.heros.deplacer(c, this.labyrinthe,this.personnages);

        //Monstres
        for (int i = 0; i < this.personnages.size(); i++) {
            Personnage p = this.personnages.get(i);
            if (p instanceof Monstre) {
                ((Monstre) p).deplacer(this.labyrinthe,this.personnages);
            }
        }

    }

    /**
     * Methode permet de savoir si la case est vide sans le personnage
     * @param x le x
     * @param y le y
     * @return true si ele est vide
     */
    public boolean estCaseVideDePersonnage(int x, int y) {
        for (int i = 0; i < this.personnages.size(); i++) {
            Personnage p = this.personnages.get(i);
            if (p.getX() == x && p.getY() == y) {
                return false;
            }
        }
        return true;
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