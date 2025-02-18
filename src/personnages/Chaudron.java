package personnages;

public class Chaudron {
	private int quantitePotion=0;
	private int forcePotion=0;
	
	/*public Chaudron(int quantitePotion, int forcePotion) {
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}*/
	
	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion=quantite;
		this.forcePotion=forcePotion;
	}
	
	public boolean resterPotion() {
		return quantitePotion>0;
	}
	
	public int prendreLouche() {
		if (resterPotion()) {
			return forcePotion;
		}
		else {
			return 0;
		}
	}
	
}
