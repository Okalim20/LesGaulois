package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion=1;
	private Village village;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	
	
	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole () {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		
		romain.recevoirCoup((force*effetPotion) / 3);
		if (effetPotion>1) {
			effetPotion-=1;
		}
	}
	public void sePresenter() {
		if (this.village!=null) {
			if (this==this.village.getChef()) {
				parler("Bonjour, je m'appelle "+ nom + " . Je suis le chef du village "+ this.village.getNom());
				
			}
			else {
				parler("Bonjour, je m'appelle "+ nom + " . J'habite le village "+ this.village.getNom());
	
			}
		}
		else {
			parler("Bonjour, je m'appelle "+ nom + " . Je voyage de villages en villages.");

		}
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion=forcePotion;
	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		System.out.println(asterix);
	}
	

}
