import moteurJeu.MoteurGraphique;

/**
 * Classe MainZeldiablo qui lance le jeu
 */
public class MainZeldiablo {
    /**
     * Methode Main
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        //Declaration du jeu et dessin
        JeuZeldiablo jeu = new JeuZeldiablo();
        DessinZeldiablo dessin = new DessinZeldiablo(jeu);

        //Mise en place du moteur graphique
        MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);
        moteur.lancerJeu(600, 600);
    }
}