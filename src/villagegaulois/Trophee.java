package villagegaulois;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;



public class Trophee {
    private Gaulois gaulois;
    private Equipement equipement;

    public Trophee(Gaulois gaulois, Equipement equipement) {
        this.gaulois = gaulois;
        this.equipement = equipement;
    }

    public Gaulois getGaulois() {
        return gaulois;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public String donnerNom() {
        return gaulois.getNom();
    }
}