import moteurJeu.Commande;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HerosTest {

    @Test
    public void testPositionInitiale() {
        Heros heros = new Heros(5, 5);
        assertEquals(5, heros.getX(), "Le héros doit apparaître en X=5");
        assertEquals(5, heros.getY(), "Le héros doit apparaître en Y=5");
    }

    @Test
    public void testDeplacementLibre() {
        Labyrinthe laby = new Labyrinthe();
        Heros heros = new Heros(5, 5);
        Commande cmd = new Commande();

        cmd.droite = true;
        heros.deplacer(cmd, laby);

        assertEquals(6, heros.getX(), "Le héros a dû se déplacer à droite (X=6)");
        assertEquals(5, heros.getY(), "La coordonnée Y ne doit pas avoir changé");
    }

    @Test
    public void testCollisionMur() {
        Labyrinthe laby = new Labyrinthe();
        Heros heros = new Heros(1, 5);
        Commande cmd = new Commande();

        cmd.gauche = true;
        heros.deplacer(cmd, laby);

        assertEquals(1, heros.getX(), "Le héros doit être bloqué par le mur en X=1");
        assertEquals(5, heros.getY(), "La coordonnée Y ne doit pas avoir changé");
    }
}