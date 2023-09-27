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

	public String parler(String texte) {
		return (prendreParole() + "<<" + texte + ">>");

	}

	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public String recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			String message = parler("Aïe");
			return message;
		} else {
			String message = parler("J'abandonne...");
			return message;
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 4);
		System.out.println(minus.prendreParole());
		System.out.println(minus.parler("Bonjour"));
		System.out.println(minus.recevoirCoup(3));
	}
}
