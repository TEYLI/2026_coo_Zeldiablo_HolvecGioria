import moteurJeu.Commande;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestCollisionPersonnages {

    /**
     * Test si le héros se déplace dans une case vide
     */
    @Test
    public void testDeplacementLibreHeros() {
        //Déclaration
        Labyrinthe laby = new Labyrinthe();
        Heros heros = new Heros(5, 5);
        Ogre ogreLoin = new Ogre(8, 8);

        List<Personnage> persos = new ArrayList<>();
        persos.add(heros);
        persos.add(ogreLoin);

        Commande cmd = new Commande();
        cmd.droite = true;

        //Exécution
        heros.deplacer(cmd, laby, persos);

        //Test
        assertEquals(6, heros.getX(), "Le héros doit avancer si la case est vide");
        assertEquals(5, heros.getY());
    }

    /**
     * Test sir le héros rentre bien en collision avec le monstre
     */
    @Test
    public void testCollisionHerosContreMonstre() {
        //Déclaration
        Labyrinthe laby = new Labyrinthe();
        Heros heros = new Heros(5, 5);
        Ogre ogre = new Ogre(6, 5);

        List<Personnage> persos = new ArrayList<>();
        persos.add(heros);
        persos.add(ogre);

        Commande cmd = new Commande();
        cmd.droite = true;

        //Exécution
        heros.deplacer(cmd, laby, persos);

        //Test
        assertEquals(5, heros.getX(), "Le héros doit être bloqué par le monstre");
        assertEquals(5, heros.getY());
    }
}

