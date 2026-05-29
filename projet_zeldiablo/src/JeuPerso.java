import moteurJeu.Commande;
public class JeuPerso {
    //ATTRIBUTS
    private Personnage perso;

    //CONSTRUCTEUR
    public JeuPerso(){
        this.perso = new Personnage();
    }

    //METHODES
    public void evoluer(Commande c){
        this.perso.deplacer(c);
    }

    public boolean etreFini(){
        return false;
    }
}
