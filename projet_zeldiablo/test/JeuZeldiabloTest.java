import moteurJeu.Commande;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de la classe JeuZeldiablo
 */
public class JeuZeldiabloTest {

    /**
     * Test de l'initialisation du jeu et de tout ses sprites
     */
    @Test
    public void testInitialisationJeu() {
        //Declaration
        JeuZeldiablo jeu = new JeuZeldiablo();

        //tests
        assertNotNull(jeu.getLabyrinthe(), "Le labyrinthe doit être initialisé");
        assertNotNull(jeu.getHeros(), "Le héros doit être initialisé");
        assertFalse(jeu.etreFini(), "Le jeu ne doit pas être fini au démarrage");
    }

    /**
     * test de la methode evoluer
     */
    @Test
    public void testEvoluer() {
        //Declaration
        JeuZeldiablo jeu = new JeuZeldiablo();
        Commande cmd = new Commande();

        //Execution
        cmd.haut = true;
        jeu.evoluer(cmd);

        //Tests
        assertEquals(5, jeu.getHeros().getX());
        assertEquals(4, jeu.getHeros().getY(), "Le héros a dû monter suite à l'évolution du jeu");
    }
}