package personnages;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private Gaulois chef;
	
	public Village(String nom, int nbvillageoismax, Gaulois chef) {
		this.nom = nom;
		this.villageois = new Gaulois[nbvillageoismax];
		this.chef = chef;
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois doublepolemix = new Gaulois("DoublePolémix", 4);
		Village village = new Village("Village des Irréductibles", 30, abraracourcix);
		//Gaulois gaulois = village.trouverVillageois(30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(abraracourcix);
		village.ajouterVillageois(asterix);
		village.ajouterVillageois(obelix);;
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillage();
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
		
	}
	
	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return chef;
	}
	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois]=gaulois;
		nbVillageois++;
		gaulois.setVillage(this);
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois>nbVillageois) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
		else {
			return villageois[numVillageois-1];
		}
	}
	
	public void afficherVillage() {
		System.out.println("Dans le village :"+ nom+ " du chef " + chef.getNom() + " vivent les légendaires gaulois : ");
		for (Gaulois gaulois : villageois) {
			if (gaulois != null) {
				System.out.println("- "+gaulois.getNom());

			}
		}
	}
}
