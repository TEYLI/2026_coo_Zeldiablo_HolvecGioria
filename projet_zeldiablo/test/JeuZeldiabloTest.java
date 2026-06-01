import moteurJeu.Commande;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JeuZeldiabloTest {

    @Test
    public void testInitialisationJeu() {
        JeuZeldiablo jeu = new JeuZeldiablo();

        assertNotNull(jeu.getLabyrinthe(), "Le labyrinthe doit être initialisé");
        assertNotNull(jeu.getHeros(), "Le héros doit être initialisé");
        assertFalse(jeu.etreFini(), "Le jeu ne doit pas être fini au démarrage");
    }

    @Test
    public void testEvoluer() {
        JeuZeldiablo jeu = new JeuZeldiablo();
        Commande cmd = new Commande();

        cmd.haut = true;
        jeu.evoluer(cmd);

        assertEquals(5, jeu.getHeros().getX());
        assertEquals(4, jeu.getHeros().getY(), "Le héros a dû monter suite à l'évolution du jeu");
    }
}