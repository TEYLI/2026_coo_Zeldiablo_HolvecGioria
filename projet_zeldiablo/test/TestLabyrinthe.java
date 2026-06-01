import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test du labyrinthe
 */
public class TestLabyrinthe {

    /**
     * test de l'initialisation du labyrinthe
     */
    @Test
    public void testInitialisationLabyrinthe() {
        //Declarations
        Labyrinthe laby = new Labyrinthe();

        //Tests
        assertEquals(10, laby.getLargeur(), "La largeur doit être de 10");
        assertEquals(10, laby.getHauteur(), "La hauteur doit être de 10");
    }

    /**
     * Test pour verifier que les bord du labyrinthe sont bien des murs
     */
    @Test
    public void testBorduresSontDesMurs() {
        //Declarations
        Labyrinthe laby = new Labyrinthe();

        //Tests
        assertFalse(laby.estTraversable(0, 0), "Le coin haut-gauche doit être un mur");
        assertFalse(laby.estTraversable(9, 9), "Le coin bas-droite doit être un mur");

        assertFalse(laby.estTraversable(5, 0), "Le bord supérieur doit être un mur");
        assertFalse(laby.estTraversable(0, 5), "Le bord gauche doit être un mur");
    }

    /**
     * Test verifie le centre est bien vide
     */
    @Test
    public void testCentreEstVide() {
        //Declaration
        Labyrinthe laby = new Labyrinthe();

        //Tests
        assertTrue(laby.estTraversable(5, 5), "Le centre du labyrinthe doit être traversable");
        assertTrue(laby.estTraversable(1, 1), "La case juste après le coin haut-gauche doit être vide");
    }
}