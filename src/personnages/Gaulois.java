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

	public String frapper(Romain romain) {
		int forceCoup = force / 3 * effetPotion; // Prend en compte l'effet de la potion
		String message = nom + " envoie un grand coup dans la machoire de " + romain.getNom();
		romain.recevoirCoup(forceCoup);
		return message;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";

	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}

	public String prendreParole() {
		return " Le gaulois " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}

	public String parler(String texte) {
		return prendreParole() + "<<" + texte + " >>";
	}

	public static void main(String[] args) {

		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain romain = new Romain("Romainus", 10);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		System.out.println(asterix.parler("Ceci est un test"));
		System.out.println(asterix.frapper(romain));

	}
}
