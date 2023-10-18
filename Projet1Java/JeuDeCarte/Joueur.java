package JeuDeCarte;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    
    public List<Carte> main;
    private int compteurPoints;

    public Joueur() {
        main = new ArrayList<>();
        compteurPoints = 0;
    }

    public List<Carte> getMain() {
        return main;
    }

    public int getCompteurPoints() {
        return compteurPoints;
    }

    public void incrementerCompteurPoints() {
        compteurPoints++;
    }

    public boolean aDesCartes() {
        return !main.isEmpty();
    }

    public Carte tirerUneCarte() {
        if (aDesCartes()) {
            return main.remove(0);
        }
        return null;
    }
}
