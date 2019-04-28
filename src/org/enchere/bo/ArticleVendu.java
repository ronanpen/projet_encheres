package org.enchere.bo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name="Article_vendus")
public class ArticleVendu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="no_article")
	private Integer idArticle;
	@Column(name="nom_article")
	private String nomArticle;
	private String description;
	@Column(name="date_debut_encheres")
	private LocalDate dateDebutEncheres;
	@Column(name="date_fin_encheres")
	private LocalDate dateFinEncheres;
	@Column(name="prix_initial")
	private float miseAPrix;
	@Column(name="prix_vente")
	private Float prixVente;
	@ManyToMany
	@JoinColumn(name="no_utilisateur")
	@Column(name="no_utilisateur")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="no_categorie")
	@Column(name="no_categorie")
	private Categorie categorie;
	
	public ArticleVendu(Integer idArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, float miseAPrix, Float prixVente, Utilisateur utilisateur, Categorie categorie) {
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}
	
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			float miseAPrix, Float prixVente, Utilisateur utilisateur, Categorie categorie) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}



	public Integer getIdArticle() {
		return idArticle;
	}
	
	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}
	
	public String getNomArticle() {
		return nomArticle;
	}
	
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	
	public float getMiseAPrix() {
		return miseAPrix;
	}
	
	public void setMiseAPrix(float miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	
	public Float getPrixVente() {
		return prixVente;
	}
	
	public void setPrixVente(Float prixVente) {
		this.prixVente = prixVente;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "ArticleVendu [idArticle=" + idArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", utilisateur=" + utilisateur + ", categorie=" + categorie
				+ "]";
	}
}
