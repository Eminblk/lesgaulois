package personnages;

import java.util.Random;

public class Druide {
    private String nom;
    private int effetPotionMin;
    private int effetPotionMax;
    private int forcePotion = 1;

    public Druide(String nom, int effetPotionMin, int effetPotionMax) {
        this.nom = nom;
        this.effetPotionMin = effetPotionMin;
        this.effetPotionMax = effetPotionMax;
        parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à " + effetPotionMax + ".");
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + "»");
    }

    private String prendreParole() {
        return "Le druide " + nom + " : ";
    }

    public void preparerPotion() {
        Random random = new Random();
        int forcePotion = random.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;
        if (forcePotion > 7) {
            parler("J'ai préparé une super potion de force " + forcePotion);
        } else {
            parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion);
        }
        this.forcePotion = forcePotion;
    }

    public void booster(Gaulois gaulois) {
        if (gaulois.getNom().equals("Obélix")) {
            parler("Non, Obélix !... Tu n'auras pas de potion magique !");
        } else {
            gaulois.boirePotion(forcePotion);
            parler("Potion magique pour " + gaulois.getNom() + " !");
        }
    }

    public static void main(String[] args) {
        Druide panoramix = new Druide("Panoramix", 5, 10);
        panoramix.preparerPotion();
        Gaulois obelix = new Gaulois("Obélix", 25);
        panoramix.booster(obelix);  // Utilisation de la méthode booster pour Obélix
        Gaulois asterix = new Gaulois("Astérix", 8);
        asterix.parler("Bonjour");
        Romain minus = new Romain("Minus", 6);
        asterix.frapper(minus);
    }

}
