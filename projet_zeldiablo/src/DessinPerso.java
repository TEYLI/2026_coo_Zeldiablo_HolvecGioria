import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import moteurJeu.DessinJeu;

public class DessinPerso implements DessinJeu {
    private JeuPerso jeu;
    private static int TAILLE_CASE = 20;

    public DessinPerso(JeuPerso jeu) {
        this.jeu = jeu;
    }

    @Override
    public void dessiner(BufferedImage image) {
        Graphics g = image.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        Personnage p = this.jeu.getPersonnage();
        g.setColor(Color.BLUE);
        int positionXPixel = p.getX()*TAILLE_CASE;
        int positionYPixel = p.getY()*TAILLE_CASE;
        g.fillOval(positionXPixel, positionYPixel, TAILLE_CASE, TAILLE_CASE);
        g.dispose();
    }
}
