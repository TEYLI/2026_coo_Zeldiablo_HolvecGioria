import moteurJeu.DessinJeu;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe DessinZeldiablo permet de représenter le jeu en général
 */
public class DessinZeldiablo implements DessinJeu {
    //Attribut
    private JeuZeldiablo jeu;
    private static final int TAILLE_CASE = 40;

    //Constructeur

    /**
     * Constructeur a un parametre
     *
     * @param jeu
     */
    public DessinZeldiablo(JeuZeldiablo jeu) {
        this.jeu = jeu;
    }

    //Methodes

    /**
     * Methode dessiner permet d'initialiser le dessin voulu
     *
     * @param image image sur laquelle dessiner
     */
    @Override
    public void dessiner(BufferedImage image) {
        //initialisation de l'image
        Graphics g = image.getGraphics();

        Labyrinthe laby = jeu.getLabyrinthe();

        for (int i = 0; i < laby.getLargeur(); i++) {
            for (int j = 0; j < laby.getHauteur(); j++) {
                if (!laby.estTraversable(i, j)) {
                    g.setColor(Color.DARK_GRAY); // Mur
                } else {
                    g.setColor(Color.WHITE); // Sol vide
                }
                g.fillRect(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);

                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
            }
        }

        //Heros
        for (Personnage p : jeu.getPersonnages()) {
            int pixelX = p.getX() * TAILLE_CASE;
            int pixelY = p.getY() * TAILLE_CASE;
            if (p instanceof Heros) {
                g.setColor(Color.BLUE);
            } else if (p instanceof Monstre) {
                g.setColor(Color.RED);
            }
            g.fillOval(pixelX, pixelY, TAILLE_CASE, TAILLE_CASE);

        }
        g.dispose();
    }
}