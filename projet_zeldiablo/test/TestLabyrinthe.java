import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestLabyrinthe {

    @Test
    public void testInitialisationLabyrinthe() {
        Labyrinthe laby = new Labyrinthe();

        assertEquals(10, laby.getLargeur(), "La largeur doit être de 10");
        assertEquals(10, laby.getHauteur(), "La hauteur doit être de 10");
    }

    @Test
    public void testBorduresSontDesMurs() {
        Labyrinthe laby = new Labyrinthe();

        assertFalse(laby.estTraversable(0, 0), "Le coin haut-gauche doit être un mur");
        assertFalse(laby.estTraversable(9, 9), "Le coin bas-droite doit être un mur");

        assertFalse(laby.estTraversable(5, 0), "Le bord supérieur doit être un mur");
        assertFalse(laby.estTraversable(0, 5), "Le bord gauche doit être un mur");
    }

    @Test
    public void testCentreEstVide() {
        Labyrinthe laby = new Labyrinthe();

        assertTrue(laby.estTraversable(5, 5), "Le centre du labyrinthe doit être traversable");
        assertTrue(laby.estTraversable(1, 1), "La case juste après le coin haut-gauche doit être vide");
    }
}