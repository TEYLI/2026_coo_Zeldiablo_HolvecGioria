/**public class JeuPerso {
    //ATTRIBUTS
    private Personnage perso;

    //CONSTRUCTEUR
    public jeuPerso(){
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
