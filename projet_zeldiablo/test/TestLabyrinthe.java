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
        assertEquals(15, laby.getLargeur(), "La largeur doit être de 20");
        assertEquals(15, laby.getHauteur(), "La hauteur doit être de 20");
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
        assertFalse(laby.estTraversable(19, 19), "Le coin bas-droite doit être un mur");

        assertFalse(laby.estTraversable(5, 0), "Le bord supérieur doit être un mur");
        assertFalse(laby.estTraversable(0, 5), "Le bord gauche doit être un mur");
    }

    /**
     * Test qui vérifie que les cases des personnages soit bein vides au départ
     */
    @Test
    public void testCasesProtegeesSontVides() {
        //Déclaration
        Labyrinthe laby = new Labyrinthe();

        //Tests
        assertTrue(laby.estTraversable(10, 10), "La case de départ Héros doit être traversable");
        assertTrue(laby.estTraversable(2, 2), "La case de départ Monstre 1 doit être traversable");
        assertTrue(laby.estTraversable(10, 5), "La case de départ Monstre 2 doit être traversable");
    }

}