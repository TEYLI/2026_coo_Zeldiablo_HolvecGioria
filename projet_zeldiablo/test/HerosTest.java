import moteurJeu.Commande;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe HerosTest permet de tester la classe heros
 */
public class HerosTest {

    /**
     * Test de la position de spawn du hero
     */
    @Test
    public void testPositionInitiale() {
        //Declaration
        Heros heros = new Heros(5, 5);

        //Tests
        assertEquals(5, heros.getX(), "Le héros doit apparaître en X=5");
        assertEquals(5, heros.getY(), "Le héros doit apparaître en Y=5");
    }

    /**
     * Test du deplacement du hero en case libre
     */
    @Test
    public void testDeplacementLibre() {
        //Declaration
        Labyrinthe laby = new Labyrinthe();
        Heros heros = new Heros(5, 5);
        List<Personnage> persos = new ArrayList<>();
        Commande cmd = new Commande();

        //Execution
        cmd.droite = true;
        heros.deplacer(cmd, laby, persos);

        //Test
        assertEquals(6, heros.getX(), "Le héros a dû se déplacer à droite (X=6)");
        assertEquals(5, heros.getY(), "La coordonnée Y ne doit pas avoir changé");
    }

    /**
     * Test du deplacement lors d'une rencontre avec un mur
     */
    @Test
    public void testCollisionMur() {
        //Declaration
        Labyrinthe laby = new Labyrinthe();
        Heros heros = new Heros(1, 5);
        List<Personnage> persos = new ArrayList<>();
        Commande cmd = new Commande();

        //Execution
        cmd.gauche = true;
        heros.deplacer(cmd, laby, persos);

        //Test
        assertEquals(1, heros.getX(), "Le héros doit être bloqué par le mur en X=1");
        assertEquals(5, heros.getY(), "La coordonnée Y ne doit pas avoir changé");
    }
}