import moteurJeu.MoteurGraphique;

public class MainZeldiablo {

    public static void main(String[] args) throws InterruptedException {
        JeuZeldiablo jeu = new JeuZeldiablo();
        DessinZeldiablo dessin = new DessinZeldiablo(jeu);

        MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);
        moteur.lancerJeu(400, 400);
    }
}