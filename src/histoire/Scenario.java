package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;
import personnages.Chef;

public class Scenario {
    public static void main(String[] args) {
        Gaulois asterix = new Gaulois("Astérix", 8);
        Romain minus = new Romain("Minus", 6);

        asterix.parler("Bonjour à tous");
        minus.parler("UN GAU... UN GAUGAU...");

        for (int i = 0; i < 3; i++) {
            asterix.frapper(minus);
            minus.parler("Aïe");
        }

        asterix.frapper(minus);
        minus.parler("J'abandonne...");

        Druide panoramix = new Druide("Panoramix", 5, 10);
        panoramix.preparerPotion();
        Gaulois obelix = new Gaulois("Obélix", 25);
        obelix.parler("Par Bélénos, ce n'est pas juste!");
        panoramix.booster(obelix);

        asterix.parler("Bonjour");
        minus = new Romain("Minus", 6);
        asterix.frapper(minus);
    }
}
