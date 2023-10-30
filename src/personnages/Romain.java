package personnages;

public class Romain {
    private String nom;
    private int force;

    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + "»");
    }

    private String prendreParole() {
        return "Le romain " + nom + " : ";
    }

    public void recevoirCoup(int forceCoup) {
        force -= forceCoup;
        if (force > 0) {
            parler("Aïe");
        } else {
            parler("J'abandonne...");
        }
    }

    public static void main(String[] args) {
        Romain romain = new Romain("César", 10);

        // Vérification des méthodes prendreParole, parler et recevoirCoup
        System.out.println(romain.getNom());
        romain.parler("Salut, je suis un Romain !");
        romain.recevoirCoup(7);
    }
}
