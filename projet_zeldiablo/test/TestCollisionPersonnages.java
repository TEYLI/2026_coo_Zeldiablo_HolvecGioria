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
        Monstre monstreLoin = new Monstre(8, 8);

        List<Personnage> persos = new ArrayList<>();
        persos.add(heros);
        persos.add(monstreLoin);

        Commande cmd = new Commande();
        cmd.droite = true;

        //Exécution
        heros.deplacer(cmd, laby, persos);

        //Test
        assertEquals(6, heros.getX(), "Le héros doit avancer si la case est vide (Critère 2)");
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
        Monstre monstre = new Monstre(6, 5);

        List<Personnage> persos = new ArrayList<>();
        persos.add(heros);
        persos.add(monstre);

        Commande cmd = new Commande();
        cmd.droite = true;

        //Exécution
        heros.deplacer(cmd, laby, persos);

        //Test
        assertEquals(5, heros.getX(), "Le héros doit être bloqué par le monstre (Critère 1)");
        assertEquals(5, heros.getY());
    }
}

