package histoire;

import personnages.Druide;
import objets.Equipement;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5);
		druide.parler("Je vais aller pr�parer une petite potion...");
		druide.fabriquerPotion(5, 3);
		Gaulois obelix = new Gaulois("Ob�lix", 25);
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		druide.boosterGaulois(obelix);
		obelix.parler("Par B�l�nos, ce n'est pas juste !");
		druide.boosterGaulois(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0);
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (milexcus.getForce() > 0);
		
//		
//		Musee musee = new Musee();
//		asterix.faireUneDonnation(musee);

	}

}