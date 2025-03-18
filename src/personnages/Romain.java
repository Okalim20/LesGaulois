package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements= new Equipement[2];
	private int nbEquipement=0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(Equipement.CASQUE);
		Romain minus = new Romain("Minus",6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
		
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	private void equip(Equipement equipement) {
		equipements[nbEquipement]=equipement;
		System.out.println("Le soldat "+nom+" s'équipe avec un "+equipement);
		nbEquipement+=1;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (this.nbEquipement) {
		case 2 :
			System.out.println("Le soldat "+nom+" est déjà bien équipé");
			break;
		case 1 :
			if (equipements[0]==equipement) {
				System.out.println("Le soldat "+nom+" possède déjà un "+equipement+" !");
			}
			else {
				equip(equipement);
			}
			break;
		default :
			equip(equipement);
		}
	}
	
	
	public void recevoirCoup(int forceCoup) {
		force = force - forceCoup;
		if (force < 1) {
			parler("J'abandonnne !");
		}
		else {
			parler("Aie !");
		}
		
	}
}
