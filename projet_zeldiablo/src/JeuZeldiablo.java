import moteurJeu.Commande;
import moteurJeu.Jeu;

public class JeuZeldiablo implements Jeu {
    private Labyrinthe labyrinthe;
    private Heros heros;

    public JeuZeldiablo() {
        this.labyrinthe = new Labyrinthe();
        this.heros = new Heros(5, 5);
    }

    @Override
    public void evoluer(Commande c) {
        this.heros.deplacer(c, this.labyrinthe);
    }

    @Override
    public boolean etreFini() {
        return false;
    }

    public Labyrinthe getLabyrinthe() { return this.labyrinthe; }
    public Heros getHeros() { return this.heros; }
}