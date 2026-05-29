import moteurJeu.Commande;
import moteurJeu.Jeu;
public class JeuPerso implements Jeu {
    //ATTRIBUTS
    private Personnage perso;

    //CONSTRUCTEUR
    public JeuPerso(){
        this.perso = new Personnage();
    }

    //METHODES

    public Personnage getPersonnage(){
        return this.perso;
    }

    @Override
    public void evoluer(Commande c){
        this.perso.deplacer(c);
    }

    @Override
    public boolean etreFini(){
        return false;
    }
}
