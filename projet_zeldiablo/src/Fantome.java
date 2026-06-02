import java.util.List;

public class Fantome extends Monstre {

    public Fantome(int x, int y) {
        super(x, y);
    }

    @Override
    public void deplacer(Labyrinthe labyrinthe, List<Personnage> personnages) {
        int futurX = this.x;
        int futurY = this.y;

        int direction = (int) (Math.random() * 4);

        if (Math.floor(Math.random() * 12) == 1) {
            switch (direction) {
                case 0: futurX--; break;
                case 1: futurX++; break;
                case 2: futurY--; break;
                case 3: futurY++; break;
            }
        }

        if (futurX >= 0 && futurX < labyrinthe.getLargeur() && futurY >= 0 && futurY < labyrinthe.getHauteur()) {
            boolean caseOccupee = false;

            for (int i = 0; i < personnages.size(); i++) {
                Personnage p = personnages.get(i);
                if (p != this && p.getX() == futurX && p.getY() == futurY) {
                    caseOccupee = true;
                    break;
                }
            }

            if (!caseOccupee) {
                this.x = futurX;
                this.y = futurY;
            }
        }
    }
}