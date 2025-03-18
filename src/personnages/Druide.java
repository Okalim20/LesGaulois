package personnages;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron;
	
	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.chaudron = new Chaudron();
	}
	
	public String prendreParole() {
		return "Le Druide " + nom + " : ";
	}
	
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	

	
	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai conconct� "+quantite+" doses de potion magique. Elle a une force de "+forcePotion+".");
		
	} 
	
	public void boosterGaulois(Gaulois gaulois) {
		if (chaudron.resterPotion()) {
			if (gaulois.getNom()=="Ob�lix") {
				parler("Non, "+gaulois.getNom()+" Non !... Et tu le sais tr�s bien !");
				
			}
			else {
				int effetPotion = chaudron.prendreLouche();
				gaulois.boirePotion(effetPotion);
				parler("Tiens "+gaulois.getNom()+" un peu de potion magique");
			}
		}
		else {
			parler("D�sol� "+gaulois.getNom()+" il n'y a plus une seule goutte de potion");
		}
	}
	public String getNom() {
		return nom;
	}
	
}
