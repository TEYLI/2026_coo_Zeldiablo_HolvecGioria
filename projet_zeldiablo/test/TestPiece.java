import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de Piece qui vérifie ses fonctionnalités
 */
public class TestPiece {

    /**
     * Verifie si la piece est bien créée
     */
    @Test
    public void testCreationPiece() {
        //declaration
        Piece piece = new Piece(7, 8);

        //tests
        assertEquals(7, piece.getX(), "la piece doit se trouver en X=7");
        assertEquals(8, piece.getY(), "La pièce doit se trouver en Y=8");
    }

    /**
     * Verifie si la piece est bien ramasser
     */
    @Test
    public void testRamasserPieceHeros() {
        // déclaration
        Heros heros = new Heros(5, 5);

        //test init
        assertEquals(0, heros.getPiecesRamassees(), "le heros doit commencer avec 0 piece");

        //execution
        heros.ramasserPiece();

        //test
        assertEquals(1, heros.getPiecesRamassees(), "Le compteur de pièces doit s'être incremente de 1");
    }

    /**
     * test de l'apparition de la piece dans le jeu Z
     */
    @Test
    public void testSpawnPieceJeuZeldiablo() {
        //declarations
        JeuZeldiablo jeu = new JeuZeldiablo();

        //test init
        assertNotNull(jeu.getPiece(), "Une pièce doit exister dès la création du jeu");

        //Recuperation des coordonnées de la piece
        Piece pieceInitiale = jeu.getPiece();
        int initialX = pieceInitiale.getX();
        int initialY = pieceInitiale.getY();

        //execution
        jeu.spawnPiece();

        //tests
        Piece nouvellePiece = jeu.getPiece();
        assertNotNull(nouvellePiece, "une nouvelle pièce doit être générée");

        //la piece est sur une case accessible.
        assertTrue(jeu.getLabyrinthe().estTraversable(nouvellePiece.getX(), nouvellePiece.getY()),
                "La piece doit apparaitre sur une case traversable");
        assertTrue(jeu.estCaseVideDePersonnage(nouvellePiece.getX(), nouvellePiece.getY()),
                "La piece doit apparaitre sur une case sans personage");
    }
}