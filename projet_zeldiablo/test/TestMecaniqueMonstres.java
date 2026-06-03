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
        assertFalse(jeu.estCaseVideDePersonnage(10, 10), "La case du heros ne doit pas etre vide");
        assertFalse(jeu.estCaseVideDePersonnage(2, 2), "la case de l'ogre ne doit pas etre vide");
        assertFalse(jeu.estCaseVideDePersonnage(7, 3), "La case du fantome ne doit pas être vide");

        assertTrue(jeu.estCaseVideDePersonnage(1, 1), "la case 1,1 doit être détectée comme vide");
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
        assertTrue(ogre.getX() >= 1 && ogre.getX() < laby.getLargeur() - 1, "L'ogre ne doit pas traverser les murs verticaux");
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
        assertTrue(fantome.getX() >= 0 && fantome.getX() < laby.getLargeur(), "Le fantome ne doit pas sortir de la carte en X");
        assertTrue(fantome.getY() >= 0 && fantome.getY() < laby.getHauteur(), "Le Fantome ne doit pas sortir de la carte en Y");
    }

    /**
     * Test du systeme de degats géneral : le systeme de perte de pv et le temps mort après attaque
     */
    @Test
    public void testSystemeDegatsEtTempsAttaque() {
        // Déclaration
        Labyrinthe laby = new Labyrinthe();
        Heros heros = new Heros(5, 5);
        Ogre ogre = new Ogre(6, 5);

        List<Personnage> persos = new ArrayList<>();
        persos.add(heros);
        persos.add(ogre);

        // Test PV initiaux
        assertEquals(10, heros.getPointsDeVie(), "Le heros doit commencer avec 10 Pv");

        //execution
        ogre.agir(laby, persos);

        //test attaque 1
        assertEquals(8, heros.getPointsDeVie(), "Le héros a du subir 2 dégats de l'ogre");

        //execution
        ogre.agir(laby, persos);

        //test du temps mort après attaque
        assertEquals(8, heros.getPointsDeVie(), "Les pvs ne doivent pas diminuer car le cooldown bloque l'attaque");
    }




}
