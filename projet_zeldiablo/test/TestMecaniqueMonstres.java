import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestMecaniqueMonstres {

    /**
     * Test si une case vide est détectée
     */
    @Test
    public void testDetectionCaseVide() {
        //Déclaration
        JeuZeldiablo jeu = new JeuZeldiablo();

        //Tests
        assertFalse(jeu.estCaseVideDePersonnage(10, 10), "La case du héros ne doit pas être vide");
        assertFalse(jeu.estCaseVideDePersonnage(2, 2), "La case de l'ogre ne doit pas être vide");
        assertFalse(jeu.estCaseVideDePersonnage(7, 3), "La case du fantome ne doit pas être vide");

        assertTrue(jeu.estCaseVideDePersonnage(1, 1), "La case 1,1 doit être détectée comme vide");
    }

    /**
     * Test si l'ogre ne sort pas du labyrinthe
     */
    @Test
    public void testOgreResteDansLabyrinthe() {
        //Déclaration
        Labyrinthe laby = new Labyrinthe();
        Ogre ogre = new Ogre(1, 1);

        List<Personnage> persos = new ArrayList<>();
        persos.add(ogre);
        //Execution
        for (int i = 0; i < 100; i++) {
            ogre.deplacer(laby, persos);
        }
        //Tests
        assertTrue(ogre.getX() >= 1 && ogre.getX() < laby.getLargeur() - 1, "L'Ogre ne doit pas traverser les murs verticaux");
        assertTrue(ogre.getY() >= 1 && ogre.getY() < laby.getHauteur() - 1, "L'Ogre ne doit pas traverser les murs horizontaux");
    }

    /**
     * Test si le fantome ne sort pas du labyrinthe
     */
    @Test
    public void testFantomeResteDansLesLimites() {
        //Déclaration
        Labyrinthe laby = new Labyrinthe();
        Fantome fantome = new Fantome(1, 1);

        List<Personnage> persos = new ArrayList<>();
        persos.add(fantome);
        //Execution
        for (int i = 0; i < 200; i++) {
            fantome.deplacer(laby, persos);
        }
        //Tests
        assertTrue(fantome.getX() >= 0 && fantome.getX() < laby.getLargeur(), "Le Fantôme ne doit pas sortir de la carte en X");
        assertTrue(fantome.getY() >= 0 && fantome.getY() < laby.getHauteur(), "Le Fantôme ne doit pas sortir de la carte en Y");
    }

}
