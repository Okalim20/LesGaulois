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
	
	private Boolean isInvariantVerified() {
		return this.force>=0;
	}
	
	public static void main(String[] args) {
		System.out.println(Equipement.CASQUE);
		Romain minus = new Romain("Minus",6);
		assert minus.isInvariantVerified();
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
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de"+ forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null &&
						equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
			}
			parler(texte);
			forceCoup -= resistanceEquipement;
			return forceCoup;
		}
		private Equipement[] ejecterEquipement() {
			Equipement[] equipementEjecte = new Equipement[nbEquipement];
			System.out.println("L'équipement de " + nom.toString() + " s'envole sous Sla force du coup.");

			int nbEquipementEjecte = 0;
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null) {
					equipementEjecte[nbEquipementEjecte] = equipements[i];
					nbEquipementEjecte++;
					equipements[i] = null;
				}
			}
			return equipementEjecte;
		}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		switch (force) {
		case 0:
			parler("Aïe");
			break;
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		return equipementEjecte;
		}

	public int getForce() {
		
		return force;
	}
	
//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup>=0;
//		int tempForce=force;
//		force = force - forceCoup;
//		if (force < 1) {
//			parler("J'abandonnne !");
//		}
//		else {
//			parler("Aie !");
//		}
//		assert force<tempForce;
//	}
}
