package com.formation.rest;

import java.time.LocalDate;
import java.time.Period;

enum TypeEquipement {
	FIXE, PORTABLE
}

/**
 * 
 * @author Hassan Essabir
 * @version V18.04
 *
 */
public abstract class Equipement {
	private int identifiant;
	private String numeroSerie;
	private String marque;
	private String modele;
	private LocalDate dateAchat;
	private float prixAchat;
	private int garantie;
	private TypeEquipement type;
	private final static double TAUX = 1.20;

	public Equipement() {
		super();
	}

	public Equipement(String marque, String modele) {
		super();
		this.marque = marque;
		this.modele = modele;
	}

	public Equipement(int identifiant, String numeroSerie, String marque, String modele, LocalDate dateAchat2,
			float prixAchat, int garantie, TypeEquipement type) {
		super();
		this.identifiant = identifiant;
		this.numeroSerie = numeroSerie;
		this.marque = marque;
		this.modele = modele;
		this.dateAchat = dateAchat2;
		this.prixAchat = prixAchat;
		this.garantie = garantie;
		this.type = type;
	}

	public String afficheDetailGarantie() {
		String detailGarantie = null;
		switch (this.garantie) {
		case 5:
			detailGarantie = "Garantie Etendue";
			break;
		case 3:
			detailGarantie = "Garantie Normale";
			break;
		case 1:
			detailGarantie = "Garantie Minimale";
			break;
		case 0:
			detailGarantie = "Aucune Garantie";
			break;
		}
		return detailGarantie;
	}

	public boolean isGarantieExpiree() {
		boolean isGarantieExpiree = false;
		// Calendar finGarantie = Calendar.getInstance();
		// finGarantie.setTime(this.dateAchat);
		// finGarantie.add(Calendar.YEAR, garantie);
		// Date dateFinGarantie = finGarantie.getTime();
		// Date toDay = new Date();
		// long diff = Math.abs(dateFinGarantie.getTime() - toDay.getTime());
		// long depassement = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

		LocalDate dateFinGarantie = this.dateAchat.plusYears(getGarantie());
		LocalDate toDay = LocalDate.now();

		final Period periode = Period.between(dateFinGarantie, LocalDate.now());

		if (dateFinGarantie.isAfter(toDay)) {
			// System.out.println("Garantie valable pour " + depassement + " jours");
			System.out.println("Garantie valable pour " + periode.getYears() + " années " + periode.getMonths()
					+ " mois " + periode.getDays() + " jours");
			isGarantieExpiree = false;

		} else {
			// System.out.println("Garantie expirée depuis " + depassement + " jours");
			System.out.println("Garantie valable pour " + periode.getYears() + " années " + periode.getMonths()
					+ " mois " + periode.getDays() + " jours");
			isGarantieExpiree = true;
		}

		return isGarantieExpiree;
	}

	public String toCSV() {
		return identifiant + ";" + numeroSerie + ";" + marque + ";" + modele + ";" + dateAchat + ";" + prixAchat + ";"
				+ garantie + ";" + type + ";" + "\n";
	}

	public static double conversionUSD(double prix) {
		return prix * TAUX;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public LocalDate getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(LocalDate date) {
		this.dateAchat = date;
	}

	public float getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(float prixAchat) {
		this.prixAchat = prixAchat;
	}

	public int getGarantie() {
		return garantie;
	}

	public void setGarantie(int garantie) {
		this.garantie = garantie;
	}

	public TypeEquipement getType() {
		return type;
	}

	public void setType(TypeEquipement type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Equipement [identifiant=" + identifiant + ", numeroSerie=" + numeroSerie + ", marque=" + marque
				+ ", modele=" + modele + ", dateAchat=" + dateAchat + ", prixAchat=" + prixAchat + "|"
				+ conversionUSD(prixAchat) + ", garantie=" + garantie + ", type=" + type + "]";
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	// public Equipement(int identifiant, String numeroSerie, String marque,
	// String modele, Date dateAchat, float prixAchat, int garantie,
	// TypeEquipement type) {
	// super();
	// this.identifiant = identifiant;
	// this.numeroSerie = numeroSerie;
	// this.marque = marque;
	// this.modele = modele;
	// this.dateAchat = dateAchat;
	// this.prixAchat = prixAchat;
	// this.garantie = garantie;
	// this.type = type;
	// }
	//
	// public Equipement(String marque, String modele) {
	// super();
	// this.marque = marque;
	// this.modele = modele;
	// }
	//
	// public Equipement(String marque, String modele, Date dateAchat) {
	// super();
	// this.marque = marque;
	// this.modele = modele;
	// this.dateAchat = dateAchat;
	// }
	//
	// public Equipement(String marque, String modele, Date dateAchat,
	// float prixAchat) {
	// super();
	// this.marque = marque;
	// this.modele = modele;
	// this.dateAchat = dateAchat;
	// this.prixAchat = prixAchat;
	// }
	//
	// public Equipement(String marque, String modele, Date dateAchat,
	// float prixAchat, int garantie) {
	// super();
	// this.marque = marque;
	// this.modele = modele;
	// this.dateAchat = dateAchat;
	// this.prixAchat = prixAchat;
	// this.garantie = garantie;
	// }
	//
	// public Equipement() {
	// super();
	// }
	//
	// @Override
	// public String toString() {
	// return "Equipement [identifiant=" + identifiant + ", numeroSerie="
	// + numeroSerie + ", marque=" + marque + ", modele=" + modele
	// + ", dateAchat=" + Outils.getDateFmt(dateAchat)
	// + ", prixAchat=" + Outils.getPrixFmt(prixAchat) + "|"
	// + Outils.getPrixFmt(conversionUSD(prixAchat)) + ", garantie="
	// + garantie + ", type=" + getType() + ", "
	// + Outils.composeUniqueID(Equipement.this) + "]";
	// }
	//
	// public TypeEquipement getType() {
	// return type;
	// }
	//
	// public void setType(TypeEquipement type) {
	// this.type = type;
	// }
	//

}
