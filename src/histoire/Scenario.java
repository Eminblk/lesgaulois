package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;
import personnages.Village;

public class Scenario {

	public static void main(String[] args) {
		// Création des personnages
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 6);
		Gaulois obelix = new Gaulois("Obélix", 25);

		// Création du druide et du village
		Village village = new Village("Le Village Gaulois");
		Druide panoramix = new Druide("Panoramix", 5, 10);

		// Début du scénario
		System.out.println(panoramix.prendreParole() + "Bonjour, je suis le druide " + panoramix.getNom()
				+ " et ma potion peut aller d'une force " + panoramix.getEffetPotionMin() + " à "
				+ panoramix.getEffetPotionMax() + ".");
		System.out.println(panoramix.prendreParole() + "Je vais aller préparer une petite potion...");

		int forcePotion = panoramix.preparerPotion();
		System.out.println(panoramix.prendreParole() + (forcePotion > 7
				? "J'ai préparé une super potion de force : " + forcePotion
				: "Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force : " + forcePotion));

		// Booster Obélix
		panoramix.booster(obelix);
		System.out.println(obelix.prendreParole() + "Par Bélénos, ce n'est pas juste!");

		// Boire une potion pour Astérix
		asterix.boirePotion(6); // Astérix boit une potion de force 6

		System.out.println(asterix.prendreParole() + "Bonjour");
		System.out.println(minus.prendreParole() + "UN GAU... UN GAUGAU...");

		// Combat
		System.out.println(asterix.frapper(minus));
		System.out.println(minus.prendreParole() + "J'abandonne...");
	}
}
