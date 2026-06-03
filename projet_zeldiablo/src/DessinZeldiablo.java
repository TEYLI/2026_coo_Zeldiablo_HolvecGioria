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
        //Initialisation de l'image
        Graphics g = image.getGraphics();

        Labyrinthe laby = jeu.getLabyrinthe();

        for (int i = 0; i < laby.getLargeur(); i++) {
            for (int j = 0; j < laby.getHauteur(); j++) {
                //Mur
                if (!laby.estTraversable(i, j)) {
                    g.setColor(Color.DARK_GRAY);
                } else {
                    //Sol vide
                    g.setColor(Color.WHITE);
                }
                g.fillRect(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);

                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
            }
        }

        //Construction de Personnage donc hero et monstre
        for (Personnage p : jeu.getPersonnages()) {
            int pixelX = p.getX() * TAILLE_CASE;
            int pixelY = p.getY() * TAILLE_CASE;

            //Couleur de Hero
            if (p instanceof Heros) {
                g.setColor(Color.BLUE);
                //Couleur de Ogre
            } else if (p instanceof Ogre) {
                g.setColor(Color.RED);
                //Couleur de Fantome
            }else if (p instanceof Fantome) {
                g.setColor(Color.PINK);
            }
            g.fillOval(pixelX, pixelY, TAILLE_CASE, TAILLE_CASE);

        }
        Piece piece = jeu.getPiece();
        if(piece != null){
            g.setColor(Color.YELLOW);
            g.fillOval(piece.getX() * TAILLE_CASE + 10, piece.getY() * TAILLE_CASE + 10, TAILLE_CASE/2, TAILLE_CASE/2);
        }

        g.dispose();
    }
}