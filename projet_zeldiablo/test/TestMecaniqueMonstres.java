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
        JeuZeldiablo jeu = new JeuZeldiablo();

        assertFalse(jeu.estCaseVideDePersonnage(5, 5), "La case 5,5 ne doit pas être vide");
        assertFalse(jeu.estCaseVideDePersonnage(2, 2), "La case 2,2 ne doit pas être vide");

        assertTrue(jeu.estCaseVideDePersonnage(1, 1), "La case 1,1 doit être détectée comme vide");
    }

    /**
     * Test si le monstre bouge au départ du programme
     */
    @Test
    public void testRalentissementMonstre() {
        Labyrinthe laby = new Labyrinthe();
        Monstre monstre = new Monstre(5, 5);
        List<Personnage> persos = new ArrayList<>();
        persos.add(monstre);

        monstre.deplacer(laby, persos);

        assertEquals(5, monstre.getX(), "Le monstre ne doit pas bouger au premier tour");
        assertEquals(5, monstre.getY());
    }

    /**
     * Test si le monstre ne traverse pas les murs
     */
    @Test
    public void testMonstreResteDansLabyrinthe() {
        Labyrinthe laby = new Labyrinthe();

        Monstre monstre = new Monstre(1, 1);
        List<Personnage> persos = new ArrayList<>();
        persos.add(monstre);

        for (int i = 0; i < 50; i++) {
            monstre.deplacer(laby, persos);
        }

        assertTrue(monstre.getX() >= 1 && monstre.getX() < laby.getLargeur() - 1, "Le monstre ne doit pas traverser les murs verticaux");
        assertTrue(monstre.getY() >= 1 && monstre.getY() < laby.getHauteur() - 1, "Le monstre ne doit pas traverser les murs horizontaux");
    }
}
