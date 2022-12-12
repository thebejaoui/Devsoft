package com.Dossierclient.assuré;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;




@Entity
public class Assure implements Serializable{
	private static final long serialVersionUID = 6711457437559348053L;
	
	@Id
	@GeneratedValue
	private int ida;
	private String nom, prenom,adresse;
	public int getIda() {
		return ida;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getadresse() {
		return adresse;
	}
	public void setadresse(String adresse) {
		this.adresse = adresse;
	}
	public Assure() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assure(String nom) {
		super();
		this.nom = nom;
	}
	

}
