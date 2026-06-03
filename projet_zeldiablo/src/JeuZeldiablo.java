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
    private Piece piece;

    //Constructeur

    /**
     * Constructeur par defaut du jeu
     */
    public JeuZeldiablo() {
        //init du laby et perso
        this.labyrinthe = new Labyrinthe();
        this.personnages = new ArrayList<>();

        //Hero au centre
        this.heros = new Heros(10, 10);
        this.personnages.add(this.heros);

        //Monstres a des positions fixes
        this.personnages.add(new Ogre(2, 2));
        this.personnages.add(new Ogre(10, 5));

        // On place des Fantômes
        this.personnages.add(new Fantome(7, 3));
        this.personnages.add(new Fantome(12, 14));

        //Et on fait apparaitre la piece
        this.spawnPiece();
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

        //piece lors de ramassage
        if(this.heros.getX() == this.piece.getX() && this.heros.getY() == this.piece.getY()){
            this.heros.ramasserPiece();
            this.spawnPiece();
        }

        //Monstres
        for (int i = 0; i < this.personnages.size(); i++) {
            Personnage p = this.personnages.get(i);
            //Si le perso est un monstre alors on
            if (p instanceof Monstre) {
                //Definie son type comme Monstre et agis
                ((Monstre) p).agir(this.labyrinthe, this.personnages);
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
        //defaite lors de perte de pv
        if (this.heros.getPointsDeVie() <= 0) {
            System.out.println("GAME OVER - Le héros n'a plus de vie !");
            return true;
        }

        return false;
    }

    /**
     * Methode spawn piece qui permet de faire apparaitre la piece
     * de manière aleatoire sur les case vide
     */
    public void spawnPiece() {
        int x = (int) (Math.random() * this.labyrinthe.getLargeur());
        int y = (int) (Math.random() * this.labyrinthe.getLargeur());
        while (!this.labyrinthe.estTraversable(x, y) || !estCaseVideDePersonnage(x, y)) {
            x = (int)  (Math.random() * this.labyrinthe.getLargeur());
            y = (int)  (Math.random() * this.labyrinthe.getLargeur());
        }
        this.piece = new Piece(x, y);
    }

    //Methodes getter
    public Labyrinthe getLabyrinthe() { return this.labyrinthe; }
    public Heros getHeros() { return this.heros; }
    public List<Personnage> getPersonnages() {
        return this.personnages;
    }
    public Piece getPiece() {
        return this.piece;
    }
}