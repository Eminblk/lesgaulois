package personnages;

public class Gaulois {
    private String nom;
    private int force;
    private int effetPotion = 1;

    public Gaulois(String nom, int force) {
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
        return "Le gaulois " + nom + " : ";
    }

    public void boirePotion(int forcePotion) {
        effetPotion = forcePotion;
        parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
    }
    
    public void frapper(Romain romain) {
        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
        romain.recevoirCoup(force / 3);
    }

    @Override
    public String toString() {
        return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
    }

    public static void main(String[] args) {
        Gaulois asterix = new Gaulois("Astérix", 8);

        // Afficher le nom de l'objet
        System.out.println(asterix.getNom());

        // Utilisation des méthodes parler et frapper
        asterix.parler("Salut, je suis Astérix !");
        Romain romain = new Romain("César", 10);
        asterix.frapper(romain);

        // Vérification des méthodes de la classe Romain
        romain.parler("Je suis César, un Romain !");
        romain.recevoirCoup(5);
    }
}
