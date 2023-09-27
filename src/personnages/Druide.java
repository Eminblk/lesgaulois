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
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public int preparerPotion() {
		Random random = new Random();
		int forcePotion = random.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;

		String message;

		if (forcePotion > 7) {
			message = parler("J'ai préparé une super potion de force : " + forcePotion);
		} else {
			message = parler(
					"Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force : " + forcePotion);
		}

		return forcePotion; // Retourne la force de la potion générée
	}

	public String parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
		return texte;
	}
	
	public int getEffetPotionMin() {
	    return effetPotionMin;
	}

	public int getEffetPotionMax() {
	    return effetPotionMax;
	}


	public void booster(Gaulois gaulois) {
		if (gaulois.getNom().equals("Obélix")) {
			parler("Non, Obélix !... Tu n’auras pas de potion magique !");
		} else {
			int forcePotion = preparerPotion();
			gaulois.boirePotion(forcePotion);
		}
	}

	public String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obélix", 10);
		panoramix.booster(asterix);
		panoramix.booster(obelix);

	}

}