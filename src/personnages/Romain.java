package personnages;

public class Romain {
	private String nom;
	private int force;
//	private String texte;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert force > 0 : "Invariant violated: la force d’un Romain doit être positive";
		this.nom = nom;
		this.force = force;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			equipements[0] = equipement;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.getNom() + ".");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement.getNom() + " !");
			} else {
				equipements[1] = equipement;
				nbEquipement++;
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.getNom() + ".");
			}
			break;
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		}
	}

	
    public int getForce() {
		return force;
	}
    
	private int CalculResistanceEquipement(int forceCoup) {
	    String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
	    int resistanceEquipement = 0;
	    if (nbEquipement != 0) {
	        texte += "\nMais heureusement, grâce à mon équipement, sa force est diminuée de ";
	        for (int i = 0; i < nbEquipement; i++) {
	            if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
	                resistanceEquipement += 8;
	            } else {
	                System.out.println("Equipement casque");
	                resistanceEquipement += 5;
	            }
	        }
	        texte += resistanceEquipement + "!";
	    }
	    parler(texte);
	    forceCoup -= resistanceEquipement;
	    return forceCoup;
	}


	private Equipement[] ejecterEquipement() {
	    Equipement[] equipementEjecte = new Equipement[nbEquipement];
	    System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
	    int nbEquipementEjecte = 0;
	    for (int i = 0; i < nbEquipement; i++) {
	        if (equipements[i] != null) {
	            equipementEjecte[nbEquipementEjecte] = equipements[i];
	            nbEquipementEjecte++;
	            equipements[i] = null;
	        }
	    }
	    return equipementEjecte;
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

	public Equipement[] recevoirCoup(int forceCoup) {
	    Equipement[] equipementEjecte = null;
	    // précondition
	    assert force > 0;
	    int oldForce = force;
	    forceCoup = CalculResistanceEquipement(forceCoup);
	    force -= forceCoup;
	    if (force == 0) {
	        parler("Aïe");
	    } else {
	        equipementEjecte = ejecterEquipement();
	        parler("J'abandonne...");
	    }
	    // post condition la force a diminuée
	    assert force < oldForce;
	    return equipementEjecte;
	}


//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup >= 0 : "Precondition violated: la force du coup doit être positive ou nulle";
//		int ancienneForce = force;
//		force -= forceCoup;
//		assert force >= 0 : "Postcondition violated: la force d’un Romain doit être positive ou nulle";
//		if (force > 0) {
//			parler("Aïe !");
//		} else {
//			parler("J'abandonne...");
//		}
//	}

	public static void main(String[] args) {
		Romain romain = new Romain("César", 10);
		Romain minus = new Romain("Minus", 6);

		// Vérification des méthodes prendreParole, parler et recevoirCoup
		System.out.println(romain.getNom());
		romain.parler("Salut, je suis un Romain !");
		romain.recevoirCoup(7);

		System.out.println("Les équipements disponibles pour les Romains :");
		for (Equipement equipement : Equipement.values()) {
			System.out.println(equipement + " - " + equipement.getNom());

		}

		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;

		minus.sEquiper(casque); // Le soldat Minus s'équipe avec un casque.
		minus.sEquiper(casque); // Le soldat Minus possède déjà un casque.
		minus.sEquiper(bouclier); // Le soldat Minus s'équipe avec un bouclier.
		minus.sEquiper(casque); // Le soldat Minus est déjà bien protégé !
	}
}