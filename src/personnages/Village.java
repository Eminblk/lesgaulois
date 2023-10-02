package personnages;

public class Village {
	private Gaulois[] villageois;
	private Chef chef;
	private String nom;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;
	

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];

	}

	public boolean ajouterHabitant(Gaulois gaulois, String nom, Village numéroVillageois)
	{
		if(nbVillageois<nbVillageoisMaximum) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
			return true;
			
		}
		return false;
	}

	public String getNom() {
		return nom;}
	
	public void afficherVillageois(Village village) {
		System.out.println("Dans" + village + "  du chef " + chef +  " vivent les légendaires gaulois : " + 
			villageois );
		
	}
		
		
	public Gaulois trouverHabitant(int numeroVillageois ) {
		return villageois[nbVillageois];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
		}

	public static void main(String[] args) {
		Village Villagedesirréductibles=new Village("Village des irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30); fonctionne pas car on dépasse le nombre max du tableau
		Chef abracoubix = new Chef("Abracoubix", 6, village);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 25);
		afficherVillageois(Villagedesirréductibles);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
	}
		

}