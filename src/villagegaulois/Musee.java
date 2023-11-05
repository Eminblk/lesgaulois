package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;

public class Musee {
    private Trophee[] trophees;
    private int nbTrophee;

    public Musee() {
        trophees = new Trophee[200];
        nbTrophee = 0;
    }
    
    public String extraireInstructionsOCaml() {
        StringBuilder ocamlInstructions = new StringBuilder("let musee = [");

        for (int i = 0; i < nbTrophee; i++) {
            Trophee trophee = trophees[i];
            ocamlInstructions.append("\"").append(trophee.getGaulois().getNom()).append("\", \"").append(trophee.getEquipement().getNom()).append("\"");

            if (i < nbTrophee - 1) {
                ocamlInstructions.append("; ");
            }
        }

        ocamlInstructions.append("];");
        return ocamlInstructions.toString();
    }


    public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
        Trophee trophee = new Trophee(gaulois, equipement);
        trophees[nbTrophee] = trophee;
        nbTrophee++;
    }
}