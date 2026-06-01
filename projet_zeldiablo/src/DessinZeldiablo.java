import moteurJeu.DessinJeu;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;

public class DessinZeldiablo implements DessinJeu {
    private JeuZeldiablo jeu;
    private static final int TAILLE_CASE = 40;

    public DessinZeldiablo(JeuZeldiablo jeu) {
        this.jeu = jeu;
    }

    @Override
    public void dessiner(BufferedImage image) {
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

        Heros heros = jeu.getHeros();
        g.setColor(Color.BLUE);
        int pixelX = heros.getX() * TAILLE_CASE;
        int pixelY = heros.getY() * TAILLE_CASE;
        g.fillOval(pixelX, pixelY, TAILLE_CASE, TAILLE_CASE);

        g.dispose();
    }
}