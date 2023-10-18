package JeuDeCarte;

public class Carte {
    
    private String couleur;
    private String forme;
    private int numCarte;

    public Carte(String couleur, String forme, int numCarte) {
        this.couleur = couleur;
        this.forme = forme;
        this.numCarte = numCarte;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getForme() {
        return forme;
    }

    public int getNumCarte() {
        return numCarte;
    }

    @Override
    public String toString() {
        return "(" + numCarte + "," + forme + "," + couleur + ")";
    }
}


