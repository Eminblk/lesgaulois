package personnages;
import villagegaulois.Musee;
import villagegaulois.Trophee;

public class Gaulois {
    private String nom;
    private int effetPotion = 1;
    private int force; 
    private int nbTrophees;
    private Trophee[] trophees; // Un seul tableau pour les trophées

    public Gaulois(String nom, int force) {
        this.nom = nom;
        this.force = force;
        trophees = new Trophee[200];
    }
    
    
    public int getForce() {
		return force;
	}
    
    public void frapper(Romain romain) {
        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
        Equipement[] equipements = romain.recevoirCoup((force / 3) * effetPotion);
        if (equipements != null) {
            for (Equipement equipement : equipements) {
                if (equipement != null) {
                    ajouterTrophee(equipement);
                }
            }
        }
        // Si equipements est null, aucune action n'est nécessaire.
    }

    public void ajouterTrophee(Equipement equipement) {
        if (nbTrophees < trophees.length) {
            trophees[nbTrophees] = new Trophee(this, equipement);
            nbTrophees++;
        }
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
    
    public void faireUneDonation(Musee musee) {
        if (trophees != null) {
            if (nbTrophees > 0) {
                System.out.println("Le gaulois " + nom + " :");
                System.out.println("Je donne au musée tous mes trophées :");
                for (int i = 0; i < nbTrophees; i++) {
                    musee.donnerTrophees(this, trophees[i].getEquipement());
                    System.out.println("- " + trophees[i].getEquipement().getNom());
                }
                // Réinitialisez le tableau des trophees après la donation si nécessaire.
                trophees = new Trophee[200];
                nbTrophees = 0;
            } else {
                System.out.println("Le gaulois " + nom + " : Je n'ai aucun trophée à donner.");
            }
        }
    }

    public void boirePotion(int forcePotion) {
        effetPotion = forcePotion;
        parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
    }

    @Override
    public String toString() {
        return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + ", nbTrophees=" + nbTrophees + "]";
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
