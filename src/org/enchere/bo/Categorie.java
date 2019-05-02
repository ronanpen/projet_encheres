package org.enchere.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Categories")
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no_categorie")
	private Integer idCategorie;
	private String libelle;

	/**
	 * @return the idCategorie
	 */
	public Integer getIdCategorie() {
		return idCategorie;
	}

	/**
	 * @param idCategorie
	 *            the idCategorie to set
	 */
	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public Categorie() {}

	/**
	 * @param libelle
	 */
	public Categorie(String libelle) {
		this.libelle = libelle;
	}
	
	/**
	 * @param idCategorie
	 * @param libelle
	 */
	public Categorie(Integer idCategorie, String libelle) {
		this.idCategorie = idCategorie;
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", libelle=" + libelle + "]";
	}

}
