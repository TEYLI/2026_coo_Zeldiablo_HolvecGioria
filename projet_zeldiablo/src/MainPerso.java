import moteurJeu.MoteurGraphique;

import java.util.Scanner;

/**
 * Classe principale pour lancer le jeu du personnage simple.
 */
public class MainPerso {

    public static void main(String[] args) throws InterruptedException {
        JeuPerso jeu = new JeuPerso();

        DessinPerso dessin = new DessinPerso(jeu);

        MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);

        moteur.lancerJeu(400, 400);

        System.out.println("Fin du Jeu - appuyer sur entree");
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        System.exit(1);
    }
}