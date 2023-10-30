package personnages;

public class Village {
    private String nom;
    private Chef chef;
    private Gaulois[] villageois; // Tableau de Gaulois
    private int nbVillageois; // Nombre de villageois actuels
    private int nbVillageoisMaximum; // Nombre maximum de villageois

    public Village(String nom, int nbVillageoisMaximum) {
        this.nom = nom;
        this.nbVillageois = 0;
        this.nbVillageoisMaximum = nbVillageoisMaximum;
        this.villageois = new Gaulois[nbVillageoisMaximum]; // Initialisation du tableau
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public String getNom() {
        return nom;
    }

    // Méthode pour ajouter un Gaulois au village
    public void ajouterHabitant(Gaulois gaulois) {
        if (nbVillageois < nbVillageoisMaximum) {
            villageois[nbVillageois] = gaulois;
            nbVillageois++;
        } else {
            System.out.println("Le village est déjà plein, " + gaulois.getNom() + " ne peut pas être ajouté.");
        }
    }

    // Méthode pour trouver un Gaulois en fonction de son numéro (de 0 à nbVillageois - 1)
    public Gaulois trouverHabitant(int numero) {
        if (numero >= 0 && numero < nbVillageois) {
            return villageois[numero];
        } else {
            System.out.println("Le villageois avec le numéro " + numero + " n'existe pas.");
            return null;
        }
    }

    // Méthode pour afficher tous les villageois
    public void afficherVillageois() {
        if (chef != null) {
            System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois du village " + nom + " : ");
            
            for (Gaulois villageois : villageois) {
                if (villageois != null) {
                    System.out.println("- " + villageois.getNom());
                }
            }
        }
    }



    public static void main(String[] args) {
        Village village = new Village("Village des Irréductibles", 30);
        Gaulois astérix = new Gaulois("Astérix", 8);
        Chef abraracourcix = new Chef("Abraracourcix", 6, village);
        village.setChef(abraracourcix);
        village.ajouterHabitant(astérix);
        
        // Exemple d'utilisation de trouverHabitant
        Gaulois gaulois = village.trouverHabitant(0);
        System.out.println(gaulois);
        
        village.afficherVillageois();
        
        Gaulois obélix = new Gaulois("Obélix", 25);
        village.ajouterHabitant(obélix);
        village.afficherVillageois();
    }
}
